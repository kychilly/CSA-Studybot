package com.Discord.DiscordBot.TextCommands;

import com.Discord.DiscordBot.Units.SendAvailableQuestionsCommand;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class InfoTextCommand {

    public static void execute(MessageReceivedEvent event) {
        SendAvailableQuestionsCommand.execute(event);
    }

}
