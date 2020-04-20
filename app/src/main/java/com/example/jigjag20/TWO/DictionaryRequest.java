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
    }
    @Override
    protected String doInBackground(String... params) {

        final String app_id = "b463faf0";
        final String app_key = "08ad010cc1770d1c1acc2e7e48f38caf";
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

            String def = definitionsArr.toString();
            mDefinition.setText(def);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        Log.v("Result of Dictionary", "onPostExecute" + result);


    }
}