package com.example.jigjag20.TWO;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class DictionaryRequest extends AsyncTask<String,Integer, String> {
    Context context;
    TextView mDefinition;


    public DictionaryRequest(Context context, TextView tV) {
        this.context = context;
        mDefinition = tV;
        //sets context to let know which java file (and in turn which XML view) mDefinition is referencing
    }
    @Override
    protected String doInBackground(String... params) {
        //doInBackground code given by Oxford Dictionaries exemplar API, reference:"https://developer.oxforddictionaries.com/documentation#!/Entries/get_entries_source_lang_word_id"

        final String app_id = "b463faf0";
        final String app_key = "08ad010cc1770d1c1acc2e7e48f38caf";
        //app_id and app_key given by oxford dictionary account
        try {
            URL url = new URL(params[0]);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Accept","application/json");
            urlConnection.setRequestProperty("app_id",app_id);
            urlConnection.setRequestProperty("app_key",app_key);

            // read the output from the server
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder stringBuilder = new StringBuilder();

            String line = null;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }

            return stringBuilder.toString();

        }
        catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            String jsonData = result;
            JSONObject obj = new JSONObject(jsonData);

            JSONArray resultsArr = obj.getJSONArray("results");
            String test = resultsArr.getJSONObject(0).toString();

            JSONArray lexicalEntriesArr = resultsArr.getJSONObject(0).getJSONArray("lexicalEntries");
            JSONArray entriesArr = lexicalEntriesArr.getJSONObject(0).getJSONArray("entries");
            JSONArray sensesArr = entriesArr.getJSONObject(0).getJSONArray("senses");
            JSONArray definitionsArr = sensesArr.getJSONObject(0).getJSONArray("definitions");

            //code above translates result into JSON different objects, for the purpose of the game only definition is necessary but the result needs to be broken sequentially

            String def = definitionsArr.toString();
            //casts the definition JSON object into a string
            mDefinition.setText(def);
            //prints string into textview in layout
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("Result of Dictionary", "onPostExecute" + result);
        //used to error check and see if JSON was retrieved from internet

    }
}