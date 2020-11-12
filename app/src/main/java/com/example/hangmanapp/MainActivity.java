package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    Button button2Players;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button 2 Player
        button2Players =(Button) findViewById(R.id.button2Players);
        button2Players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               doOpenChooseWordActivity();
            }
        });
    }

    public void doOpenChooseWordActivity() {
        Intent intent = new Intent(this, ChooseWordActivity.class);
        startActivity(intent);
    }
}