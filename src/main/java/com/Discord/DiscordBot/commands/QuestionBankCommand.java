package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class QuestionBankCommand {

    public static CommandData getCommandData() {
        return Commands.slash("question-bank", "returns a page of all questions");
    }

    public static void execute(SlashCommandInteractionEvent event) {

    }

}
