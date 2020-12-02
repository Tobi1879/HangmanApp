package com.example.hangmanapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import android.content.ContextWrapper;

import androidx.appcompat.app.AppCompatActivity;

import static android.content.Context.MODE_PRIVATE;
import static com.example.hangmanapp.MainActivity.WORD_LIST;

public class SinglePlayerWordPicker extends AppCompatActivity {
    public String wordPicker(SharedPreferences pref){
        Set<String> wordList = pref.getStringSet("wordList", null);
        List<String> removeList = new ArrayList();

        System.out.println(wordList.size());
        Iterator<String> it = wordList.iterator();
        while(it.hasNext()) {
            String word;
            word = it.next();
            if (word.length() < 11) {
                removeList.add(word);
            }
        }
        wordList.removeAll(removeList);
        System.out.println(wordList.size());;

        List<String> iteratorList = new ArrayList();

        if(pref.getInt("1Player", 1) == 2 || pref.getInt("1Player", 1) == 3){
            iteratorList.addAll(wordList);
        } else {
            iteratorList.addAll(removeList);
        }

        int size = iteratorList.size() - 1;
        int item = new Random().nextInt(size);
        int i = 0;
        for(String word : iteratorList)
        {
            if (i == item)
                return word;
            i++;
        }
        return null;
    }
}
