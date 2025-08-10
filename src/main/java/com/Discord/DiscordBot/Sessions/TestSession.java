package com.Discord.DiscordBot.Sessions;

import com.Discord.DiscordBot.Units.Question;

import java.util.*;

public class TestSession {
    private final List<Question> questions;
    private final Map<Integer, String> userAnswers;
    private int currentIndex;
    private long messageId;
    private boolean submitted = false;

    public TestSession(List<Question> questions) {
        this.questions = new ArrayList<>(questions);
        this.userAnswers = new HashMap<>();
        this.currentIndex = 0;
    }

    public Question getCurrentQuestion() {
        return questions.get(currentIndex);
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int n) {
        currentIndex = n;
    }

    public int getTotalQuestions() {
        return questions.size();
    }

    public String getUserAnswer(int index) {
        return userAnswers.get(index);
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public void setAnswer(int index, String answer) {
        userAnswers.put(index, answer);
    }

    public void nextQuestion() {
        if (currentIndex < questions.size() - 1) {
            currentIndex++;
        }
    }

    public void previousQuestion() {
        if (currentIndex > 0) {
            currentIndex--;
        }
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public int calculateScore() {
        int score = 0;
        for (Map.Entry<Integer, String> entry : userAnswers.entrySet()) {
            if (questions.get(entry.getKey()).getCorrectAnswer().equalsIgnoreCase(entry.getValue())) {
                score++;
            }
        }
        return score;
    }
    public List<Question> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

}