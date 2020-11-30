package com.example.hangmanapp;

import android.content.SharedPreferences;

import java.util.Random;
import java.util.Set;

public class SinglePlayerWordPicker {
    public static String wordPicker(SharedPreferences pref){
        Set<String> wordList = pref.getStringSet("wordList", null);
        int size = wordList.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for(String word : wordList)
        {
            if (i == item)
                return word;
            i++;
        }
        return null;
    }
}
