package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.Units.*;
import com.Discord.DiscordBot.commands.QuestionBankCommand;
import com.Discord.DiscordBot.commands.TestCommand;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

import static com.Discord.DiscordBot.Units.ActiveQuestionTracker.getUserByMessageId;
import static com.Discord.DiscordBot.Units.CheckQuestionAnswer.wrongAnswers;

public class ButtonListener extends ListenerAdapter {

    // The names really should be "previous questions choices"
    public static Map<User, Question> incorrectUserQuestions = new HashMap<>();
    public static Map<User, String> incorrectUserAnswers = new HashMap<>();
    public static Map<Long, User> incorrectMessageIds = new HashMap<>();


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
                handleNewQuestion(event, user); // Get this to get the unit you are currently on + bug here
            } else if (buttonId.equals("review_question")) {
                handleReviewQuestion(event, user);
            } else if (buttonId.startsWith("qbank_")) {
                QuestionBankCommand.handleButtonInteraction(event);
            } else if (buttonId.startsWith("test_")) {
                TestCommand.handleButtonInteraction(event);
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
        // Now, check if this is your active question
        if (!user.equals(getUserByMessageId(event.getMessage().getIdLong()))) { // Checks if the current user isnt equal to whatever the hashmap had in store for that specific message
            event.getHook().sendMessage("This is not your active question to answer!")
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
        incorrectMessageIds.put(event.getMessageIdLong(), user);
//        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(isCorrect ? "Correct Answer! 🎉" : "Incorrect Answer ❌")
                .setColor(isCorrect ? Color.GREEN : Color.RED)
                .setDescription(isCorrect
                        ? user.getAsMention() + " **Well done!** You got it right!"
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

//        if (!isCorrect) { Right now, able to put both buttons when answered question
            messageBuilder.setActionRow(
                    Button.primary("new_question", "Try Another Question"),
                    Button.danger("review_question", "Review Question")
            );
//        } else {
//            messageBuilder.setActionRow(
//                    Button.primary("new_question", "Try Another Question")
//            );
//        }

        event.getHook().editOriginal(messageBuilder.build()).queue();
        ActiveQuestionTracker.removeActiveQuestion(user, event.getMessageIdLong());
    }

    private void handleReviewQuestion(ButtonInteractionEvent event, User user) {

        Message message = event.getMessage();
        long messageID = message.getIdLong(); // This is the messageID of what the message the button was attached to was

        Question question = incorrectUserQuestions.get(user);
        if (question == null) {
            event.getHook().sendMessage("No previous question to review!")
                    .setEphemeral(true).queue();
            return;
        }
        if (!user.equals(incorrectMessageIds.get(messageID))) {
            event.getHook().sendMessage("This is not your question to review!")
                    .setEphemeral(true).queue();
            return;
        }

        int unit = question.getUnit();

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(String.format("Unit %d Question Review (%s)", unit, question.getQuestionDifficulty()))
                .setColor(Color.YELLOW)
                .setDescription(user.getAsMention() + ", " + question.getQuestion())
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

        // Checks to make sure before you get to click again, if you have an active question. If so, dont let them get a new question
        if (ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.getHook().sendMessage("You already have an active question! Please answer that first.")
                    .setEphemeral(false)
                    .queue();
            return;
        }

        // A bit of spagetti code, gets the same unit for the new question button
        // Implementing different question ID
        int unit;
        int prevQuestionId = -1;

        // Try to get last incorrect question
        Question previousQuestion = incorrectUserQuestions.get(user);
        if (previousQuestion != null) {
            unit = previousQuestion.getUnit();
            prevQuestionId = previousQuestion.getQuestionId();
        } else {
            // If no previous question, pick a random unit
            unit = (int)(Math.random() * Constants.numUnits) + 1;
        }

        Question question;
        if (unit == 1) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit1Questions(), prevQuestionId);
        } else if (unit == 2) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit2Questions(), prevQuestionId);
        } else if (unit == 3) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit3Questions(), prevQuestionId);
        } else if (unit == 4) {
            question = QuestionBank.getRandomQuestion(QuestionBank.getUnit4Questions(), prevQuestionId);
        } else {
            event.getChannel().sendMessage("I HAVE A MASSIVE BUG IN handleNewQuestion in ButtonListener. \nUnit is " + unit).queue();
            return;
        }

        if (incorrectUserAnswers.get(user) != null) { // Should always remove last(never null unless first interaction)
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
            // Also remove the user from incorrectMessageIds (needs a better method here)
            Long entryToRemove = -1L;
            for (Map.Entry<Long, User> entry : incorrectMessageIds.entrySet()) {
                if (entry.getValue().equals(user)) {
                    entryToRemove = entry.getKey();
                }
            }
            if (entryToRemove == -1L) {
                event.getChannel().sendMessage("MASSIVE BUG, PLEASE DONT DO WHATEVER U JUST DID LOL (line 210 of buttonListener handleNewQuestion").queue();
            }
            incorrectMessageIds.remove(entryToRemove);
        }


        if (question == null) {
            event.getHook().sendMessage("No more questions available for Unit 1.")
                    .setEphemeral(true).queue();
            return;
        }

        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(String.format("Unit %s Question (%s)", unit, question.getQuestionDifficulty()))
                .setColor(Color.BLUE)
                .setDescription(user.getAsMention() + ", " + question.getQuestion())
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
                    ActiveQuestionTracker.addActiveQuestion(user, question, sentMessage.getIdLong(), question.getQuestionId(), event.getChannelIdLong());
                });
    }

    public static String getAnswerText(Question question, String option) {
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