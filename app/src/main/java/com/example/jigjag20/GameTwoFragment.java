package com.example.jigjag20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.jigjag20.TWO.Anagram;
import com.example.jigjag20.TWO.DictionaryRequest;


public class GameTwoFragment extends AppCompatActivity{
    private TextView mDefinition;
    private TextView Word;
    private TextView Response;
    private Button button;
    private String Answer;
    private EditText input;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gametwo);

        mDefinition = findViewById(R.id.Definition);
        Word = findViewById(R.id.Word);
        input = findViewById(R.id.InputGuess);
        newWord();
        Response = findViewById(R.id.Response);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = input.getText().toString();
                if(userinput.equals(Answer)){
                    Response.setText("Correct!");
                    newWord();
                }
                else{
                    Response.setText("Incorrect! Please try again!");
                }
            }
        });
    }

    public void newWord() {
        input.setText("");
        Answer = Anagram.randomWord();
        String wordshuffled = Anagram.shuffleWord(Answer);
        Word.setText(wordshuffled);
        DictionaryRequest dR = new DictionaryRequest(this, mDefinition);
        url = dictionaryEntries();
        dR.execute(url);
    }



    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = Answer;
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }


}
