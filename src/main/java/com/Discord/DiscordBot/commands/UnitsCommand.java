package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Units.ActiveQuestionTracker;
import com.Discord.DiscordBot.Units.Question;
import com.Discord.DiscordBot.Units.QuestionBank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

import static com.Discord.DiscordBot.listeners.ButtonListener.incorrectUserAnswers;
import static com.Discord.DiscordBot.listeners.ButtonListener.incorrectUserQuestions;

public class UnitsCommand {

    private static int numUnits = 4;

    public static CommandData getCommandData() {
        return Commands.slash("question", "A random AP CSA question")
                .addOption(OptionType.INTEGER, "unit", "The unit you would like to study (1-4). Leave blank if you want a random question.", false);
    }

    public static void execute(SlashCommandInteractionEvent event) {
        int unit = (int)(Math.random()*numUnits)+1; // random unit for now
        if (event.getOption("unit") != null) {
            unit = Objects.requireNonNull(event.getOption("unit")).getAsInt();
            if (1 > unit || unit > 4) {
                event.reply(String.format("Unit %d is not a unit in AP CSA! Please choose a unit 1-4.", unit)).setEphemeral(true).queue();
                return;
            }
        }

        ArrayList<Question> specificQuestionList = QuestionBank.getSpecificQuestionMethod(unit);
        sendUnit(event, event.getUser(), unit, specificQuestionList);
    }



    // Stealing the HandleUnitCommand thing, but changing MessageRecievedEvent to SlashCommand
    public static void sendUnit(SlashCommandInteractionEvent event, User user, int unit, ArrayList<Question> specificQuestionList) {
        if (ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.getChannel().sendMessage(user.getAsMention() + ", you already have an active question! Please answer that first.").queue();
            return;
        }

        int prevQuestion = incorrectUserQuestions.get(user) != null
                ? incorrectUserQuestions.get(user).getQuestionId() : -1;

        if (incorrectUserAnswers.get(user) != null) { // Should always remove last
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
        }

        Question question = QuestionBank.getRandomQuestion(specificQuestionList, prevQuestion);
        if (question == null) {
            event.getChannel().sendMessage(String.format("No questions available for Unit %s", unit)).queue();
            return;
        }

        // Just checks in case somehow the answers werent removed previously cause it is new question
        // Jk, this is needed now since only removing when asking a next question
        if (incorrectUserAnswers.get(user) != null) { // Should be both
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
        }

        // Create question embed
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle(String.format("Unit %s Question (%s)", unit, question.getQuestionDifficulty()))
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

        // Create message with buttons
        MessageCreateBuilder messageBuilder = new MessageCreateBuilder()
                .setEmbeds(embedBuilder.build())
                .addActionRow( // I'm too lazy to get the real addActionRow thing lol, change that later
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_A", "A"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_B", "B"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_C", "C"),
                        net.dv8tion.jda.api.interactions.components.buttons.Button.primary("answer_D", "D")
                );

        event.reply(messageBuilder.build()).queue(msg -> {
            ActiveQuestionTracker.addActiveQuestion(user, question, msg.getIdLong(), question.getQuestionId());
        });
    }

}
