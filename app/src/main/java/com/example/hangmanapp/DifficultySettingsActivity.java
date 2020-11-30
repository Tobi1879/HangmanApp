package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class DifficultySettingsActivity extends AppCompatActivity {
    RadioGroup radioGroup1Player;
    RadioGroup radioGroup2Players;
    RadioButton radioButtonEasy;
    RadioButton radioButtonMedium;
    RadioButton radioButtonHard;
    RadioButton radioButton5Mistakes;
    RadioButton radioButton10Mistakes;

    Button buttonExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_settings);

        radioGroup1Player = (RadioGroup) findViewById(R.id.radioGroup1Player);
        radioGroup2Players = (RadioGroup) findViewById(R.id.radioGroup2Players);
        radioButtonEasy = (RadioButton) findViewById(R.id.radioButtonEasy);
        radioButtonMedium = (RadioButton) findViewById(R.id.radioButtonMedium);
        radioButtonHard = (RadioButton) findViewById(R.id.radioButtonHard);
        radioButton5Mistakes = (RadioButton) findViewById(R.id.radioButton5Mistakes);
        radioButton10Mistakes = (RadioButton) findViewById(R.id.radioButton10Mistakes);

        buttonExit= (Button) findViewById(R.id.buttonExit);
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        switch (pref.getInt("1Player", 1)){
            case 1 :
                radioButtonEasy.setChecked(Boolean.TRUE);
                break;
            case 2 :
                radioButtonMedium.setChecked(Boolean.TRUE);
                break;
            case 3 :
                radioButtonHard.setChecked(Boolean.TRUE);
                break;
            default:
                radioButtonEasy.setChecked(Boolean.TRUE);
        }

        switch (pref.getInt("2Players", 1)){
            case 1 :
                radioButton10Mistakes.setChecked(Boolean.TRUE);
                break;
            case 2 :
                radioButton5Mistakes.setChecked(Boolean.TRUE);
                break;
            default:
                radioButton10Mistakes.setChecked(Boolean.TRUE);
        }

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateSettings();
                doOpenMenu();
            }
        });
    }

    private void doOpenMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void updateSettings(){
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();
        if(radioButtonEasy.isChecked()){
            editor.putInt("1Player", 1);
        } else if(radioButtonMedium.isChecked()){
            editor.putInt("1Player", 2);
        } else if(radioButtonHard.isChecked()){
            editor.putInt("1Player", 3);
        }

        if(radioButton10Mistakes.isChecked()){
            editor.putInt("2Players", 1);
        } else if(radioButton5Mistakes.isChecked()){
            editor.putInt("2Players", 2);
        }
        editor.commit();
    }
}