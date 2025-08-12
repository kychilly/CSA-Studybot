package com.Discord.DiscordBot.Sessions;

import com.Discord.DiscordBot.Constants;
import com.google.gson.*;
import net.dv8tion.jda.api.entities.User;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserProfileManager {
    private static final String PROFILES_DIR = "profiles/";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    static {
        // Create profiles directory if it doesn't exist
        new File(PROFILES_DIR).mkdirs();
    }

    public static void saveProfile(UserProfile profile) throws IOException {
        String userId = profile.getUser().getId();
        String filePath = PROFILES_DIR + userId + ".json";

        JsonObject json = new JsonObject();
        json.addProperty("userId", userId);
        json.addProperty("points", profile.getPoints());
        json.addProperty("title", profile.getTitle());

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(json, writer);
        }
    }

    public static UserProfile loadProfile(User user) throws IOException {
        String filePath = PROFILES_DIR + user.getId() + ".json";
        File file = new File(filePath);

        if (!file.exists()) {
            return new UserProfile(user, 0, Constants.titles[0]);
        }

        try (FileReader reader = new FileReader(file)) {
            JsonObject json = gson.fromJson(reader, JsonObject.class);
            int points = json.get("points").getAsInt();
            String title = json.get("title").getAsString();
            return new UserProfile(user, points, title);
        }
    }

    public static boolean profileExists(User user) {
        return new File(PROFILES_DIR + user.getId() + ".json").exists();
    }
}