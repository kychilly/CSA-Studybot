package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.Units.*;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

public class UnitListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        User user = event.getAuthor();
        String message = event.getMessage().getContentRaw().trim();

        if (user.isBot()) return;

        if (message.equalsIgnoreCase("!unit1")) {
            handleUnit1Command(event, user);
        } else if (message.equalsIgnoreCase("!unit2")) {
            event.getChannel().sendMessage("Sorry! Unit 2 is not implemented yet!").queue();
        } else if (message.equalsIgnoreCase("!unit3")) {
            event.getChannel().sendMessage("Sorry! Unit 3 is not implemented yet!").queue();
        } else if (message.equalsIgnoreCase("!unit4")) {
            event.getChannel().sendMessage("Sorry! Unit 2=4 is not implemented yet!").queue();
        }
    }

    private void handleUnit1Command(MessageReceivedEvent event, User user) {
        if (ActiveQuestionTracker.hasActiveQuestion(user)) {
            event.getChannel().sendMessage("You already have an active question! Please answer that first.").queue();
            return;
        }

        Question question = QuestionBank.getRandomQuestion(QuestionBank.getUnit1Questions());
        if (question == null) {
            event.getChannel().sendMessage("No questions available for Unit 1.").queue();
            return;
        }

        // Create question embed
        EmbedBuilder embedBuilder = new EmbedBuilder()
                .setTitle("Unit 1 Question")
                .setColor(Color.BLUE)
                .setDescription(question.getQuestion())
                .addField("A)", question.getOptionA(), false)
                .addField("B)", question.getOptionB(), false)
                .addField("C)", question.getOptionC(), false)
                .addField("D)", question.getOptionD(), false)
                .setFooter("Choose the correct answer below");

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
            ActiveQuestionTracker.addActiveQuestion(user, question, msg.getIdLong());
        });
    }
}