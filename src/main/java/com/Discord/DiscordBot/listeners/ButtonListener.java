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

import static com.Discord.DiscordBot.Units.CheckQuestionAnswer.wrongAnswers;

public class ButtonListener extends ListenerAdapter {

    // The names really should be "previous questions choices"
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
                handleNewQuestion(event, user); // Get this to get the unit you are currently on
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
        boolean isCorrect = CheckQuestionAnswer.checkAnswer(question, answer);

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
                        ? user.getAsMention() + "**Well done!** You got it right!"
                        : getRandomWrongAnswer())
                .addField("", // Empty field name
                        "Your answer: " + String.format("||%s) %s||",
                                incorrectUserAnswers.get(user).toUpperCase(),
                                getAnswerText(question, incorrectUserAnswers.get(user))) +
                                "\n" + // Newline instead of a new field
                                "Correct answer: " + String.format("||%s) %s||",
                                question.getCorrectAnswer(),
                                getAnswerText(question, question.getCorrectAnswer())),
                        false
                )
                .setFooter(String.format("(ID: %d)", incorrectUserQuestions.get(user).getQuestionId()));

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

        int unit = question.getUnit();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(String.format("Unit %d Question Review", unit))
                .setColor(Color.YELLOW)
                .setDescription(question.getQuestion())
                .addField("Options:", // Single field or else sus choice placement
                        "A) " + question.getOptionA() + "\n" +
                                "B) " + question.getOptionB() + "\n" +
                                "C) " + question.getOptionC() + "\n" +
                                "D) " + question.getOptionD(),
                        false
                )
                .addField("", // Empty field name
                        "Your answer: " + String.format("||%s) %s||",
                                incorrectUserAnswers.get(user).toUpperCase(),
                                getAnswerText(question, incorrectUserAnswers.get(user))) +
                                "\n" + // Newline instead of a new field
                                "Correct answer: " + String.format("||%s) %s||",
                                question.getCorrectAnswer(),
                                getAnswerText(question, question.getCorrectAnswer())),
                        false
                )
                .setFooter(String.format("(ID: %d)", incorrectUserQuestions.get(user).getQuestionId()));

        MessageEditBuilder messageBuilder = new MessageEditBuilder()
                .setEmbeds(embedBuilder.build());
        messageBuilder.setActionRow(
                Button.primary("new_question", "Try Another Question"));

        event.getHook().editOriginal(messageBuilder.build()).queue();
//        incorrectUserAnswers.remove(user); temp removing, see if this works
//        incorrectUserQuestions.remove(user);
    }

    private void handleNewQuestion(ButtonInteractionEvent event, User user) {

        // A bit of spagetti code, gets the same unit for the new question button
        int unit = incorrectUserQuestions.get(user).getUnit();
        Question question;
        if (unit == 1) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit1Questions());
        } else if (unit == 2) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit2Questions());
        } else if (unit == 3) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit3Questions());
        } else if (unit == 4) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit4Questions());
        } else {
            event.getChannel().sendMessage("I HAVE A MASSIVE BUG IN handleNewQuestion in ButtonListener. \nUnit is " + unit).queue();
            return;
        }

        if (incorrectUserAnswers.get(user) != null) { // Should always remove last/never null
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
        }


        if (question == null) {
            event.getHook().sendMessage("No more questions available for Unit 1.")
                    .setEphemeral(true).queue();
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Unit 1 Question")
                .setColor(Color.BLUE)
                .setDescription(question.getQuestion())
                .addField("Options:", // Single field or else sus choice placement
                "A) " + question.getOptionA() + "\n" +
                        "B) " + question.getOptionB() + "\n" +
                        "C) " + question.getOptionC() + "\n" +
                        "D) " + question.getOptionD(),
                false
        )
                .setFooter(String.format("Choose the correct answer below (ID: %d)", question.getQuestionId()));

        event.getChannel().sendMessageEmbeds(embedBuilder.build())
                .addActionRow(
                        Button.primary("answer_A", "A"),
                        Button.primary("answer_B", "B"),
                        Button.primary("answer_C", "C"),
                        Button.primary("answer_D", "D")
                )
                .queue(sentMessage -> {
                    ActiveQuestionTracker.addActiveQuestion(user, question, sentMessage.getIdLong(), question.getQuestionId());
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

    private String getRandomWrongAnswer() {
        return wrongAnswers[((int)(Math.random()*wrongAnswers.length))];
    }
}