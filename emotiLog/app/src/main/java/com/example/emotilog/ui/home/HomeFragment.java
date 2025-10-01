package com.example.emotilog.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.emotilog.EmotiLog;
import com.example.emotilog.R;

public class HomeFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_home, null);

        // set on click listener for all buttons
        Button btnHappy = view.findViewById(R.id.btnHappy);
        Button btnAngry = view.findViewById(R.id.btnAngry);
        Button btnSad = view.findViewById(R.id.btnSad);
        Button btnAnxious = view.findViewById(R.id.btnWorried);
        Button btnTired = view.findViewById(R.id.btnTired);
        Button btnLove = view.findViewById(R.id.btnLove);
        Button btnNeutral = view.findViewById(R.id.btnNeutral);
        Button btnExcited = view.findViewById(R.id.btnExcited);

        btnHappy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Happy");
                Log.d("DEBUG", "emotilog:" + EmotiLog.getInstance().getEmotions() );
            }
        });
        btnSad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Sad");

            }
        });
        btnAnxious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("DEBUG", "emotilog:" + EmotiLog.getInstance().getEmotions() );
                EmotiLog.getInstance().logEmotion("Anxious");
                Log.d("DEBUG", "emotilog:" + EmotiLog.getInstance().getEmotions() );


            }
        });
        btnAngry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Angry");

            }
        });
        btnExcited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Excited");

            }
        });
        btnTired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Tired");

            }
        });
        btnNeutral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Neutral");

            }
        });
        btnLove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EmotiLog.getInstance().logEmotion("Love");
            }
        });


        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}