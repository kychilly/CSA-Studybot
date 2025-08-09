package com.Discord.DiscordBot.commands;

import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CommandManager extends ListenerAdapter {

    List<CommandData> commandData = new ArrayList<>();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equalsIgnoreCase("help")) {
            HelpCommand.execute(event);
        } else if (command.equalsIgnoreCase("csa-info")) {
            QuestionsCommand.execute(event);
        } else if (command.equalsIgnoreCase("question-bank")) {
            QuestionBankCommand.execute(event);
        } else if (command.equalsIgnoreCase("test")) {
            TestCommand.execute(event); // Needs work
        } else if (command.equalsIgnoreCase("question")) {
            UnitsCommand.execute(event);
        }

    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {

        commandData.add(HelpCommand.getCommandData());
        commandData.add(QuestionsCommand.getCommandData());
        commandData.add(QuestionBankCommand.getCommandData());
        commandData.add(TestCommand.getCommandData());
        commandData.add(UnitsCommand.getCommandData());

        //updates all commands in guilds
        event.getGuild().updateCommands()
                .addCommands(commandData)
                .queue(
                        success -> System.out.println("✅ New commands registered in " + event.getGuild().getName()),
                        error -> System.err.println("❌ Failed in " + event.getGuild().getName() + ": " + error.getMessage())
                );
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {

        //updates all commands in guilds
        event.getGuild().updateCommands()
                .addCommands(commandData)
                .queue(
                        success -> System.out.println("✅ New commands registered in " + event.getGuild().getName()),
                        error -> System.err.println("❌ Failed in " + event.getGuild().getName() + ": " + error.getMessage())
                );
    }
}