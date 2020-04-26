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
    private TextView mWord;
    private TextView mResponse;
    private Button mButton;
    private String mAnswer;
    private EditText mInput;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gametwo);

        mDefinition = findViewById(R.id.G2tv_Definition);
        mWord = findViewById(R.id.G2tv_Word);
        mInput = findViewById(R.id.G2et_Input);
        newWord();
        mResponse = findViewById(R.id.G2tv_Message);
        mButton = findViewById(R.id.G2bt_Enter);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userinput = mInput.getText().toString();
                //casts userinput to string so it can be matched against the answer
                if(userinput.equals(mAnswer)){
                    mResponse.setText("Correct!");
                    newWord();
                    //uses method to retrieve new jumbled word and its definition
                }
                else{
                    mResponse.setText("Incorrect! Please try again!");
                }
            }
        });
    }

    public void newWord() {
        mInput.setText("");
        mAnswer = Anagram.randomWord();
        String wordshuffled = Anagram.shuffleWord(mAnswer);
        mWord.setText(wordshuffled);
        DictionaryRequest dR = new DictionaryRequest(this, mDefinition);
        url = dictionaryEntries();
        dR.execute(url);
        //method that retreieves random word from array in Anagram class and then uses method in Anagram class to jumble word and set this jumbled word to text. Definition of the real word is then retrieved from API using asynctask from dictionary request java class
    }



    private String dictionaryEntries() {
        final String language = "en-gb";
        final String word = mAnswer;
        final String fields = "definitions";
        final String strictMatch = "false";
        final String word_id = word.toLowerCase();
        return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" + "fields=" + fields + "&strictMatch=" + strictMatch;
    }
    //method given by Oxford Dictionaries to help retrieve api, reference: "https://developer.oxforddictionaries.com/documentation#!/Entries/get_entries_source_lang_word_id"


}
