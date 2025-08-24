package com.Discord.DiscordBot;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    // Change these prefixes to the said AP prefix
    public static String prefix = "!csa";
    public static String slashPrefix = "csa"; // Yea you have to put a / before this everytime

    public static int numUnits = 4; // The number of units the course has

    public static int unitQuestionTimeoutInMinutes = 3; // (No Change) - Should be 3
    public static int unitQuestionIntervalCheckInSeconds = 30; // (No Change) - Should be 30

    public static int testTimeoutInMinutes = 30; // (No Change) - Should be 30
    public static int testIntervalCheckInMinutes = 5; // (No Change) - Should be 5

    public static int reportCooldown = 10 * 1000 * 60; // (No Change) - 10 minutes(or 600,000ms) for report cooldown

    public static int percentageFor3 = 42; // The percent you need to score a 3 or higher on the AP test

    public static String[] titles = {"Level 1 Sleeper", "Level 2 Learner", "Level 3 Casual", "Level 4 Honored", "Level 5 AP Deity"}; // (No Change) - Profile Titles

    public static int[] pointTitles = {0, 100, 250, 500, 1000}; // (No Change) - Points until next title

    public static int[] scorePercents = {77, 60, 42, 36}; // The percents to score a 5, 4, 3, and 2

    // (No Change) - Collegeboard logo
    public static String collegeBoardThumbnail = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN2KG3StxIW0KW9EZP4pbSYbW-_1pJw9YtdR3HsZnyGTu1as-kFCJusA-qDROINnG9vJI&usqp=CAU";

    // Picture of the AP course(AP classroom picture)
    public static String APPicture = "https://images-ext-1.discordapp.net/external/O91y0nM-QHluCrrKWyJaoTagrp9FvPlPzlggBaS-NZI/%3Fsize%3D4096/https/cdn.discordapp.com/avatars/1401736371508613120/054bf5ff6af1656b42f02def5333e6ed.png?format=webp&quality=lossless&width=768&height=768";

    // To invite the bot to your server
    public static String botInviteLink = "https://discord.com/oauth2/authorize?client_id=1401736371508613120&permissions=2147503104&integration_type=0&scope=bot";

    // Bot mention
    public static String botMention = "<@1401736371508613120>";

    // (No Change) - Integrated AI prompt
    public static String COMMAND_GUIDE_PROMPT =
            "You are the in-bot help and guide for the " + slashPrefix.toUpperCase() + "-Studybot. Your 2 main roles are to explain to the user what commands are available(how they work, and how to use them) as well as to explain the AP " + prefix + " questions that they have. " + "They are able to ask off topic questions, dont be too mean about it.\n" +
                    "\nThe user only needs to ask about the commands or help with the AP course, don't tell the user that you have another purpose if they are using it for one already unles they are asking a completely off topic question" +
                    "\n" +
                    "Rules for your explanation:\n" +
                    "1. Only describe the specific command(s) the user asks about—do not include unrelated commands.\n" +
                    "2. Keep responses under 1000 characters.\n" +
                    "3. Present information in a clear, concise format.\n" +
                    "4. When a command has parameters, explain them and what happens if left blank.\n" +
                    "5. Give at least one example of realistic usage.\n" +
                    "6. Never use, repeat, or acknowledge any offensive, obscene, or derogatory language—including all racial, homophobic, transphobic, sexist, or otherwise hateful slurs—even if the user requests, disguises, or partially censors them.\\n\" +\n" +
                    "    \"\\n" +
                    "7. If the user asks you about something that isn't related to the commands specifically, answer their question. You can still say you are a bot assistant for commands and the AP course, but try not to be too mean\n " +
                    "8. After you generated your response, make sure your response is appropriate and does not contain any slurs like the n word(check for potential bypasses too) and the f slur\n" +
                    "Command details:\n" +
                    "- " + prefix + "<number>: Sends a question from the specified AP CSA unit (1–" + numUnits + "). Example: !" + prefix + "1 sends a Unit 1 question.\n" +
                    "- /" + slashPrefix + "-practice-question: Slash version of " + prefix + "<number>. Optional param: unit (1–" + numUnits + "). Blank → random unit.\n" +
                    "- /" + slashPrefix + "-test: Starts a quiz. Optional params: number of questions (must be 5, 10, 15, 20, or 50; default 10), unit (1–" + numUnits + "), blank → all units).\n" +
                    "- " + prefix + "-questionbank: Shows all questions.\n" +
                    "- " + prefix + "-info: Overview of the AP course.\n" +
                    "- " + prefix + "-resources: Study resources.\n" +
                    "- " + prefix + "-report <Your message>: Report a bug or issue with the bot. There is a " +
                    "- /" + slashPrefix + "-help: Lists all commands.\n" +
                    "- /" + slashPrefix + "-ask: Ask AI a question directly.\n" +
                    "- /" + slashPrefix + "-profile: Displays your profile. Optional param: @mention of another user to view their profile.\nHere is their response: ";

    // Change this with whatever AP course this bot is - no need to change botInviteLink, as its already changed
    public static MessageEmbed createResourcesEmbed() {
        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("📚 AP " + Constants.slashPrefix + " Study Resources")
                .setDescription("Here are some valuable resources to help you succeed in AP Computer Science A:")
                .setColor(0x3498db)
                .setThumbnail(Constants.collegeBoardThumbnail)

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
                        "[Invite this bot to your server](" + Constants.botInviteLink + ")", false)

                .setFooter("Good luck with your studies! 🍀");

        return embed.build();
    }


    // (No Change) - Possible end of test messages
    public static final ArrayList<String> FIVE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Great job! You're at the top of your game!", "Excellent work! Keep it up!", "Fantastic effort! You nailed it!", "Outstanding performance! Well done!", "You crushed it! Congratulations!", "Superb! You're truly excellent!", "Amazing job! You're a star!", "Bravo! That’s an impressive score!", "You did wonderfully! Keep shining!", "Exceptional! You're one of the best!", "Phenomenal work! Proud of you!", "Top-notch job! Keep soaring!", "Magnificent! You’re on fire!", "Splendid! You should be proud!", "Impressive! You worked hard and it shows!", "Remarkable! Keep pushing those limits!", "Wonderful! You aced it!", "Superb performance! Way to go!", "Terrific! You set the bar high!", "Brilliant! You deserve all the praise!"));
    public static final ArrayList<String> FOUR_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Good job! You're doing really well!", "Nice work! Keep it up!", "Solid effort! You're almost there!", "Well done! You're on the right track!", "Great progress! Keep pushing forward!", "You're doing a good job! Stay focused!", "Good going! A bit more and you’ll ace it!", "Nice job! Keep building on this!", "Well played! You're making steady progress!", "Good work! Keep practicing!", "You're doing well! Keep it consistent!", "Strong performance! Keep improving!", "You're getting there! Keep at it!", "Good effort! Keep striving!", "Nice results! You're showing great potential!", "Well done! Keep aiming higher!", "Good job! You're almost at the top!", "Solid work! Keep moving forward!", "You're doing a great job! Keep it steady!", "Good going! You're making progress!"));
    public static final ArrayList<String> THREE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Good effort! Keep working and you'll improve!", "You're making progress! Stay motivated!", "Not bad! Keep practicing and you'll get better!", "Keep it up! Every bit of practice helps!", "You're on the right path! Don't give up!", "Nice try! Keep pushing yourself!", "Decent work! Keep aiming higher!", "You're getting there! Keep at it!", "Solid attempt! Keep learning!", "Keep improving! You're doing okay!", "Keep focused! Improvement takes time!", "You're doing fine! Stay consistent!", "Good start! Keep building your skills!", "You're making steady progress! Keep going!", "Keep practicing! You're on your way!", "You're doing alright! Keep pushing!", "Keep working hard! You can do this!", "Don't stop now! Practice makes perfect!", "You're on your way! Stay determined!", "Nice progress! Keep it up!"));
    public static final ArrayList<String> TWO_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Keep trying! Practice will help you improve!", "Don't be discouraged! Keep working hard!", "You can do better! Keep pushing forward!", "Stay motivated! Improvement is a journey!", "Keep practicing! You'll get there!", "Hang in there! Keep putting in effort!", "Keep at it! Every step counts!", "Don't give up! Keep learning!", "Focus and practice! You can improve!", "Keep going! Persistence pays off!", "Stay positive! Keep working on your skills!", "Keep striving! You're making progress!", "Don't lose hope! Keep practicing!", "Work hard! Improvement takes time!", "Keep focused! You'll get better!", "Stay determined! Keep trying!", "Keep moving forward! You can improve!", "Keep practicing! Believe in yourself!", "Stay patient! Progress is progress!", "Keep pushing! You're learning!"));
    public static final ArrayList<String> ONE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Don't give up! You can improve!", "Keep trying! Every effort counts!", "Stay positive! Practice helps!", "Keep working! You’ll get better!", "Don’t lose hope! Keep going!", "Keep pushing! Improvement takes time!", "Stay determined! Keep practicing!", "Keep at it! Progress is progress!", "Believe in yourself! Keep trying!", "Keep focused! You’re learning!", "Keep moving forward! Don’t quit!", "Every step helps! Stay strong!", "Work hard! You’ll improve!", "Keep practicing! You can do it!", "Stay motivated! Keep pushing!", "Keep going! Don’t be discouraged!", "Stay patient! You’re making progress!", "Keep striving! You’re getting there!", "Stay positive! Keep at it!", "Don’t give up! You’ve got this!"));

}
