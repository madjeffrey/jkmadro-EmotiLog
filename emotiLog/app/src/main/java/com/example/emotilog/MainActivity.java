package com.example.emotilog;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.emotilog.ui.notifications.NotificationsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.emotilog.databinding.ActivityMainBinding;

import java.time.LocalDateTime;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            EmotiLog.getInstance().logEmotionDate("Happy", LocalDateTime.of(2025, 9, 30, 14, 30, 15));
            EmotiLog.getInstance().logEmotionDate("Sad", LocalDateTime.of(2025, 9, 30, 15, 42, 11));
            EmotiLog.getInstance().logEmotionDate("Angry", LocalDateTime.of(2025, 9, 30, 16, 28, 35));
            EmotiLog.getInstance().logEmotionDate("Happy", LocalDateTime.of(2025, 9, 30, 11, 12, 52));
            EmotiLog.getInstance().logEmotionDate("Happy", LocalDateTime.of(2025, 9, 30, 20, 1, 11));
        }

    }
}
