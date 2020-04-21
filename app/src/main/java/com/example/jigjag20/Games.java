package com.example.jigjag20;

import java.util.ArrayList;

public class Games {
    private String name;
    private String type;
    private String description;
    private int image;

    private Games(String name, String type, String description, int image){
        this.name = name;
        this.type = type;
        this.description = description;
        this.image = image;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
    public static ArrayList<Games> getGames(){
        ArrayList<Games> games = new ArrayList<>();
        games.add(new Games("Quick Maths!","Numerical Reasoning", "Find out what number each shape represents", R.drawable.gameone));
        games.add(new Games("Unscrambler", "Logical Reasoning", "Unscramble the given word", R.drawable.gameone));
        games.add(new Games("Balloon", "Risk Assessment", "Blow up the balloon as big as you can without popping it", R.drawable.gameone));
        games.add(new Games("Colour Change", "Reflex", "Click the button when the colour changes", R.drawable.gameone));
        games.add(new Games("Memorisation", "Memory", "Memorise the sequence of numbers", R.drawable.gameone));
        games.add(new Games("To be continued", "N/A", "Stay tuned for more games coming soon?", R.drawable.gameone));
        return games;
    }
}
