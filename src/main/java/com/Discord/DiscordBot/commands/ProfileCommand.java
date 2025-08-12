package com.Discord.DiscordBot.commands;

import com.Discord.DiscordBot.Sessions.UserProfile;
import com.Discord.DiscordBot.Sessions.UserProfileManager;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import java.awt.*;
import java.io.IOException;

public class ProfileCommand extends ListenerAdapter {

    public static CommandData getCommandData() {
        return Commands.slash("profile", "Gets your profile!")
                .addOption(OptionType.USER, "user", "Who's profile do you want to see? Leave blank if you just want yours", false);
    }

    public static void execute(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("profile")) return;

        User targetUser = event.getOption("user") == null
                ? event.getUser()
                : event.getOption("user").getAsUser();

        try {
            UserProfile profile = UserProfileManager.loadProfile(targetUser);

            EmbedBuilder embed = new EmbedBuilder()
                    .setTitle(targetUser.getName() + "'s Profile")
                    .setThumbnail(targetUser.getEffectiveAvatarUrl())
                    .addField("🏆 Title", profile.getTitle(), true)
                    .addField("⭐ Points", String.valueOf(profile.getPoints()), true)
                    .setColor(Color.decode("#5865F2"))
                    .setFooter("Keep answering questions to earn more points!");

            event.replyEmbeds(embed.build()).queue();
        } catch (IOException e) {
            event.reply("❌ An error occurred while loading the profile.").setEphemeral(true).queue();
            e.printStackTrace();
        }
    }
}