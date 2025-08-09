package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class TestCommand {

    public static CommandData getCommandData() {
        return Commands.slash("test", "A test of 10 random questions")
                .addOption(OptionType.INTEGER, "num-of-questions", "The number of questions to test. Defaults to 10 if you leave blank", false)
                .addOption(OptionType.INTEGER, "specific-unit", "The specific unit you would like to be tested on. Defaults to random units if you leave blank", false);
    }

    public static void execute(SlashCommandInteractionEvent event) {

        if (event.getUser().isBot()) { return; }
        EmbedBuilder embed = new EmbedBuilder();
        // Eventually do stuff here lol
    }

}
