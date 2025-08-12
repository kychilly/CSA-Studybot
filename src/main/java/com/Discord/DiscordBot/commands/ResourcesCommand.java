package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.Command;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class ResourcesCommand {

    public static SlashCommandData getCommandData() {
        return Commands.slash("csa-resources", "Get helpful resources for AP CSA");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        MessageEmbed resourcesEmbed = createResourcesEmbed();
        event.replyEmbeds(resourcesEmbed).queue();
    }


    private static MessageEmbed createResourcesEmbed() {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("📚 AP CSA Study Resources")
                .setDescription("Here are some valuable resources to help you succeed in AP Computer Science A:")
                .setColor(0x3498db)
                .setThumbnail("https://i.imgur.com/5Z3Qk9a.png") // Thumbnail doesnt work, replace later

                // Official College Board Resources
                .addField("🎓 Official College Board Resources",
                        "• [Course Overview](https://apstudents.collegeboard.org/courses/ap-computer-science-a)\n" +
                                "• [Course Description](https://apcentral.collegeboard.org/pdf/ap-computer-science-a-course-and-exam-description.pdf)\n" +
                                "• [Past Exam Questions](https://apcentral.collegeboard.org/courses/ap-computer-science-a/exam)\n" +
                                "• [AP Classroom](https://myap.collegeboard.org/) (Requires teacher login)", false)

                // Video Tutorials
                .addField("📺 Video Tutorials",
                        "• [College Board AP CSA Playlist](https://www.youtube.com/playlist?list=PLoGgviqq4845xKOY11PnkE4aqdBmDx1LO)\n" +
                                "• [Khan Academy AP CSA](https://www.khanacademy.org/computing/ap-computer-science-principles)\n" +
                                "• [CS Awesome Interactive Textbook](https://runestone.academy/ns/books/published/csawesome/index.html)", false)

                // Practice Sites
                .addField("💻 Practice & Coding Sites",
                        "• [CodingBat Java Practice](https://codingbat.com/java)\n" +
                                "• [Practice-it (UW)](https://practiceit.cs.washington.edu/)\n" +
                                "• [Replit Java Online IDE](https://replit.com/languages/java)", false)

                // Additional Help
                .addField("🆘 Additional Help",
                        "• [Java Documentation](https://docs.oracle.com/javase/8/docs/api/)\n" +
                                "• [GeeksforGeeks Java](https://www.geeksforgeeks.org/java/)\n" +
                                "• [Stack Overflow](https://stackoverflow.com/)", false)

                // Bot Invite
                .addField("🤖 Bot Invite",
                        "[Invite this bot to your server](" + getBotInviteLink() + ")", false)

                .setFooter("Good luck with your studies! 🍀");

        return embed.build();
    }

    private static String getBotInviteLink() {
        return "https://discord.com/oauth2/authorize?client_id=1401736371508613120&permissions=2147503104&integration_type=0&scope=bot";
    }
}
