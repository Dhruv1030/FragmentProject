package com.dhruv.myfragments;
public class Task {
    private String text;
    private boolean completed;

    public Task(String text, boolean completed) {
        this.text = text;
        this.completed = completed;
    }

    // Getters and setters
    public String getText() { return text; }
    public boolean isCompleted() { return completed; }
    public void setCompleted(boolean completed) { this.completed = completed; }
}