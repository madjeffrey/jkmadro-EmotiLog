package com.example.jkmadro_emotilog;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class EmoteArrayAdapter extends ArrayAdapter<Emotion> {
    private Context context;
    private ArrayList<Emotion> emotions;
    // array adapter to update the Notifications fragment to show all logged emotions and time

    public EmoteArrayAdapter(Context context, ArrayList<Emotion> emotions) {
        super(context, 0, emotions);
        this.context = context;
        this.emotions = emotions;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.content,parent,false);
        } else{
            view = convertView;
        }

        Emotion emotion = getItem(position);
        TextView emotionText = view.findViewById(R.id.emotionText);
        TextView timeText = view.findViewById(R.id.dateText);

        emotionText.setText(emotion.getEmotion());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            timeText.setText(emotion.getTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).toString());
        }

        return view;
    }
}
