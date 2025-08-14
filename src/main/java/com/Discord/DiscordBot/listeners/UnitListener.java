package com.Discord.DiscordBot.listeners;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.TextCommands.InfoTextCommand;
import com.Discord.DiscordBot.TextCommands.QuestionBankTextCommand;
import com.Discord.DiscordBot.TextCommands.ResourcesTextCommand;
import com.Discord.DiscordBot.Units.*;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class UnitListener extends ListenerAdapter {

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        User user = event.getAuthor();
        String message = event.getMessage().getContentRaw().trim();

        if (user.isBot()) return;

        if (message.equalsIgnoreCase(Constants.prefix + "1")) {
            HandleUnitsCommand.execute(event, user, 1, QuestionBank.getUnit1Questions());
        } else if (message.equalsIgnoreCase(Constants.prefix + "2")) {
            HandleUnitsCommand.execute(event, user, 2, QuestionBank.getUnit2Questions());
        } else if (message.equalsIgnoreCase(Constants.prefix + "3")) {
            HandleUnitsCommand.execute(event, user, 3, QuestionBank.getUnit3Questions());
        } else if (message.equalsIgnoreCase(Constants.prefix + "4")) {
            HandleUnitsCommand.execute(event, user, 4, QuestionBank.getUnit4Questions());
        }

        // Less important commands
        if (message.equalsIgnoreCase(Constants.prefix + "-info")) {
            InfoTextCommand.execute(event);
        } else if (message.equalsIgnoreCase(Constants.prefix + "-questionbank")) {
            QuestionBankTextCommand.execute(event);
        } else if (message.equalsIgnoreCase(Constants.prefix + "-resources")) {
            ResourcesTextCommand.execute(event);
        }

        // otherwise do nothing
    }


}