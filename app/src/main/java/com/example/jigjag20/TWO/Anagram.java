package com.example.jigjag20.TWO;

import java.util.Random;

public class Anagram {
    public static final Random rand = new Random();
    //instatiates the imported random util
    public static final String[] words = {"banana",
            "tray",
            "colon",
            "bundle",
            "host",
            "choke",
            "brake",
            "integrity",
            "mail",
            "consciousness",
            "depression",
            "paint",
            "coverage",
            "shot",
            "recommendation",
            "noble",
            "glide",
            "unlikely",
            "basketball",
            "switch",
            "proportion",
            "station",
            "trail",
            "spirit",
            "potential",
            "forward",
            "defendant",
            "vessel",
            "edge",
            "staircase",
            "cutting",
            "imagine",
            "share",
            "literacy",
            "beach",
            "layout",
            "fork",
            "activate",
            "scratch",
            "assignment",
            "feedback",
            "disposition",
            "matter",
            "institution",
            "favor",
            "mystery",
            "dominate",
            "bite",
            "adoption",
            "convert",
            "agenda",
            "tear",
            "future",
            "patrol",
            "fashion",
            "slow",
            "single",
            "bat",
            "rally",
            "passion",
            "reduction",
            "mill",
            "tribute",
            "chapter",
            "familiar",
            "grant",
            "election",
            "thesis",
            "impulse",
            "weak",
            "stab",
            "widen",
            "criticism",
            "concern",
            "wedding",
            "negative",
            "tip",
            "seller",
            "funny",
            "syndrome",
            "publisher",
            "eye",
            "suffering",
            "correspondence",
            "wrong",
            "tense",
            "equinox",
            "sensation",
            "mirror",
            "pastel",
            "cooperation",
            "craft",
            "feed",
            "weed",
            "investigation",
            "fork",
            "gate",
            "army"

    };
    //array stores random words
    //note: random words generated from: https://randomwordgenerator.com/ and pasted into array


    public static String randomWord(){
        return words[rand.nextInt(words.length)];
    }
    //method to select a random word from within the array
    public static String shuffleWord(String word){
        //method to scramble the random word into jumbled letters
        if (word != null && !"".equals(word)){
            char a[] = word.toCharArray();
            for (int i=0; i < a.length; i++){
                int b = rand.nextInt(a.length);
                char tmp = a[i];
                a[i] = a[b];
                a[b] = tmp;
            }
            return new String(a);
        }
        return word;
        //scramble method and logic based on youtube tutorial, reference: "https://www.youtube.com/watch?v=GQR_5ZEj0dU"
    }
}