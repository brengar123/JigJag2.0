package com.example.jigjag20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameThreeFragment extends AppCompatActivity {
    private TextView mMessage;
    private Button mIncrease;
    private Button mStopper;
    private ImageView mBalloon;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamethree);
        mBalloon = findViewById(R.id.G3iv_Balloon);
        mMessage = findViewById(R.id.G3tv_Message);
        mMessage.setText("");
        mIncrease = findViewById(R.id.G3bt_Increase);
        mStopper = findViewById(R.id.G3bt_Stop);
        int limit = RandomiseNumber(5,10);
        //generates random number for when balloon will pop
        final int[] holder = {0};
        //stores how many times balloon size has increased
        mBalloon.setImageResource(R.drawable.emptybal);

        mIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = holder[0]++ + 1;

                if (i >= limit){
                    mMessage.setText("Oh no! You have popped the balloon!");
                    mBalloon.setImageResource(R.drawable.popbal);
                    //lets user know they have popped balloon and displays popped balloon picture
                }
                else if (i == 1){
                    mMessage.setText("You have blown up the balloon 1 time");
                    mBalloon.setImageResource(R.drawable.onebal);
                    //lets user know they have blown the balloon up once
                }
                else {
                    mMessage.setText("You have blown up the balloon " + i + " times");
                    //lets the user know how many times they have blown the balloon
                    //balloon image increases everytime to let user know it is about to pop
                }
            }
        });

        mStopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessage.setText("You stopped blowing the balloon");
            }
            //lets the user stop blowing the balloon
            //ideal future implementation: this result is stored in database and ccomparison with other players is displayed to user to guage level of risk
        });


    }

    public static int RandomiseNumber(int min, int max) {
        int number = (int) (Math.random() * ((max - min) + 1)) + min;
        return number;
        //method to generate random number of when balloon pops
    }
}