package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.Units.SendAvailableQuestionsCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class InfoCommand {

    public static CommandData getCommandData() {
        return Commands.slash(Constants.slashPrefix + "-info", "gets information about the AP " + Constants.slashPrefix.toUpperCase() + " questions and curriculum");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        SendAvailableQuestionsCommand.execute(event);
    }

}
