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

        if (message.equalsIgnoreCase("!unit1") || message.equalsIgnoreCase("!u1")) {
            HandleUnitsCommand.execute(event, user, 1, QuestionBank.getUnit1Questions());
        } else if (message.equalsIgnoreCase("!unit2")  || message.equalsIgnoreCase("!u2")) { // Unit 2, 3, and 4 not implemented yet
            HandleUnitsCommand.execute(event, user, 2, QuestionBank.getUnit2Questions());
        } else if (message.equalsIgnoreCase("!unit3")  || message.equalsIgnoreCase("!u3")) {
            HandleUnitsCommand.execute(event, user, 3, QuestionBank.getUnit3Questions());
        } else if (message.equalsIgnoreCase("!unit4")  || message.equalsIgnoreCase("!u4")) {
            HandleUnitsCommand.execute(event, user, 4, QuestionBank.getUnit4Questions());
        }

        // otherwise do nothing
    }


}