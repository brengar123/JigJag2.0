package com.example.jigjag20;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameThreeFragment extends AppCompatActivity {
    private TextView message;
    private Button increase;
    private Button stopper;
    private ImageView balloon;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamethree);
        balloon = findViewById(R.id.balloon);
        message = findViewById(R.id.G3Message);
        message.setText("");
        increase = findViewById(R.id.increase);
        stopper = findViewById(R.id.stopper);
        int limit = RandomiseNumber(5,10);
        final int[] holder = {0};
        balloon.setImageResource(R.drawable.emptybal);

        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = holder[0]++ + 1;

                if (i >= limit){
                    message.setText("Oh no! You have popped the balloon!");
                    balloon.setImageResource(R.drawable.popbal);
                }
                else if (i == 1){
                    message.setText("You have blown up the balloon 1 time");
                    balloon.setImageResource(R.drawable.onebal);
                }
                else {
                    message.setText("You have blown up the balloon " + i + " times");
                }
            }
        });

        stopper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message.setText("You stopped blowing the balloon");
            }
        });


    }

    public static int RandomiseNumber(int min, int max) {
        int number = (int) (Math.random() * ((max - min) + 1)) + min;
        return number;
    }
}