package com.example.emotilog;

import android.os.Build;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class EmotiLog {
    private static EmotiLog instance;
    private ArrayList<Emotion> emotions;

    private EmotiLog(){
        this.emotions = new ArrayList<Emotion>();
    }

    public static EmotiLog getInstance() {
        if (instance == null) {
            instance = new EmotiLog();
        }
        return instance;
    }

    public void logEmotion(String emotion){
        this.emotions.add(new Emotion(emotion));
    }

    public ArrayList<Emotion> getEmotions(){
        return this.emotions;
    }
    public ArrayList<Emotion> getNumEmotionDate(LocalDate date){
        // gets all the Emotions that fall on a specific date
        ArrayList<Emotion> onDate = new ArrayList<Emotion>();
        for (Emotion emotion: this.emotions) {
            LocalDate emoDate = null;
            // convert the localDateTime to a LocalDate()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                emoDate = emotion.getTime().toLocalDate();
            }

            assert emoDate != null;
            // if the emotion is on this day add it to list
            if (emoDate.equals(date)){
                onDate.add(emotion);
            }
        }
        return onDate;
    }

    public ArrayList<Integer> countEmotions(ArrayList<Emotion> emotionList){
        ArrayList<Integer> count = new ArrayList<Integer>(Arrays.asList(0,0,0,0,0,0,0,0,0)); // happy, sad, angry, excited, tired, love, neutral, anxious, total
        for( Emotion emotion: emotionList){
            count.set(8, count.get(8)+1);
            switch(emotion.getEmotion()) {
                case "Happy":
                    count.set(0, count.get(0) + 1);
                    continue;
                case "Sad":
                    count.set(1, count.get(1) + 1);
                    continue;
                case "Angry":
                    count.set(2, count.get(2) + 1);
                    continue;
                case "Excited":
                    count.set(3, count.get(3) + 1);
                    continue;
                case "Tired":
                    count.set(4, count.get(4) + 1);
                    continue;
                case "Love":
                    count.set(5, count.get(5) + 1);
                    continue;
                case "Neutral":
                    count.set(6, count.get(6) + 1);
                    continue;
                case "Anxious":
                    count.set(7, count.get(7) + 1);
                    continue;
                default:
                    count.set(8, count.get(8) - 1);
            }
        }
        return count;
    }

}
