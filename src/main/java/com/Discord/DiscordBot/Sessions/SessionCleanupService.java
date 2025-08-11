package com.Discord.DiscordBot.Sessions;

import com.Discord.DiscordBot.Sessions.TestSession;
import com.Discord.DiscordBot.commands.TestCommand;
import net.dv8tion.jda.api.sharding.ShardManager;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class SessionCleanupService {
    private final ShardManager shardManager;
    private final long cleanupIntervalMinutes;
    private final long sessionTimeoutMinutes;

    public SessionCleanupService(ShardManager shardManager,
                                 long cleanupIntervalMinutes,
                                 long sessionTimeoutMinutes) {
        this.shardManager = shardManager;
        this.cleanupIntervalMinutes = cleanupIntervalMinutes;
        this.sessionTimeoutMinutes = sessionTimeoutMinutes;
    }

    public void startCleanupTask() {

        Timer timer = new Timer(true); // Daemon thread
        timer.scheduleAtFixedRate(new TimerTask() {
                                      @Override
                                      public void run() {
                                          cleanupInactiveSessions();
                                      }
                                  },
                TimeUnit.MINUTES.toMillis(cleanupIntervalMinutes),
                TimeUnit.MINUTES.toMillis(cleanupIntervalMinutes));
    }

    private void cleanupInactiveSessions() {
        long now = System.currentTimeMillis();
        List<Long> toRemove = new ArrayList<>();

        // First collect IDs to remove (minimizes sync time)
        synchronized (TestCommand.class) { // Synchronize on class object
            TestCommand.getActiveTests().forEach((userId, session) -> {
                if (now - session.getLastActivityTime() >
                        TimeUnit.MINUTES.toMillis(sessionTimeoutMinutes)) {
                    toRemove.add(userId);
                }
            });
        }

        // Then process removals and notifications
        toRemove.forEach(userId -> {
            synchronized (TestCommand.class) {
                TestCommand.getActiveTests().remove(userId);
            }
            notifyUser(userId);
            System.out.println("[Cleanup] Removed inactive session for: " + userId);
        });
    }

    private void notifyUser(long userId) {
        shardManager.retrieveUserById(userId).queue(user -> {
            user.openPrivateChannel().queue(channel -> {
                channel.sendMessage("⌛ Your test session expired after 30 minutes of inactivity.")
                        .queue();
            }, error -> {
                System.out.println("[SessionCleanup] Couldn't DM user " + userId);
            });
        }, error -> {
            System.out.println("[SessionCleanup] Couldn't find user " + userId);
        });
    }
}