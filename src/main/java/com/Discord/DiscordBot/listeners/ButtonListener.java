package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.Units.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ButtonListener extends ListenerAdapter {

    public static Map<User, Question> incorrectUserQuestions = new HashMap<>();
    public static Map<User, String> incorrectUserAnswers = new HashMap<>();

    @Override
    public void onButtonInteraction(@NotNull ButtonInteractionEvent event) {
        String buttonId = event.getComponentId();
        User user = event.getUser();

        if (user.isBot()) return;

        // Defer the reply immediately to prevent interaction failure
        event.deferEdit().queue();

        try {
            if (buttonId.startsWith("answer_")) {
                handleAnswer(event, user, buttonId);
            } else if (buttonId.equals("new_question")) {
                handleNewQuestion(event, user);
            } else if (buttonId.equals("review_question")) {
                handleReviewQuestion(event, user);
            }
        } catch (Exception e) {
            event.getHook().sendMessage("An error occurred while processing your request.")
                    .setEphemeral(true).queue();
            event.getChannel().sendMessage("YOU HAVE A MASSIVE BUG: " + e).queue();
        }
    }

    private void handleAnswer(ButtonInteractionEvent event, User user, String buttonId) {
        if (!ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.getHook().sendMessage("You don't have an active question. Use `!unit1, !unit2, !unit3, or !unit4` to get started!")
                    .setEphemeral(true).queue();
            return;
        }

        String answer = buttonId.substring("answer_".length());
        Question question = ActiveQuestionTracker.getActiveQuestion(user);
        boolean isCorrect = Unit1.checkAnswer(question, answer);

//        if (!isCorrect) {
        // I know this says incorrect, but this just stores the user's previous
        // questions and answers for possible review lol
            incorrectUserQuestions.put(user, question);
            incorrectUserAnswers.put(user, answer);
//        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(isCorrect ? "Correct Answer! 🎉" : "Incorrect Answer ❌")
                .setColor(isCorrect ? Color.GREEN : Color.RED)
                .setDescription(isCorrect
                        ? "**Well done!** You got it right!"
                        : "**Oops,** You made a little mistake!")
                .addField("", // Empty field name
                        "Your answer: " + String.format("||%s) %s||",
                                incorrectUserAnswers.get(user).toUpperCase(),
                                getAnswerText(question, incorrectUserAnswers.get(user))) +
                                "\n" + // Newline instead of a new field
                                "Correct answer: " + String.format("||%s) %s||",
                                question.getCorrectAnswer(),
                                getAnswerText(question, question.getCorrectAnswer())),
                        false
                );

        MessageEditBuilder messageBuilder = new MessageEditBuilder()
                .setEmbeds(embedBuilder.build());

        if (!isCorrect) {
            messageBuilder.setActionRow(
                    Button.primary("new_question", "Try Another Question"),
                    Button.danger("review_question", "Review Question")
            );
        } else {
            messageBuilder.setActionRow(
                    Button.primary("new_question", "Try Another Question")
            );
        }

        event.getHook().editOriginal(messageBuilder.build()).queue();
        ActiveQuestionTracker.removeActiveQuestion(user);
    }

    private void handleReviewQuestion(ButtonInteractionEvent event, User user) {
        Question question = incorrectUserQuestions.get(user);
        if (question == null) {
            event.getHook().sendMessage("No previous incorrect question to review.")
                    .setEphemeral(true).queue();
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Question Review")
                .setColor(Color.YELLOW)
                .setDescription(question.getQuestion())
                .addField("A)", question.getOptionA(), false)
                .addField("B)", question.getOptionB(), false)
                .addField("C)", question.getOptionC(), false)
                .addField("D)", question.getOptionD(), false)
                .addField("", // Empty field name
                        "Your answer: " + String.format("||%s) %s||",
                                incorrectUserAnswers.get(user).toUpperCase(),
                                getAnswerText(question, incorrectUserAnswers.get(user))) +
                                "\n" + // Newline instead of a new field
                                "Correct answer: " + String.format("||%s) %s||",
                                question.getCorrectAnswer(),
                                getAnswerText(question, question.getCorrectAnswer())),
                        false
                );

        MessageEditBuilder messageBuilder = new MessageEditBuilder()
                .setEmbeds(embedBuilder.build());
        messageBuilder.setActionRow(
                Button.primary("new_question", "Try Another Question"));

        event.getHook().editOriginal(messageBuilder.build()).queue();
        incorrectUserAnswers.remove(user);
        incorrectUserQuestions.remove(user);
    }

    private void handleNewQuestion(ButtonInteractionEvent event, User user) {
        if (incorrectUserAnswers.get(user) != null) { // Should be both
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
        }
        Question question = QuestionBank.getRandomQuestion(QuestionBank.getUnit1Questions());
        if (question == null) {
            event.getHook().sendMessage("No more questions available for Unit 1.")
                    .setEphemeral(true).queue();
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Unit 1 Question")
                .setColor(Color.BLUE)
                .setDescription(question.getQuestion())
                .addField("A)", question.getOptionA(), false)
                .addField("B)", question.getOptionB(), false)
                .addField("C)", question.getOptionC(), false)
                .addField("D)", question.getOptionD(), false);

        event.getChannel().sendMessageEmbeds(embedBuilder.build())
                .addActionRow(
                        Button.primary("answer_A", "A"),
                        Button.primary("answer_B", "B"),
                        Button.primary("answer_C", "C"),
                        Button.primary("answer_D", "D")
                )
                .queue(sentMessage -> {
                    ActiveQuestionTracker.addActiveQuestion(user, question, sentMessage.getIdLong());
                });
    }

    private String getAnswerText(Question question, String option) {
        return switch (option.toUpperCase()) {
            case "A" -> question.getOptionA();
            case "B" -> question.getOptionB();
            case "C" -> question.getOptionC();
            case "D" -> question.getOptionD();
            default -> "";
        };
    }
}