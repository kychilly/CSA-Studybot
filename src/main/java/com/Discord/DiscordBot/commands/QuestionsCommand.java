package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Units.SendAvailableQuestionsCommand;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class QuestionsCommand {

    public static CommandData getCommandData() {
        return Commands.slash("csa-info", "gets information about the CSA questions and curriculum");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        SendAvailableQuestionsCommand.execute(event);
    }

}
