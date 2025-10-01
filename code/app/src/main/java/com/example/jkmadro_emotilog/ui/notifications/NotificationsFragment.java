package com.example.jkmadro_emotilog.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jkmadro_emotilog.EmoteArrayAdapter;
import com.example.jkmadro_emotilog.EmotiLog;
import com.example.jkmadro_emotilog.R;

public class NotificationsFragment extends Fragment {

    private ListView emoteList;
    private TextView emptyTextView;
    private EmoteArrayAdapter emoteAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_notifications, null);

        emoteList = view.findViewById(R.id.emotionList);
        emptyTextView = view.findViewById(R.id.emptyTextView);

        if (EmotiLog.getInstance().getEmotions().isEmpty()) {
            emoteList.setVisibility(View.GONE);
            emptyTextView.setVisibility(View.VISIBLE);
        } else {
            emoteList.setVisibility(View.VISIBLE);
            emptyTextView.setVisibility(View.GONE);
        }


        emoteAdapter = new EmoteArrayAdapter(getContext(), EmotiLog.getInstance().getEmotions());
        emoteList.setAdapter(emoteAdapter);
        emoteAdapter.notifyDataSetChanged();

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        emoteList = null;
        emoteAdapter = null;
    }
}