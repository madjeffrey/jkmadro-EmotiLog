package com.example.jkmadro_emotilog.ui.dashboard;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.jkmadro_emotilog.EmotiLog;
import com.example.jkmadro_emotilog.Emotion;
import com.example.jkmadro_emotilog.databinding.FragmentDashboardBinding;

import java.time.LocalDate;
import java.util.ArrayList;

public class DashboardFragment extends Fragment {
    private FragmentDashboardBinding binding;
    // Fragment to display the summary and frequency of each emotion for any given day or the total summary
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();



        // Set up button click listener
        binding.btnShowSummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSummary();
            }
        });


        // Show summary for today by default after view is fully created
        root.post(new Runnable() {
            @Override
            public void run() {
                ArrayList<Integer> counts = EmotiLog.getInstance().countEmotions(EmotiLog.getInstance().getEmotions());

                // Update the UI with counts
                // counts: [happy, sad, angry, excited, tired, love, neutral, anxious, total]
                binding.tvTotalEmotions.setText("Total Emotions For All Days: " + counts.get(8));
                binding.tvHappyCount.setText("😊 Happy: " + counts.get(0));
                binding.tvSadCount.setText("😢 Sad: " + counts.get(1));
                binding.tvAngryCount.setText("😠 Angry: " + counts.get(2));
                binding.tvExcitedCount.setText("🤩 Excited: " + counts.get(3));
                binding.tvTiredCount.setText("😴 Tired: " + counts.get(4));
                binding.tvLoveCount.setText("😍 Love: " + counts.get(5));
                binding.tvNeutralCount.setText("😐 Neutral: " + counts.get(6));
                binding.tvAnxiousCount.setText("😰 Anxious: " + counts.get(7));
            }
        });

        return root;
    }

    private void updateSummary() {


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Get selected date from DatePicker
            int day = binding.datePicker.getDayOfMonth();
            int month = binding.datePicker.getMonth() + 1; // Month is 0-indexed
            int year = binding.datePicker.getYear();

            LocalDate selectedDate = LocalDate.of(year, month, day);

            // Get emotions for the selected date
            ArrayList<Emotion> emotionsOnDate = EmotiLog.getInstance().getNumEmotionDate(selectedDate);

            // Count emotions by type
            ArrayList<Integer> counts = EmotiLog.getInstance().countEmotions(emotionsOnDate);

            // Update the UI with counts
            // counts: [happy, sad, angry, excited, tired, love, neutral, anxious, total]
            binding.tvTotalEmotions.setText("Total Emotions For " + selectedDate + " : " + counts.get(8));
            binding.tvHappyCount.setText("😊 Happy: " + counts.get(0));
            binding.tvSadCount.setText("😢 Sad: " + counts.get(1));
            binding.tvAngryCount.setText("😠 Angry: " + counts.get(2));
            binding.tvExcitedCount.setText("🤩 Excited: " + counts.get(3));
            binding.tvTiredCount.setText("😴 Tired: " + counts.get(4));
            binding.tvLoveCount.setText("😍 Love: " + counts.get(5));
            binding.tvNeutralCount.setText("😐 Neutral: " + counts.get(6));
            binding.tvAnxiousCount.setText("😰 Anxious: " + counts.get(7));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;

    }
}
