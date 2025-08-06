package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class HelpCommand {

    public static CommandData getCommandData() {
        return Commands.slash("help", "Displays a help page for users");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("📚 AP CSA StudyBot Help")
                .setDescription("Thank you for using the **AP CSA StudyBot**! Here's how to use this bot:")
                .addField("🔹 `!unit1`, `!unit2`, etc.",
                        "Get a practice question from the specified unit. For example, `!unit1` gives you a question from Unit 1.",
                        false)
                .addField("🧪 `(currently in developement) !unit1test`, `!unit2test`, etc.",
                        "Generates a mini test from that unit. For example, `!unit1test` gives you a short test from Unit 1.",
                        false)
                .addField("🎲 `(currently in development) !test`",
                        "Get a randomized test from *all* units. A great way to prepare for the AP exam!",
                        false)
                .setColor(0x1E90FF) // DodgerBlue color
                .setFooter("Good luck studying!", null);

        event.replyEmbeds(embed.build()).queue();
    }


}
