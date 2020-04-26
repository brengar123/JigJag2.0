package com.example.jigjag20;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.jigjag20.Jokes.Joke;
import com.example.jigjag20.Jokes.JokeService;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EasterEgg extends AppCompatActivity {
    private TextView mSetup;
    private TextView mDisplay;
    private Button mRefresh;
    private Joke joke;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.extra);
        mSetup = findViewById(R.id.Etv_Setup);
        mDisplay = findViewById(R.id.Etv_Output);
        mRefresh = findViewById(R.id.Ebt_refresh);
        new GetJokeTask().execute();
        mRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GetJokeTask().execute();
            }
        });
    }

    private class GetJokeTask extends AsyncTask<Void, Void, Joke> {
        @Override
        protected Joke doInBackground(Void... voids) {
            //Try-catch is used as the try block executes code to retrieve an online API
            try {
                //Retrofit is used to convert the Json class from the API
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://sv443.net/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                JokeService service = retrofit.create(JokeService.class);
                Call<Joke> jokeCall = service.getJoke(); //call method
                Response<Joke> jokeResponse = jokeCall.execute(); //response method
                joke = jokeResponse.body(); //setting joke equal to Json from the API response
                return joke;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        public void onPostExecute(Joke joke) {
            //Post-execute method handles rendering after API is called
            if (joke != null) {
                //If API function worked this is executed
                mSetup.setText(joke.getSetup()); //quote joke setup
                mDisplay.setText(joke.getDelivery()); //quote joke punchline
                Log.v("result of joke", "result is" + joke);
            } else {
                //If API function failed to retrieve quote, this is executed
                mDisplay.setText("An error occurred! Please refresh!"); //prompts user to try again

            }
        }
    }
}
