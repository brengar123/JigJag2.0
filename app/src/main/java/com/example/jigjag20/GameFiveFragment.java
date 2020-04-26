package com.example.jigjag20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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
    public TextView mMessage;
    public TextView mInfo;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamefive);
        mRandomN = findViewById(R.id.G5tv_Sequence);
        mSequence = findViewById(R.id.G5et_Answer);
        mButton = findViewById(R.id.G5bt_Get);
        mEnter = findViewById(R.id.G5bt_Enter);
        mMessage = findViewById(R.id.G5tv_Message);
        mInfo = findViewById(R.id.G5tv_Counter);
        mTitle = findViewById(R.id.G5tv_Title);
        //funny easter egg that references the title of the game to a classic song, likely to be appreciated by our target audience
        mTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideo("http://www.youtube.com/watch?v=Gs069dndIYk&t=0m18s");
            }
        });
        random = generateNumber();
        //creates one array that has been filled with random numbers
        String solution = String.valueOf(random.get(0)) + String.valueOf(random.get(1)) + String.valueOf(random.get(2)) + String.valueOf(random.get(3)) + String.valueOf(random.get(4)) + String.valueOf(random.get(5)) + String.valueOf(random.get(6)) + String.valueOf(random.get(7)) + String.valueOf(random.get(8)) + String.valueOf(random.get(9)) + String.valueOf(random.get(10));
        //casts array into string by calling upon each of the objects individually and putting them together
        mRandomN.setText((String.valueOf(random.get(0))));
        //casts first number into string and prints first number within the array
        mInfo.setText("This is number 1 in the sequence");
        mHandler = new Handler();
        //Handler enables message and runnable to be processed at a delay of 2 seconds, printing out arraylist of numbers
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRepeatingTask();
            }
        });
        //startRepeatingTask() method, begins iterating through arraylist
        mEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = mSequence.getText().toString();
                //casts the userinput into string so it can be compared against the solution
                if(userinput.equals(solution)){
                    mMessage.setText("Correct!");
                    //tells user they are correct
                }
                else{
                    mMessage.setText("Incorrect! The sequence was " + solution);
                    //tells them they are incorrect and tells them what the answer was
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
        //Prints out a single number for duration of 2 seconds, repeats 10 ten times
        @Override
        public void run() {
            if (times < 10) {
                try {
                    updateStatus();
                    times++;
                } finally {

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
            mInfo.setText("This is number " + (counter+1) + " in the sequence");
            //lets user know which number is appearing in the sequence. useful when same number repeats twice in a row
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
        //array to hold the sequence of numbers
        for (int i = 0; i<11; i++){
            generateNumber.add(new Integer((int)(Math.random() * ((9 - 0) + 1)) + 0));
            //generates ten different numbers that are between 0-9 to fill the array
        }
        return generateNumber;

    }
    private void showVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        //method to launch new intent that is a URL
    }
}
