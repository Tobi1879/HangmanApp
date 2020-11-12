package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ChooseWordActivity extends AppCompatActivity {
    EditText editTextWord;
    Button buttonStartGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_word);

        editTextWord = (EditText) findViewById(R.id.editTextWord);
        buttonStartGame = (Button) findViewById(R.id.buttonStartGame);

        buttonStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean error = false;
                if(editTextWord.getText().equals("")){
                    error = true;
                }
                if(editTextWord.getText().length() < 5){
                    error = true;
                }
                if(editTextWord.getText().length() > 15){
                    error = true;
                }
                if (!error) {
                    doOpenGameActivity();
                }
            }
        });
    }

    private void doOpenGameActivity() {
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("EXTRA_WORD", editTextWord.getText().toString());
        startActivity(intent);
    }
}