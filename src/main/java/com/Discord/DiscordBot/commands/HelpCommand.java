package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Constants;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class HelpCommand {

    public static CommandData getCommandData() {
        return Commands.slash(Constants.slashPrefix + "-help", "Displays a help page for users");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        EmbedBuilder embed = new EmbedBuilder();

        embed.setTitle("📚 AP " + Constants.slashPrefix.toUpperCase() + " StudyBot Help")
                .setDescription("Thanks for using the **AP " + Constants.slashPrefix.toUpperCase() + " StudyBot**! Here's a list of commands you can use!")

                .addField("📌 `" + Constants.prefix + "<number>`",
                        "Get a practice question from that AP CSA unit (1–" + Constants.numUnits + ").\nExample: `" + Constants.prefix + "1` → Unit 1 question.",
                        false)

                .addField("📌 `/" + Constants.slashPrefix + "-question`",
                        "Slash version of `" + Constants.prefix + "<number>`.\n**Optional parameter:** Unit number (1–" + Constants.numUnits + "). Leave blank for a random unit.\nExample: `/" + Constants.slashPrefix + "-question unit:2` → Unit 2 question.",
                        false)

                .addField("🧪 `/" + Constants.slashPrefix + "-test`",
                        "Start a mini-test.\n**Optional parameters:**\n1️⃣ Number of questions: 5, 10, 15, 20, or 50 (default: 10)\n2️⃣ Unit number (1–" + Constants.numUnits + "). Leave blank for all units.\nExample: `/" + Constants.slashPrefix + "-test number:5 unit:3` → Test with 5 questions from Unit 3.",
                        false)

                .addField("📚 `/" + Constants.slashPrefix + "-question-bank`",
                        "View the full question bank used by the bot.",
                        false)

                .addField("ℹ️ `/" + Constants.slashPrefix + "-info`",
                        "Get general info about the AP " + Constants.slashPrefix.toUpperCase() + " course.",
                        false)

                .addField("📖 `/" + Constants.slashPrefix + "-resources`",
                        "Get helpful study resources for AP CSA.",
                        false)

                .addField("💡 `/" + Constants.slashPrefix + "-help`",
                        "Show this help message again.",
                        false)

                .addField("\u200B", "\u200B", false)

                .addField("💬 Need help or have suggestions?",
                        "Contact <@840216337119969301> or email [jyam478@gmail.com](mailto:jyam478@gmail.com)\n\n" +
                                "💡💡💡 If you’re unsure how to use a command or need study help, feel free to type `/" + Constants.slashPrefix + "-ask <your question>` for a customized AI to guide you through your studies!\n" +
                                "Example: `/" + Constants.slashPrefix + "-ask <How do I use the /" + Constants.slashPrefix + "test command?>`",
                        false)

                .setColor(0x1E90FF) // DodgerBlue
                .setFooter("Good luck with your studies!!! \uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1", null);

        event.replyEmbeds(embed.build()).queue();
    }



}
