package com.example.emotilog;

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

        // set on click listener for all buttons
        Button btnHappy = findViewById(R.id.btnHappy);
        Button btnAngry = findViewById(R.id.btnAngry);
        Button btnSad = findViewById(R.id.btnSad);
        Button btnAnxious = findViewById(R.id.btnWorried);
        Button btnTired = findViewById(R.id.btnTired);
        Button btnLove = findViewById(R.id.btnLove);
        Button btnNeutral = findViewById(R.id.btnNeutral);
        Button btnExcited = findViewById(R.id.btnExcited);

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



    }
}
