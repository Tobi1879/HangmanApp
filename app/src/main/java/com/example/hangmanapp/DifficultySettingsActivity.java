package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.hangmanapp.model.Settings;

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

        switch (Settings.getPlayer1Setting()){
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

        switch (Settings.getPlayer2Setting()){
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
        if(radioButtonEasy.isChecked()){
            Settings.setPlayer1Setting(1);
        } else if(radioButtonMedium.isChecked()){
            Settings.setPlayer1Setting(2);
        } else if(radioButtonHard.isChecked()){
            Settings.setPlayer1Setting(3);
        }

        if(radioButton10Mistakes.isChecked()){
            Settings.setPlayer2Setting(1);
        } else if(radioButton5Mistakes.isChecked()){
            Settings.setPlayer2Setting(2);
        }
    }
}