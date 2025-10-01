package com.example.jkmadro_emotilog.ui.logs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.jkmadro_emotilog.databinding.FragmentLogsBinding;
import com.example.jkmadro_emotilog.databinding.FragmentLogsBinding;

public class LogsFragment extends Fragment {

    private FragmentLogsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        LogsViewModel logsViewModel =
                new ViewModelProvider(this).get(LogsViewModel.class);

        binding = FragmentLogsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textNotifications;
        logsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}