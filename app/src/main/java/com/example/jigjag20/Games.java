package com.example.jigjag20;

import java.util.ArrayList;

public class Games {
    private String name;
    private String type;
    private String description;
    private int photo;

    private Games(String name, String type, String description, int photo){
        this.name = name;
        this.type = type;
        this.description = description;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public static ArrayList<Games> getGames(){
        ArrayList<Games> games = new ArrayList<>();
        games.add(new Games("Quick Maths!","Numerical Reasoning", "Find out what number each shape represents", R.drawable.gameone));
        games.add(new Games("Unscrambler", "Logical Reasoning", "Unscramble the given word", 1));
        games.add(new Games("To be continued", "N/A", "Stay tuned for more games coming soon :)", 1));
        return games;
    }
}
