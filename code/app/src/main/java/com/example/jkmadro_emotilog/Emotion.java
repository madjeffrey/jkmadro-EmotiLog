package com.example.jkmadro_emotilog;

import android.os.Build;

import java.time.LocalDateTime;

public class Emotion {
    private String emotion;
    private LocalDateTime time;
    // representation of emotions felt at a given time
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
