package com.example.jigjag20;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameFourFragment extends AppCompatActivity {
    //Initialize variables
    private Button mStart;
    private Button mMain;
    private TextView mInfo;
    private long startTime;
    private long endTime;
    private long currentTime;
    private long bestTime = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamefour);
        //Linking XML files
        mStart = findViewById(R.id.G4bt_Start);
        mMain = findViewById(R.id.G4bt_Main);

        mInfo = findViewById(R.id.G4tv_Record);

        mStart.setEnabled(true);
        mMain.setEnabled(false);

        mInfo.setText("BEST TIME: " + bestTime + " ms");

        mStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStart.setEnabled(false);
                mMain.setText("");
                //Use Handler to schedule delayed runnable in 2 seconds (upon being pressed)
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    //Upon pressing, captures current time of system and changes background colour
                    @Override
                    public void run() {
                        startTime = System.currentTimeMillis();
                        mMain.setBackgroundColor(
                                ContextCompat.getColor(getApplicationContext(), R.color.blue));
                        mMain.setText("PRESS");
                        mMain.setEnabled(true);

                    }
                }, 2000);
            }

        });
        //Default view of the game, updates to show the fastest time of user
        mMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                endTime = System.currentTimeMillis();
                mMain.setBackgroundColor(
                        ContextCompat.getColor(getApplicationContext(), R.color.red));
                currentTime = endTime - startTime;
                mMain.setText(currentTime + " ms");
                mStart.setEnabled(true);
                mMain.setEnabled(false);

                if(currentTime < bestTime) {
                    bestTime = currentTime;
                    mInfo.setText("BEST TIME: " + bestTime + " ms");
                }
            }
        });
    }
}