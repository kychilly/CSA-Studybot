package com.Discord.DiscordBot;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    public static String prefix = "!csa";
    public static String slashPrefix = "csa"; // Yea you have to put a / before this everytime lol

    public static int numUnits = 4;

    public static int unitQuestionTimeoutInMinutes = 3;
    public static int unitQuestionIntervalCheckInSeconds = 30;

    public static int testTimeoutInMinutes = 30; // Should be 30
    public static int testIntervalCheckInMinutes = 5; // Should be 5

    public static int percentageFor3 = 42;

    public static String[] titles = {"Level 1 Sleeper", "Level 2 Learner", "Level 3 Casual", "Level 4 Honored", "Level 5 AP Deity"};

    public static int[] pointTitles = {0, 100, 250, 500, 1000}; // index 1 is for level 2, index 2 is for level 3, index 4 is for level 5

    public static int[] scorePercents = {77, 60, 42, 36}; // index 0 is score for 5, index 1 is score for 4.

    public static String collegeBoardThumbnail = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQN2KG3StxIW0KW9EZP4pbSYbW-_1pJw9YtdR3HsZnyGTu1as-kFCJusA-qDROINnG9vJI&usqp=CAU";

    public static String botInviteLink = "https://discord.com/oauth2/authorize?client_id=1401736371508613120&permissions=2147503104&integration_type=0&scope=bot";

    public static String COMMAND_GUIDE_PROMPT =
            "You are the in-bot help and guide for the " + slashPrefix.toUpperCase() + "-Studybot. Your role is to explain to the user what commands are available, how they work, and how to use them. Your role is also to explain the AP " + prefix + " questions that they have. " + "They are able to ask off topic questions, dont be too mean about it.\n" +
                    "\nAlso, if the user is asking an AP " + Constants.slashPrefix + " question, answer them but dont say stuff like \"My actual purpose is to explain commands\"" +
                    "\n" +
                    "Rules for your explanation:\n" +
                    "1. Only describe the specific command(s) the user asks about—do not include unrelated commands.\n" +
                    "2. Keep responses under 1000 characters.\n" +
                    "3. Present information in a clear, concise format.\n" +
                    "4. When a command has parameters, explain them and what happens if left blank.\n" +
                    "5. Give at least one example of realistic usage.\n" +
                    "6. Never use, repeat, or acknowledge any offensive, obscene, or derogatory language—including all racial, homophobic, transphobic, sexist, or otherwise hateful slurs—even if the user requests, disguises, or partially censors them.\\n\" +\n" +
                    "    \"\\n" +
                    "7. If the user asks you about something that isn't related to the commands specifically, thats ok. Just answer their question. No need to keep saying you are the bot assistance, just a little nudge of saying what you are for is fine. Try to be as nice as possible too, dont respond with mean connotation to the user. \n " +
                    "Command details:\n" +
                    "- " + prefix + "<number>: Sends a question from the specified AP CSA unit (1–" + numUnits + "). Example: !" + prefix + "1 sends a Unit 1 question.\n" +
                    "- /" + slashPrefix + "-practice-question: Slash version of " + prefix + "<number>. Optional param: unit (1–" + numUnits + "). Blank → random unit.\n" +
                    "- /" + slashPrefix + "-test: Starts a quiz. Optional params: number of questions (must be 5, 10, 15, 20, or 50; default 10), unit (1–" + numUnits + "), blank → all units).\n" +
                    "- " + prefix + "-questionbank: Shows all questions.\n" +
                    "- " + prefix + "-info: Overview of the AP course.\n" +
                    "- " + prefix + "-resources: Study resources.\n" +
                    "- /" + slashPrefix + "-help: Lists all commands.\n" +
                    "- /" + slashPrefix + "-ask: Ask AI a question directly.\n" +
                    "- /" + slashPrefix + "-profile: Displays your profile. Optional param: @mention of another user to view their profile.\n";



    public static final ArrayList<String> FIVE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Great job! You're at the top of your game!", "Excellent work! Keep it up!", "Fantastic effort! You nailed it!", "Outstanding performance! Well done!", "You crushed it! Congratulations!", "Superb! You're truly excellent!", "Amazing job! You're a star!", "Bravo! That’s an impressive score!", "You did wonderfully! Keep shining!", "Exceptional! You're one of the best!", "Phenomenal work! Proud of you!", "Top-notch job! Keep soaring!", "Magnificent! You’re on fire!", "Splendid! You should be proud!", "Impressive! You worked hard and it shows!", "Remarkable! Keep pushing those limits!", "Wonderful! You aced it!", "Superb performance! Way to go!", "Terrific! You set the bar high!", "Brilliant! You deserve all the praise!"));
    public static final ArrayList<String> FOUR_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Good job! You're doing really well!", "Nice work! Keep it up!", "Solid effort! You're almost there!", "Well done! You're on the right track!", "Great progress! Keep pushing forward!", "You're doing a good job! Stay focused!", "Good going! A bit more and you’ll ace it!", "Nice job! Keep building on this!", "Well played! You're making steady progress!", "Good work! Keep practicing!", "You're doing well! Keep it consistent!", "Strong performance! Keep improving!", "You're getting there! Keep at it!", "Good effort! Keep striving!", "Nice results! You're showing great potential!", "Well done! Keep aiming higher!", "Good job! You're almost at the top!", "Solid work! Keep moving forward!", "You're doing a great job! Keep it steady!", "Good going! You're making progress!"));
    public static final ArrayList<String> THREE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Good effort! Keep working and you'll improve!", "You're making progress! Stay motivated!", "Not bad! Keep practicing and you'll get better!", "Keep it up! Every bit of practice helps!", "You're on the right path! Don't give up!", "Nice try! Keep pushing yourself!", "Decent work! Keep aiming higher!", "You're getting there! Keep at it!", "Solid attempt! Keep learning!", "Keep improving! You're doing okay!", "Keep focused! Improvement takes time!", "You're doing fine! Stay consistent!", "Good start! Keep building your skills!", "You're making steady progress! Keep going!", "Keep practicing! You're on your way!", "You're doing alright! Keep pushing!", "Keep working hard! You can do this!", "Don't stop now! Practice makes perfect!", "You're on your way! Stay determined!", "Nice progress! Keep it up!"));
    public static final ArrayList<String> TWO_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Keep trying! Practice will help you improve!", "Don't be discouraged! Keep working hard!", "You can do better! Keep pushing forward!", "Stay motivated! Improvement is a journey!", "Keep practicing! You'll get there!", "Hang in there! Keep putting in effort!", "Keep at it! Every step counts!", "Don't give up! Keep learning!", "Focus and practice! You can improve!", "Keep going! Persistence pays off!", "Stay positive! Keep working on your skills!", "Keep striving! You're making progress!", "Don't lose hope! Keep practicing!", "Work hard! Improvement takes time!", "Keep focused! You'll get better!", "Stay determined! Keep trying!", "Keep moving forward! You can improve!", "Keep practicing! Believe in yourself!", "Stay patient! Progress is progress!", "Keep pushing! You're learning!"));
    public static final ArrayList<String> ONE_SCORE_MESSAGES = new ArrayList<>(Arrays.asList("Don't give up! You can improve!", "Keep trying! Every effort counts!", "Stay positive! Practice helps!", "Keep working! You’ll get better!", "Don’t lose hope! Keep going!", "Keep pushing! Improvement takes time!", "Stay determined! Keep practicing!", "Keep at it! Progress is progress!", "Believe in yourself! Keep trying!", "Keep focused! You’re learning!", "Keep moving forward! Don’t quit!", "Every step helps! Stay strong!", "Work hard! You’ll improve!", "Keep practicing! You can do it!", "Stay motivated! Keep pushing!", "Keep going! Don’t be discouraged!", "Stay patient! You’re making progress!", "Keep striving! You’re getting there!", "Stay positive! Keep at it!", "Don’t give up! You’ve got this!"));

}
