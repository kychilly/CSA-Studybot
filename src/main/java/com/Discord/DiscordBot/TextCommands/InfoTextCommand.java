package com.Discord.DiscordBot.TextCommands;

import com.Discord.DiscordBot.Constants;
import com.Discord.DiscordBot.Z_Units.Unit1;
import com.Discord.DiscordBot.Z_Units.Unit2;
import com.Discord.DiscordBot.Z_Units.Unit3;
import com.Discord.DiscordBot.Z_Units.Unit4;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;

public class InfoTextCommand {

    public static void execute(MessageReceivedEvent event) {
        SendAvailableQuestions(event);
    }

    public static void SendAvailableQuestions(MessageReceivedEvent event) {
        int sum = Unit1.numUnit1Questions + Unit2.numUnit2Questions
                + Unit3.numUnit3Questions + Unit4.numUnit4Questions;

        EmbedBuilder embed = new EmbedBuilder();
        embed.setTitle("📚 Available Practice Questions 📚");
        embed.setThumbnail(Constants.APPicture);
        embed.setColor(0x3498db);

        embed.setDescription(String.format(
                "**Total Questions:** %d\n\nUse `!" + Constants.slashPrefix + "<number>`,  `/" + Constants.slashPrefix + "-practice-question`, or `/" +
                        Constants.slashPrefix + "-test` to start practicing!\n----------------------------------------------------", sum
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

}
