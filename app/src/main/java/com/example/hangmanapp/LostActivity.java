package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                doOpenChooseWord();
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
}