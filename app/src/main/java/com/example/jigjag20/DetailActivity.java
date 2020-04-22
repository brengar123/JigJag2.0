package com.example.jigjag20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "Psychometric testing";
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mRecyclerView = findViewById(R.id.RvList);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        GamesAdapter.RecyclerViewClickListener listener = new GamesAdapter.RecyclerViewClickListener(){
            @Override
            public void onClick(View view, int position){
                launchGame(position);
            }
        };
        mAdapter = new GamesAdapter(Games.getGames(), listener);
        mRecyclerView.setAdapter(mAdapter);

    }
    private void launchgameone(){
        Intent intent = new Intent(this, GameOneFragment.class);
        startActivity(intent);
    }
    private void launchgametwo(){
        Intent intent = new Intent(this, GameTwoFragment.class);
        startActivity(intent);
    }
    private void launchgamethree() {
        Intent intent = new Intent(this, GameThreeFragment.class);
        startActivity(intent);
    }
    private void launchgamefour() {
        Intent intent = new Intent(this, GameFourFragment.class);
        startActivity(intent);
    }
    private void launcheasteregg(){
        Intent intent = new Intent(this, EasterEgg.class);
        startActivity(intent);
    }

    private void launchGame(int position) {
        switch (position){
            case 0: launchgameone(); break;
            case 1: launchgametwo(); break;
            case 2: launchgamethree(); break;
            case 3: launchgamefour(); break;
            case 4: launcheasteregg(); break;
        }
    }
}