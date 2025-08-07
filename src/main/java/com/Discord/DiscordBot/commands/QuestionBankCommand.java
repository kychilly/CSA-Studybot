package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Units.Question;
import com.Discord.DiscordBot.Units.QuestionBank;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.messages.MessageCreateBuilder;
import net.dv8tion.jda.api.utils.messages.MessageEditBuilder;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionBankCommand {
    private static final int QUESTIONS_PER_PAGE = 5;
    private static final Map<Long, Integer> userPageStates = new HashMap<>();
    private static final Map<Long, Integer> userUnitStates = new HashMap<>();

    public static CommandData getCommandData() {
        return Commands.slash("question-bank", "Browse all available questions by unit");
    }

    public static void execute(SlashCommandInteractionEvent event) {
        User user = event.getUser();

        // Get questions from your existing QuestionBank
        ArrayList<Question> allQuestions = QuestionBank.getQuestionBank();

        // Filter for Unit 1 questions by default
        List<Question> unit1Questions = allQuestions.stream()
                .filter(q -> q.getUnit() == 1)
                .collect(Collectors.toList());

        // Store user's page and unit state
        userPageStates.put(user.getIdLong(), 0);
        userUnitStates.put(user.getIdLong(), 1);

        sendQuestionBankPage(event, unit1Questions, 0, 1);
    }

    private static void sendQuestionBankPage(SlashCommandInteractionEvent event, List<Question> questions, int page, int unit) {
        MessageCreateBuilder messageBuilder = createQuestionBankMessage(questions, page, unit);
        event.reply(messageBuilder.build()).queue();
    }

    private static void updateQuestionBankPage(ButtonInteractionEvent event, List<Question> questions, int page, int unit) {
        MessageEditBuilder messageBuilder = new MessageEditBuilder()
                .setEmbeds(createQuestionBankEmbed(questions, page, unit).build())
                .setComponents(createActionRows(unit, page, questions.size()));

        event.getHook().editOriginal(messageBuilder.build()).queue();
    }

    private static MessageCreateBuilder createQuestionBankMessage(List<Question> questions, int page, int unit) {
        return new MessageCreateBuilder()
                .setEmbeds(createQuestionBankEmbed(questions, page, unit).build())
                .setComponents(createActionRows(unit, page, questions.size()));
    }

    private static EmbedBuilder createQuestionBankEmbed(List<Question> questions, int page, int unit) {
        int totalPages = (int) Math.ceil((double) questions.size() / QUESTIONS_PER_PAGE);
        page = Math.max(0, Math.min(page, totalPages - 1));

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle(String.format("Unit %d Questions (Page %d/%d)", unit, page + 1, totalPages))
                .setColor(Color.BLUE);

        int startIdx = page * QUESTIONS_PER_PAGE;
        int endIdx = Math.min(startIdx + QUESTIONS_PER_PAGE, questions.size());

        if (questions.isEmpty()) {
            embed.setDescription("No questions available for this unit.");
        } else {
            for (int i = startIdx; i < endIdx; i++) {
                Question q = questions.get(i);
                embed.addField(
                        String.format("Question %d (ID: %d)", i + 1, q.getQuestionId()),
                        String.format("%s\nA) %s\nB) %s\nC) %s\nD) %s\nDifficulty: %s",
                                q.getQuestion(), q.getOptionA(), q.getOptionB(),
                                q.getOptionC(), q.getOptionD(), q.getQuestionDifficulty()),
                        false
                );
            }

            embed.setFooter(String.format("Showing questions %d-%d of %d in Unit %d",
                    startIdx + 1, endIdx, questions.size(), unit));
        }

        return embed;
    }

    private static List<ActionRow> createActionRows(int unit, int page, int totalQuestions) {
        int totalPages = (int) Math.ceil((double) totalQuestions / QUESTIONS_PER_PAGE);

        // Navigation buttons
        Button prevButton = Button.primary("qbank_prev", "◀").withDisabled(page == 0);
        Button nextButton = Button.primary("qbank_next", "▶").withDisabled(page >= totalPages - 1 || totalQuestions == 0);

        // Unit selection buttons
        Button unit1Button = Button.secondary("qbank_unit1", "Unit 1").withDisabled(unit == 1);
        Button unit2Button = Button.secondary("qbank_unit2", "Unit 2").withDisabled(unit == 2);
        Button unit3Button = Button.secondary("qbank_unit3", "Unit 3").withDisabled(unit == 3);
        Button unit4Button = Button.secondary("qbank_unit4", "Unit 4").withDisabled(unit == 4);

        // Create action rows (max 5 buttons per row)
        ActionRow navigationRow = ActionRow.of(prevButton, nextButton);
        ActionRow unitRow = ActionRow.of(unit1Button, unit2Button, unit3Button, unit4Button);

        return List.of(navigationRow, unitRow);
    }

    public static void handleButtonInteraction(ButtonInteractionEvent event) {
        String buttonId = event.getComponentId();
        User user = event.getUser();

        if (user.isBot()) return;

        event.deferEdit().queue(); // Important for button interactions

        long userId = user.getIdLong();
        int currentPage = userPageStates.getOrDefault(userId, 0);
        int currentUnit = userUnitStates.getOrDefault(userId, 1);

        ArrayList<Question> allQuestions = QuestionBank.getQuestionBank();
        List<Question> unitQuestions;

        // Handle button actions
        switch (buttonId) {
            case "qbank_prev":
                currentPage--;
                break;
            case "qbank_next":
                currentPage++;
                break;
            case "qbank_unit1":
                currentUnit = 1;
                currentPage = 0;
                break;
            case "qbank_unit2":
                currentUnit = 2;
                currentPage = 0;
                break;
            case "qbank_unit3":
                currentUnit = 3;
                currentPage = 0;
                break;
            case "qbank_unit4":
                currentUnit = 4;
                currentPage = 0;
                break;
            default:
                return; // Not our button
        }

        // Filter questions for the selected unit
        final int unitFilter = currentUnit;
        unitQuestions = allQuestions.stream()
                .filter(q -> q.getUnit() == unitFilter)
                .collect(Collectors.toList());

        // Update user state
        userPageStates.put(userId, currentPage);
        userUnitStates.put(userId, currentUnit);

        // Update the existing message
        updateQuestionBankPage(event, unitQuestions, currentPage, currentUnit);
    }
}