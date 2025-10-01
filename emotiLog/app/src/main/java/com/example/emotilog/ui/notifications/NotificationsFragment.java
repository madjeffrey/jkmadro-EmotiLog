package com.example.emotilog.ui.notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.emotilog.EmoteArrayAdapter;
import com.example.emotilog.EmotiLog;
import com.example.emotilog.R;
import com.example.emotilog.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private ListView emoteList;
    private EmoteArrayAdapter emoteAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_notifications, null);

        emoteList = view.findViewById(R.id.emotionList);
        emoteAdapter = new EmoteArrayAdapter(getContext(), EmotiLog.getInstance().getEmotions());
        emoteList.setAdapter(emoteAdapter);
        Log.d("DEBUG", "emotilog:" + EmotiLog.getInstance().getEmotions() );

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}