package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.Units.ActiveQuestionTracker;
import com.Discord.DiscordBot.Units.Question;
import com.Discord.DiscordBot.Units.QuestionBank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import static com.Discord.DiscordBot.Constants.numUnits;
import static com.Discord.DiscordBot.listeners.ButtonListener.*;
import static com.Discord.DiscordBot.listeners.ButtonListener.incorrectMessageIds;

public class UnitsCommand {

    public static CommandData getCommandData() {
        return Commands.slash("question", "A random AP CSA question")
                .addOptions(
                        new OptionData(OptionType.INTEGER, "unit", "The unit you would like to study. Leave blank to be tested on a random unit.", false)
                                .addChoice("Unit 1", 1)
                                .addChoice("Unit 2", 2)
                                .addChoice("Unit 3", 3)
                                .addChoice("Unit 4", 4)
                );
    }

    public static void execute(SlashCommandInteractionEvent event) {
        int unit = (int)(Math.random()*numUnits)+1; // random unit for now
        if (event.getOption("unit") != null) {
            unit = Objects.requireNonNull(event.getOption("unit")).getAsInt();
            if (1 > unit || unit > 4) {
                event.reply(String.format("Unit %d is not a unit in AP CSA! Please choose a unit 1-%d.", unit, Constants.numUnits)).setEphemeral(true).queue();
                return;
            }
        }

        ArrayList<Question> specificQuestionList = QuestionBank.getSpecificQuestionMethod(unit);
        sendUnit(event, event.getUser(), unit, specificQuestionList);
    }



    // Stealing the HandleUnitCommand thing, but changing MessageRecievedEvent to SlashCommand
    public static void sendUnit(SlashCommandInteractionEvent event, User user, int unit, ArrayList<Question> specificQuestionList) {
        // Check for active question
        if (ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.reply(user.getAsMention() + ", you already have an active question! Please answer that first.")
                    .setEphemeral(true)
                    .queue();
            return;
        }

        // Get previous question ID if exists
        int prevQuestion = incorrectUserQuestions.get(user) != null
                ? incorrectUserQuestions.get(user).getQuestionId() : -1;

        // Clean up previous question data if exists
        if (incorrectUserAnswers.get(user) != null) {
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
            incorrectMessageIds.entrySet().removeIf(entry -> entry.getValue().equals(user));
        }

        // Get new question
        Question question = QuestionBank.getRandomQuestion(specificQuestionList, prevQuestion);
        if (question == null) {
            event.reply(String.format("No questions available for Unit %s", unit))
                    .setEphemeral(true)
                    .queue();
            return;
        }

        // Double-cleanup (same as original)
        if (incorrectUserAnswers.get(user) != null) {
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
            incorrectMessageIds.entrySet().removeIf(entry -> entry.getValue().equals(user));
        }

        // Build question embed
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(String.format("Unit %s Question (%s)", unit, question.getQuestionDifficulty()))
                .setColor(Color.BLUE)
                .setDescription(question.getQuestion())
                .addField("Options:",
                        "A) " + question.getOptionA() + "\n" +
                                "B) " + question.getOptionB() + "\n" +
                                "C) " + question.getOptionC() + "\n" +
                                "D) " + question.getOptionD(),
                        false)
                .setFooter(String.format("Choose the correct answer below (ID: %d)", question.getQuestionId()));

        // Build message with buttons
        MessageCreateBuilder messageBuilder = new MessageCreateBuilder()
                .setEmbeds(embedBuilder.build())
                .addActionRow(
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_A", "A"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_B", "B"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_C", "C"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_D", "D")
                );

        // Send as reply
        event.reply(messageBuilder.build())
                .setEphemeral(false) // Make visible to everyone
                .queue(interactionHook -> {
                    interactionHook.retrieveOriginal().queue(message -> {
                        ActiveQuestionTracker.addActiveQuestion(user, question, message.getIdLong(), question.getQuestionId(), event.getChannelIdLong());
                    });
                });
    }

}
