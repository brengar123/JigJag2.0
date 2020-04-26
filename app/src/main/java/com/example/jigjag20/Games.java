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

    //getters and setters for objects in array
    public static ArrayList<Games> getGames(){
        ArrayList<Games> games = new ArrayList<>();
        games.add(new Games("Quick Maths!","Numerical Reasoning", "Find out what number each shape represents", R.drawable.maths));
        games.add(new Games("Unscrambler", "Logical Reasoning", "Unscramble the given word", R.drawable.dictionary));
        games.add(new Games("Will The Balloon Pop?", "Risk Assessment", "Blow up the balloon as big as you can without popping it", R.drawable.onebal));
        games.add(new Games("Flash React!", "Reflex and Reaction", "Test how fast you can react when the colour changes", R.drawable.timer));
        games.add(new Games("Do you Remember?", "Memory Recognition", "Memorise the sequence of numbers", R.drawable.numbers));
        games.add(new Games("To Be Continued", "N/A", "Stay tuned for more games coming soon?", R.drawable.gameone));
        return games;
        //fills array with information about the games
    }
}
