package com.Discord.DiscordBot.Units;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class SendAvailableQuestionsCommand {

    // For message recieved
    public static void execute(MessageReceivedEvent event) {
        int sum = Unit1.numUnit1Questions + Unit2.numUnit2Questions
                + Unit3.numUnit3Questions + Unit4.numUnit4Questions;

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("📚 Available Practice Questions 📚");
        embed.setThumbnail("https://images-ext-1.discordapp.net/external/O91y0nM-QHluCrrKWyJaoTagrp9FvPlPzlggBaS-NZI/%3Fsize%3D4096/https/cdn.discordapp.com/avatars/1401736371508613120/054bf5ff6af1656b42f02def5333e6ed.png?format=webp&quality=lossless&width=768&height=768");
        embed.setColor(0x3498db); // Blue color

        embed.setDescription(String.format(
                "**Total Questions:** %d\n\nUse `!unit<number>` to start practicing!",
                sum
        ));

        embed.addField("**Unit 1:** Using Objects & Methods",
                String.format(
                        "🔹 **%d questions**\nFocuses on Strings, Math, method calls, and basic object interaction.\n\u200B",
                        Unit1.numUnit1Questions),
                false);

        embed.addField("**Unit 2:** Selection & Iteration",
                String.format(
                        "🔹 **%d questions**\nCovers if/else, boolean expressions, loops, and control flow.\n\u200B",
                        Unit2.numUnit2Questions),
                false);

        embed.addField("**Unit 3:** Class Creation",
                String.format(
                        "🔹 **%d questions**\nIncludes constructors, fields, accessors/mutators, `this`, and encapsulation.\n\u200B",
                        Unit3.numUnit3Questions),
                false);

        embed.addField("**Unit 4:** Data Collections",
                String.format(
                        "🔹 **%d questions**\nFocuses on arrays, ArrayLists, 2D arrays, traversals, search/sort, and algorithms.\n\n" +
                                "[Visit Our Website](https://customdiscordbots.org)\n" +
                                "Contact <@840216337119969301> for any questions",
                        Unit4.numUnit4Questions),
                false);

        event.getChannel().sendMessageEmbeds(embed.build()).queue();
    }

    // For slash commands
    public static void execute(SlashCommandInteractionEvent event) {
        int sum = Unit1.numUnit1Questions + Unit2.numUnit2Questions
                + Unit3.numUnit3Questions + Unit4.numUnit4Questions;

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("📚 Available Practice Questions 📚");
        embed.setThumbnail("https://images-ext-1.discordapp.net/external/O91y0nM-QHluCrrKWyJaoTagrp9FvPlPzlggBaS-NZI/%3Fsize%3D4096/https/cdn.discordapp.com/avatars/1401736371508613120/054bf5ff6af1656b42f02def5333e6ed.png?format=webp&quality=lossless&width=768&height=768");
        embed.setColor(0x3498db); // Blue color

        embed.setDescription(String.format(
                "**Total Questions:** %d\n\nUse `!unit<number>` to start practicing!",
                sum
        ));

        embed.addField("**Unit 1:** Using Objects & Methods",
                String.format(
                        "🔹 **%d questions**\nFocuses on Strings, Math, method calls, and basic object interaction.\n\u200B",
                        Unit1.numUnit1Questions),
                false);

        embed.addField("**Unit 2:** Selection & Iteration",
                String.format(
                        "🔹 **%d questions**\nCovers if/else, boolean expressions, loops, and control flow.\n\u200B",
                        Unit2.numUnit2Questions),
                false);

        embed.addField("**Unit 3:** Class Creation",
                String.format(
                        "🔹 **%d questions**\nIncludes constructors, fields, accessors/mutators, `this`, and encapsulation.\n\u200B",
                        Unit3.numUnit3Questions),
                false);

        embed.addField("**Unit 4:** Data Collections",
                String.format(
                        "🔹 **%d questions**\nFocuses on arrays, ArrayLists, 2D arrays, traversals, search/sort, and algorithms.\n\n" +
                                "[Visit Our Website](https://customdiscordbots.org)\n" +
                                "Contact <@840216337119969301> for any questions",
                        Unit4.numUnit4Questions),
                false);

        event.replyEmbeds(embed.build()).queue();
    }
}
