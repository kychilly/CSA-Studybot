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
                .setDescription("Thanks for using the **AP CSA StudyBot**! Here's a list of commands you can use!")

                .addField("📌 `!unit<number>` or `!u<number>`",
                        "Get a practice question from that AP CSA unit (1–4).\nExample: `!u1` → Unit 1 question.",
                        false)

                .addField("📌 `/question`",
                        "Slash version of `!u<number>`.\n**Optional parameter:** Unit number (1–4). Leave blank for a random unit.\nExample: `/question unit:2` → Unit 2 question.",
                        false)

                .addField("🧪 `/test`",
                        "Start a mini-test.\n**Optional parameters:**\n1️⃣ Number of questions: 5, 10, 15, 20, or 50 (default: 10)\n2️⃣ Unit number (1–4). Leave blank for all units.\nExample: `/test number:5 unit:3` → 5 questions from Unit 3.",
                        false)

                .addField("📚 `/question-bank`",
                        "View the full question bank used by the bot.",
                        false)

                .addField("ℹ️ `/csa-info`",
                        "Get general info about the AP CSA course.",
                        false)

                .addField("📖 `/resources`",
                        "Get helpful study resources for AP CSA.",
                        false)

                .addField("💡 `/help`",
                        "Show this help message again.",
                        false)

                .addField("\u200B", "\u200B", false)

                .addField("💬 Need help or have suggestions?",
                        "Contact <@840216337119969301> or email [jyam478@gmail.com](mailto:jyam478@gmail.com)\n\n" +
                                "💡💡💡 If you’re unsure how to use a command or need study help, feel free to type `/ask <your question>` for a customized AI to guide you through your studies!\n" +
                                "Example: `/ask <How do I use the /test command?>`",
                        false)

                .setColor(0x1E90FF) // DodgerBlue(very cool color)
                .setFooter("Good luck with your studies!!! \uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1\uD83E\uDEE1", null);

        event.replyEmbeds(embed.build()).queue();
    }



}
