package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LostActivity extends AppCompatActivity {
    Button buttonExitGame;
    Button buttonRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);

        buttonExitGame = (Button) findViewById(R.id.buttonExitGameLost);
        buttonExitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenMain();
            }
        });

        buttonRestart = (Button) findViewById(R.id.buttonRestartLost);
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
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        String word = SinglePlayerWordPicker.wordPicker(pref);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("EXTRA_WORD", word);
        intent.putExtra("EXTRA_MODE", 1);
        startActivity(intent);
    }
}