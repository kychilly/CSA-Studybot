package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Sessions.TestSession;
import com.Discord.DiscordBot.Units.Question;
import com.Discord.DiscordBot.Units.QuestionBank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.*;
import java.util.stream.Collectors;

public class TestCommand {
    private static final Map<Long, TestSession> activeTests = new HashMap<>();

    public static SlashCommandData getCommandData() {
        return Commands.slash("test", "Take a practice test with randomized questions")
                .addOptions(
                        new OptionData(OptionType.INTEGER, "num-questions", "Number of questions (default: 10)", false)
                                .setMinValue(1)
                                .setMaxValue(50),
                        new OptionData(OptionType.INTEGER, "unit", "Specific unit to test", false)
                                .addChoice("Unit 1", 1)
                                .addChoice("Unit 2", 2)
                                .addChoice("Unit 3", 3)
                                .addChoice("Unit 4", 4)
                );
    }

    public static void execute(SlashCommandInteractionEvent event) {
        if (event.getUser().isBot()) return;

        int numQuestions = event.getOption("num-questions") != null ?
                event.getOption("num-questions").getAsInt() : 10;
        Integer unit = event.getOption("unit") != null ?
                event.getOption("unit").getAsInt() : null;

        List<Question> questions = getQuestionsForUnit(unit, numQuestions);

        if (questions.isEmpty()) {
            event.reply("No questions available for the selected unit.").setEphemeral(true).queue();
            return;
        }

        TestSession session = new TestSession(questions);
        activeTests.put(event.getUser().getIdLong(), session);

        // Send initial message and store its ID in the session without blocking
        event.replyEmbeds(createTestEmbed(session))
                .setComponents(createActionRows(session))
                .queue(message -> {
                    message.retrieveOriginal().queue(original -> {
                        session.setMessageId(original.getIdLong());
                    });
                });
    }

    public static void handleButtonInteraction(ButtonInteractionEvent event) {
        long userId = event.getUser().getIdLong();
        if (!activeTests.containsKey(userId)) {
            event.reply("You don't have an active test session or it has expired.")
                    .setEphemeral(true).queue();
            return;
        }

        TestSession session = activeTests.get(userId);
        String buttonId = event.getComponentId();

        if (session.isSubmitted() && !buttonId.startsWith("test_review_") && !buttonId.equals("test_results_review")) {
            event.reply("This test has already been submitted. Use the review button to see your answers.")
                    .setEphemeral(true).queue();
            return;
        }

        switch (buttonId) {
            case "test_prev":
                session.previousQuestion();
                updateTestMessage(event, session);
                break;

            case "test_next":
                session.nextQuestion();
                updateTestMessage(event, session);
                break;

            case "test_submit":
                session.setSubmitted(true);
                showTestResults(event, session);
                break;

            case "test_preview_review":  // Preview button (before submission)
                showPreviewReview(event, session);
                break;

            case "test_preview_prev":
                session.previousQuestion();
                showPreviewReview(event, session);
                break;

            case "test_preview_next":
                session.nextQuestion();
                showPreviewReview(event, session);
                break;

            case "test_preview_back":
                updateTestMessage(event, session);
                break;

            case "test_results_review":  // Full review button (after submission)
                session.setCurrentIndex(0); // Reset to first question
                showFullReview(event, session);
                break;

            case "test_review_prev":
                session.previousQuestion();
                showFullReview(event, session);
                break;

            case "test_review_next":
                session.nextQuestion();
                showFullReview(event, session);
                break;

            case "test_review_close":
                showTestResults(event, session);
                break;

            default:
                if (buttonId.startsWith("test_answer_")) {
                    String answer = buttonId.substring("test_answer_".length());
                    session.setAnswer(session.getCurrentIndex(), answer.toUpperCase());
                    updateTestMessage(event, session);
                }
        }
    }

    private static void updateTestMessage(ButtonInteractionEvent event, TestSession session) {
        event.getHook().editOriginalEmbeds(createTestEmbed(session))
                .setComponents(createActionRows(session))
                .queue();
    }

    private static void showTestResults(ButtonInteractionEvent event, TestSession session) {
        int score = session.calculateScore();
        int total = session.getTotalQuestions();
        double percentage = (double) score / total * 100;

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Test Results")
                .setDescription(String.format("You scored **%d/%d** (%.1f%%)", score, total, percentage))
                .setColor(percentage >= 70 ? 0x00FF00 : 0xFF0000);

        // Now show the full review button
        Button reviewButton = Button.secondary("test_results_review", "🔍 Review Test with Answers");

        event.getHook().editOriginalEmbeds(embed.build())
                .setComponents(ActionRow.of(reviewButton))
                .queue();
    }

    private static void showFullReview(ButtonInteractionEvent event, TestSession session) {
        int currentIndex = session.getCurrentIndex();
        Question question = session.getQuestions().get(currentIndex);
        String userAnswer = session.getUserAnswer(currentIndex);
        String correctAnswer = question.getCorrectAnswer();
        boolean isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Review - Question " + (currentIndex + 1) + "/" + session.getTotalQuestions())
                .setDescription(question.getQuestion())
                .addField("Your Answer", userAnswer != null ? userAnswer : "Not answered", false)
                .addField("Correct Answer", correctAnswer, false)
                .setColor(isCorrect ? 0x00FF00 : 0xFF0000)
                .setFooter(isCorrect ? "Correct!" : "Incorrect");

        List<Button> buttons = new ArrayList<>();

        if (currentIndex > 0) {
            buttons.add(Button.primary("test_review_prev", "◀ Previous"));
        }

        if (currentIndex < session.getTotalQuestions() - 1) {
            buttons.add(Button.primary("test_review_next", "Next ▶"));
        }

        buttons.add(Button.danger("test_review_close", "✖ Close"));

        event.getHook().editOriginalEmbeds(embed.build())
                .setComponents(ActionRow.of(buttons))
                .queue();
    }

