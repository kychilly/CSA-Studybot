package com.Discord.DiscordBot.listeners;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.StandardGuildMessageChannel;


import java.util.Optional;

public class JoinGuild extends ListenerAdapter {

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        Guild guild = event.getGuild();

        EmbedBuilder embed = new EmbedBuilder()
                .setTitle("Thanks for adding me to " + guild.getName() + " \uD83E\uDD73 \uD83E\uDD73 \uD83E\uDD73")
                .setDescription("I am currently in development, here are some setup instructions...")
                .addField("Getting Started", "Use `/help` to see commands\n", false) // Add \n to the field value
                .addField("Support",
                        "DM <@840216337119969301> for any questions\n" + "[Visit our website](https://customdiscordbots.org)", false)
                .setColor(0x00ff00);

        // Try system channel first
        StandardGuildMessageChannel targetChannel = guild.getSystemChannel();

        // Fallback to first writable text channel
        if (targetChannel == null || !targetChannel.canTalk()) {
            Optional<TextChannel> firstWritable = guild.getTextChannels().stream()
                    .filter(TextChannel::canTalk)
                    .findFirst();

            if (firstWritable.isPresent()) {
                targetChannel = firstWritable.get();
            }
        }

        // Send message if channel found
        if (targetChannel != null) {
            targetChannel.sendMessageEmbeds(embed.build()).queue();
        } else {
            // Final fallback: DM owner
            guild.retrieveOwner().queue(owner ->
                    owner.getUser().openPrivateChannel().queue(
                            channel -> channel.sendMessageEmbeds(embed.build()).queue(),
                            error -> System.out.println("Failed to send welcome message to " + guild.getName())
                    )
            );
        }
    }
}