package com.Discord.DiscordBot.Units;

import com.Discord.DiscordBot.listeners.ButtonListener;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;

import java.awt.*;
import java.util.ArrayList;

import static com.Discord.DiscordBot.listeners.ButtonListener.incorrectUserAnswers;
import static com.Discord.DiscordBot.listeners.ButtonListener.incorrectUserQuestions;

public class HandleUnitsCommand {

    // This should be for all 4 units. Parameters the unit()
    public static void execute(MessageReceivedEvent event, User user, int unit, ArrayList<Question> specificQuestionList) {
        if (ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.getChannel().sendMessage(user.getAsMention() + ", you already have an active question! Please answer that first.").queue();
            return;
        }

        if (incorrectUserAnswers.get(user) != null) { // Should always remove last
            incorrectUserAnswers.remove(user);
            incorrectUserQuestions.remove(user);
        }

        Question question = QuestionBank.getRandomQuestion(specificQuestionList);
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
                .setTitle(String.format("Unit %s Question", unit))
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

        event.getChannel().sendMessage(messageBuilder.build()).queue(msg -> {
            ActiveQuestionTracker.addActiveQuestion(user, question, msg.getIdLong(), question.getQuestionId());
        });
    }

}
