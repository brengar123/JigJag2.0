package com.example.jigjag20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;

public class GameFiveFragment extends AppCompatActivity {
    public TextView mRandomN;
    public EditText mSequence;
    public Button mButton;
    public int mInterval = 2000;
    public int counter = 0;
    public Handler mHandler;
    public Button mEnter;
    public ArrayList<Integer> random = new ArrayList<>();
    public TextView message;
    public TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamefive);
        //declare XML elements
        mRandomN = findViewById(R.id.randomN);
        mSequence = findViewById(R.id.sequence);
        mButton = findViewById(R.id.button);
        mEnter = findViewById(R.id.G4Enter);
        message = findViewById(R.id.G4Message);
        info = findViewById(R.id.G4Counter);
        random = generateNumber();
        String solution = String.valueOf(random.get(0)) + String.valueOf(random.get(1)) + String.valueOf(random.get(2)) + String.valueOf(random.get(3)) + String.valueOf(random.get(4)) + String.valueOf(random.get(5)) + String.valueOf(random.get(6)) + String.valueOf(random.get(7)) + String.valueOf(random.get(8)) + String.valueOf(random.get(9)) + String.valueOf(random.get(10));
        mRandomN.setText((String.valueOf(random.get(0))));
        info.setText("This is number 1 in the sequence");
        //Set OnClickListener to refresh number
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHandler = new Handler();
                startRepeatingTask();
            }
        });
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = mSequence.getText().toString();
                if(userinput.equals(solution)){
                    message.setText("Correct!");
                    random = generateNumber();
                    mRandomN.setText(String.valueOf(random));
                }
                else{
                    message.setText("Incorrect! The sequence was " + solution);
                }
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }

    Runnable mStatusChecker = new Runnable() {
        int times = 0;

        @Override
        public void run() {
            if (times < 10) {
                try {
                    updateStatus(); //this function can change value of mInterval.
                    times++;
                } finally {
                    // 100% guarantee that this always happens, even if
                    // your update method throws an exception
                    mHandler.postDelayed(mStatusChecker, mInterval);
                }
            } else {
                stopRepeatingTask();
            }
        }
    };

    private void updateStatus() {
        if (counter <= random.size()) {
            counter++;
            mRandomN.setText(String.valueOf(random.get(counter)));
            info.setText("This is number " + (counter+1) + " in the sequence");
        }
        else {
            counter = 0;
        }
    }

    void startRepeatingTask() {
        mStatusChecker.run();
    }

    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }

    public static ArrayList<Integer> generateNumber(){
        ArrayList<Integer> generateNumber = new ArrayList<>();
        for (int i = 0; i<11; i++){
            generateNumber.add(new Integer((int)(Math.random() * ((9 - 0) + 1)) + 0));
        }
        return generateNumber;

    }
}
