package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.ConnectException;

public class WonActivity extends AppCompatActivity {
    Button buttonExitGame;
    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        buttonExitGame = (Button) findViewById(R.id.buttonExitGameWon);
        buttonExitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenMain();
            }
        });

        buttonRestart = (Button) findViewById(R.id.buttonRestartWon);
        buttonRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (getIntent().getIntExtra("EXTRA_MODE", 2) == 1){
                doOpenGameActivity();
                // get Word
            } else {
                doOpenChooseWord();
                // get Word
            }
            }
        });
    }

    private void doOpenChooseWord() {
        Intent intent = new Intent(this, ChooseWordActivity.class);
        startActivity(intent);
    }

    private void doOpenMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void doOpenGameActivity() {
        System.out.println("in");
        final SharedPreferences pref = getSharedPreferences("Settings", MODE_PRIVATE);
        SinglePlayerWordPicker singlePlayerWordPicker = new SinglePlayerWordPicker();
        String word = singlePlayerWordPicker.wordPicker(pref);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("EXTRA_WORD", word);
        intent.putExtra("EXTRA_MODE", 1);
        startActivity(intent);
    }
}