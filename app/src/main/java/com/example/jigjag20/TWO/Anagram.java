package com.example.jigjag20.TWO;

import java.util.Random;

public class Anagram {
    public static final Random rand = new Random();
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
            "rugby",
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


    public static String randomWord(){
        return words[rand.nextInt(words.length)];
    }
    public static String shuffleWord(String word){
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
    }
}