    private static List<Question> getQuestionsForUnit(Integer unit, int count) {
        List<Question> questions;

        if (unit == null) {
            // Get questions from all units
            questions = new ArrayList<>(QuestionBank.getQuestionBank());
        } else {
            // Get questions from specific unit
            switch (unit) {
                case 1: questions = QuestionBank.getUnit1Questions(); break;
                case 2: questions = QuestionBank.getUnit2Questions(); break;
                case 3: questions = QuestionBank.getUnit3Questions(); break;
                case 4: questions = QuestionBank.getUnit4Questions(); break;
                default: return Collections.emptyList();
            }
        }

        // Shuffle and limit to requested count
        Collections.shuffle(questions);
        return questions.stream().limit(count).collect(Collectors.toList());
    }

    private static MessageEmbed createTestEmbed(TestSession session) {
        Question current = session.getCurrentQuestion();
        int currentIndex = session.getCurrentIndex();
        int total = session.getTotalQuestions();
        String userAnswer = session.getUserAnswer(currentIndex);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Question " + (currentIndex + 1) + " of " + total)
                .setDescription(current.getQuestion())
                .addField("A", current.getOptionA(), false)
                .addField("B", current.getOptionB(), false)
                .addField("C", current.getOptionC(), false)
                .addField("D", current.getOptionD(), false);

        if (userAnswer != null) {
            embed.setFooter("Your answer: " + userAnswer);
        }

        return embed.build();
    }

    private static void showReviewFromResults(ButtonInteractionEvent event, TestSession session) {
        // Create paginated review with navigation
        session.setCurrentIndex(0); // Start at first question
        showReviewQuestion(event, session);
    }

    private static void showReviewQuestion(ButtonInteractionEvent event, TestSession session) {
        int currentIndex = session.getCurrentIndex();
        Question question = session.getQuestions().get(currentIndex);
        String userAnswer = session.getUserAnswer(currentIndex);
        String correctAnswer = question.getCorrectAnswer();
        boolean isCorrect = correctAnswer.equalsIgnoreCase(userAnswer);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Review - Question " + (currentIndex + 1) + "/" + session.getTotalQuestions())
                .setDescription(question.getQuestion())
                .addField("Your Answer", userAnswer != null ? userAnswer : "Not answered", false)
                .addField("Correct Answer", correctAnswer, false)
                .setColor(isCorrect ? 0x00FF00 : 0xFF0000)
                .setFooter(isCorrect ? "You got this right!" : "This was incorrect");

        // Create navigation buttons
        List<Button> buttons = new ArrayList<>();

        if (currentIndex > 0) {
            buttons.add(Button.primary("test_review_prev", "◀ Previous"));
        }

        if (currentIndex < session.getTotalQuestions() - 1) {
            buttons.add(Button.primary("test_review_next", "Next ▶"));
        }

        buttons.add(Button.danger("test_review_close", "✖ Close Review"));

        event.getHook().editOriginalEmbeds(embed.build())
                .setComponents(ActionRow.of(buttons))
                .queue();
    }

    private static void showPreviewReview(ButtonInteractionEvent event, TestSession session) {
        int currentIndex = session.getCurrentIndex();
        Question question = session.getQuestions().get(currentIndex);
        String userAnswer = session.getUserAnswer(currentIndex);

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Preview - Question " + (currentIndex + 1) + "/" + session.getTotalQuestions())
                .setDescription(question.getQuestion())
                .addField("Your Answer", userAnswer != null ? userAnswer : "Not answered yet", false)
                .setFooter("Submit the test to see correct answers");

        // Navigation buttons
        List<Button> buttons = new ArrayList<>();

        if (currentIndex > 0) {
            buttons.add(Button.primary("test_preview_prev", "◀ Previous"));
        }

        if (currentIndex < session.getTotalQuestions() - 1) {
            buttons.add(Button.primary("test_preview_next", "Next ▶"));
        }

        buttons.add(Button.primary("test_preview_back", "↩ Back to Test"));

        event.getHook().editOriginalEmbeds(embed.build())
                .setComponents(ActionRow.of(buttons))
                .queue();
    }

    private static List<ActionRow> createActionRows(TestSession session) {
        List<Button> answerButtons = Arrays.asList(
                Button.secondary("test_answer_a", "A"),
                Button.secondary("test_answer_b", "B"),
                Button.secondary("test_answer_c", "C"),
                Button.secondary("test_answer_d", "D")
        );

        List<Button> navButtons = new ArrayList<>();
        if (session.getCurrentIndex() > 0) {
            navButtons.add(Button.primary("test_prev", "◀ Previous"));
        }
        if (session.getCurrentIndex() < session.getTotalQuestions() - 1) {
            navButtons.add(Button.primary("test_next", "Next ▶"));
        } else {
            navButtons.add(Button.success("test_submit", "✅ Submit Test"));
            navButtons.add(Button.secondary("test_preview_review", "👀 Preview Answers"));
        }

        return Arrays.asList(
                ActionRow.of(answerButtons),
                ActionRow.of(navButtons)
        );
    }

}