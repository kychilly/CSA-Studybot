package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Constants;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    List<CommandData> commandData = new ArrayList<>();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        String command = event.getName();
        if (command.equalsIgnoreCase(Constants.slashPrefix + "-help")) {
            HelpCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-info")) {
            InfoCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-question-bank")) {
            QuestionBankCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-test")) {
            TestCommand.execute(event); // Needs work
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-question")) {
            UnitsCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-resources")) {
            ResourcesCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-ask")) {
            GPTCommand.execute(event);
        } else if (command.equalsIgnoreCase(Constants.slashPrefix + "-profile")) {
            ProfileCommand.execute(event);
        }

    }

    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {

        commandData.add(HelpCommand.getCommandData());
        commandData.add(InfoCommand.getCommandData());
        commandData.add(QuestionBankCommand.getCommandData());
        commandData.add(TestCommand.getCommandData());
        commandData.add(UnitsCommand.getCommandData());
        commandData.add(ResourcesCommand.getCommandData());
        commandData.add(GPTCommand.getCommandData());
        commandData.add(ProfileCommand.getCommandData());

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