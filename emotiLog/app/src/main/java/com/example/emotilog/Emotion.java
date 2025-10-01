package com.example.emotilog;

import android.os.Build;

import java.sql.Time;
import java.time.LocalDateTime;

public class Emotion {
    private String emotion;
    private LocalDateTime time;

    public Emotion(String emotion){
        this.emotion = emotion;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.time = LocalDateTime.now();
        }
    }

    public Emotion(String emotion, LocalDateTime date){
        this.emotion = emotion;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            this.time = date;
        }
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getEmotion() {
        return emotion;
    }

}
