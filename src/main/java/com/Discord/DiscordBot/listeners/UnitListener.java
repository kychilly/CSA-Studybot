package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.Units.Question;
import com.Discord.DiscordBot.Units.QuestionBank;
import com.Discord.DiscordBot.Units.Unit1;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import static com.Discord.DiscordBot.Units.QuestionBank.getUnit1Questions;

public class UnitListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        String message = event.getMessage().getContentRaw();
        if (message.equalsIgnoreCase("!unit1")) {
            Question question = QuestionBank.getRandomQuestion(getUnit1Questions());
            event.getChannel().sendMessage(Unit1.getFormattedQuestion(question)).queue();
        }
    }

}
