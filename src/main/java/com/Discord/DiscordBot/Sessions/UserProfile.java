package com.Discord.DiscordBot.Sessions;

import com.Discord.DiscordBot.Constants;
import net.dv8tion.jda.api.entities.User;

import java.io.IOException;

public class UserProfile {

    private User user;
    private int points;
    private String title;

    public UserProfile(User user, int points, String title) {
        this.user = user;
        this.points = points; // Could also just set this to 0 lol
        this.title = Constants.titles[0]; // or updateTitle(), both get 0 at the very start
    }

    public void addPoints(int points) {
        this.points += points;
        updateTitle();
        saveToFile();
    }

    // 5 : 1000
    // 4 : 500
    // 3 : 250
    // 2 : 100
    // 1 : 50
    public void updateTitle() {
        if (points >= 1000) {
            title = Constants.titles[4];
        } else if (points >= 500) {
            title = Constants.titles[3];
        } else if (points >= 250) {
            title = Constants.titles[2];
        } else if (points >= 100) {
            title = Constants.titles[1];
        } else {
            title = Constants.titles[0]; // You technically dont have to put this here, but just in case I guess
        }
    }

    public User getUser() { return user; }
    public int getPoints() { return points; }
    public String getTitle() { return title; }

    private void saveToFile() {
        try {
            UserProfileManager.saveProfile(this);
        } catch (IOException e) {
            System.err.println("Failed to save profile: " + e.getMessage());
        }
    }

}
