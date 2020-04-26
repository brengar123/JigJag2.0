package com.example.jigjag20;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameOneFragment extends AppCompatActivity {
    private TextView one;
    private TextView two;
    private TextView three;
    private TextView Title;
    private ImageView appleone;
    private ImageView appletwo;
    private ImageView orangeone;
    private ImageView orangetwo;
    private ImageView finalorange;
    private ImageView finalapple;
    private EditText inputone;
    private EditText inputtwo;
    private Button enter;
    private TextView message;


    public static int RandomiseNumber(int min, int max) {
        int number = (int) (Math.random() * ((max - min) + 1)) + min;
        return number;
    }
    //method to generate a random number within the min and max inputs

    int numberone = RandomiseNumber(2, 12);
    int numbertwo = RandomiseNumber(0, 12);
    int numberthree = RandomiseNumber(0, 12);

    //generates randomnumbers

    int answerone = numberone * numbertwo - numberthree;
    int answertwo = numberthree + numbertwo;

    //equations that are used, number one represents the coefficient, number two represents the orange and number three represents apple


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameone);
        TextView one = findViewById(R.id.G1tv_Coefficient);
        TextView two = findViewById(R.id.G1tv_Answerone);
        TextView three = findViewById(R.id.G1tv_Answertwo);
        TextView Title = findViewById(R.id.G1tv_Title);
        Title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showVideo("https://www.youtube.com/watch?v=X09oxyIeGuY");
            }
        });
        //funny easter egg that references the title of the game to a modern maths meme, likely to be appreciated by our target audience
        one.setText(String.valueOf(numberone));
        two.setText(String.valueOf(answerone));
        three.setText(String.valueOf(answertwo));
        ImageView appleone = findViewById(R.id.G1iv_Orangeone);
        appleone.setImageResource(R.drawable.apple);
        ImageView appletwo = findViewById(R.id.G1iv_Orangetwo);
        appletwo.setImageResource(R.drawable.apple);
        ImageView orangeone = findViewById(R.id.G1iv_Appleone);
        orangeone.setImageResource(R.drawable.orange);
        ImageView orangetwo = findViewById(R.id.G1iv_Appletwo);
        orangetwo.setImageResource(R.drawable.orange);
        ImageView finalorange = findViewById(R.id.G1iv_FinalOrange);
        finalorange.setImageResource(R.drawable.orange);
        ImageView finalapple = findViewById(R.id.G1iv_FinalApple);
        finalapple.setImageResource(R.drawable.apple);
        EditText inputone = findViewById(R.id.G1et_Inputapple);
        EditText inputtwo = findViewById(R.id.G1et_Inputorange);
        TextView message = findViewById(R.id.G1tv_Message);
        //sets all elements based on random numbers above and places pictures of fruit as the imageviews
        Button enter = findViewById(R.id.G1bt_Enter);
        //button is used to check if user inputs are the same as answer

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int useranswerone = Integer.valueOf(inputone.getText().toString());
                int useranswertwo = Integer.valueOf(inputtwo.getText().toString());
                //casts user input from string to int so it can be checked against answer

                if (useranswerone == numberthree && useranswertwo == numbertwo) {
                    message.setText("Correct!");
                    numberone = RandomiseNumber(2, 12);
                    numbertwo = RandomiseNumber(0, 12);
                    numberthree = RandomiseNumber(0, 12);
                    answerone = numberone * numbertwo - numberthree;
                    answertwo = numberthree + numbertwo;
                    one.setText(String.valueOf(numberone));
                    two.setText(String.valueOf(answerone));
                    three.setText(String.valueOf(answertwo));
                    inputone.setText("");
                    inputtwo.setText("");
                    //tell users it's correct, generates new random numbers, allows user to answer again

                } else {
                    message.setText("Incorrect! Please try again!");
                    //informs the user that inputs do not match answer
                }
            }
        });


    }

    private void showVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
        //method to launch new intent that is a URL
    }
}
