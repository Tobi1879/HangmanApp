package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hangmanapp.model.Settings;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public class GameActivity extends AppCompatActivity {
    String word;
    String letters[];

    Button buttonExitGame;

    Boolean[] wonBooleans = new Boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
    TextView textViewLetter1;
    TextView textViewLetter2;
    TextView textViewLetter3;
    TextView textViewLetter4;
    TextView textViewLetter5;
    TextView textViewLetter6;
    TextView textViewLetter7;
    TextView textViewLetter8;
    TextView textViewLetter9;
    TextView textViewLetter10;
    TextView textViewLetter11;
    TextView textViewLetter12;
    TextView textViewLetter13;
    TextView textViewLetter14;
    TextView textViewLetter15;

    Button buttonA;
    Button buttonB;
    Button buttonC;
    Button buttonD;
    Button buttonE;
    Button buttonF;
    Button buttonG;
    Button buttonH;
    Button buttonI;
    Button buttonJ;
    Button buttonK;
    Button buttonL;
    Button buttonM;
    Button buttonN;
    Button buttonO;
    Button buttonP;
    Button buttonQ;
    Button buttonR;
    Button buttonS;
    Button buttonT;
    Button buttonU;
    Button buttonV;
    Button buttonW;
    Button buttonX;
    Button buttonY;
    Button buttonZ;

    ImageView imageViewGamePicture;

    int mode;

    int errors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonExitGame = (Button) findViewById(R.id.buttonExitGameWon);

        buttonExitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenMain();
            }
        });

        textViewLetter1 = (TextView) findViewById(R.id.textViewLetter1);
        textViewLetter2 = (TextView) findViewById(R.id.textViewLetter2);
        textViewLetter3 = (TextView) findViewById(R.id.textViewLetter3);
        textViewLetter4 = (TextView) findViewById(R.id.textViewLetter4);
        textViewLetter5 = (TextView) findViewById(R.id.textViewLetter5);
        textViewLetter6 = (TextView) findViewById(R.id.textViewLetter6);
        textViewLetter7 = (TextView) findViewById(R.id.textViewLetter7);
        textViewLetter8 = (TextView) findViewById(R.id.textViewLetter8);
        textViewLetter9 = (TextView) findViewById(R.id.textViewLetter9);
        textViewLetter10 = (TextView) findViewById(R.id.textViewLetter10);
        textViewLetter11 = (TextView) findViewById(R.id.textViewLetter11);
        textViewLetter12 = (TextView) findViewById(R.id.textViewLetter12);
        textViewLetter13 = (TextView) findViewById(R.id.textViewLetter13);
        textViewLetter14 = (TextView) findViewById(R.id.textViewLetter14);
        textViewLetter15 = (TextView) findViewById(R.id.textViewLetter15);

        setUnderline(textViewLetter1);
        setUnderline(textViewLetter2);
        setUnderline(textViewLetter3);
        setUnderline(textViewLetter4);
        setUnderline(textViewLetter5);
        setUnderline(textViewLetter6);
        setUnderline(textViewLetter7);
        setUnderline(textViewLetter8);
        setUnderline(textViewLetter9);
        setUnderline(textViewLetter10);
        setUnderline(textViewLetter11);
        setUnderline(textViewLetter12);
        setUnderline(textViewLetter13);
        setUnderline(textViewLetter14);
        setUnderline(textViewLetter15);

        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
        buttonD = (Button) findViewById(R.id.buttonD);
        buttonE = (Button) findViewById(R.id.buttonE);
        buttonF = (Button) findViewById(R.id.buttonF);
        buttonG = (Button) findViewById(R.id.buttonG);
        buttonH = (Button) findViewById(R.id.buttonH);
        buttonI = (Button) findViewById(R.id.buttonI);
        buttonJ = (Button) findViewById(R.id.buttonJ);
        buttonK = (Button) findViewById(R.id.buttonK);
        buttonL = (Button) findViewById(R.id.buttonL);
        buttonM = (Button) findViewById(R.id.buttonM);
        buttonN = (Button) findViewById(R.id.buttonN);
        buttonO = (Button) findViewById(R.id.buttonO);
        buttonP = (Button) findViewById(R.id.buttonP);
        buttonQ = (Button) findViewById(R.id.buttonQ);
        buttonR = (Button) findViewById(R.id.buttonR);
        buttonS = (Button) findViewById(R.id.buttonS);
        buttonT = (Button) findViewById(R.id.buttonT);
        buttonU = (Button) findViewById(R.id.buttonU);
        buttonV = (Button) findViewById(R.id.buttonV);
        buttonW = (Button) findViewById(R.id.buttonW);
        buttonX = (Button) findViewById(R.id.buttonX);
        buttonY = (Button) findViewById(R.id.buttonY);
        buttonZ = (Button) findViewById(R.id.buttonZ);

        imageViewGamePicture = (ImageView) findViewById(R.id.imageViewGamePicture);

        setClickListener(buttonA, "A");
        setClickListener(buttonB, "B");
        setClickListener(buttonC, "C");
        setClickListener(buttonD, "D");
        setClickListener(buttonE, "E");
        setClickListener(buttonF, "F");
        setClickListener(buttonG, "G");
        setClickListener(buttonH, "H");
        setClickListener(buttonI, "I");
        setClickListener(buttonJ, "J");
        setClickListener(buttonK, "K");
        setClickListener(buttonL, "L");
        setClickListener(buttonM, "M");
        setClickListener(buttonN, "N");
        setClickListener(buttonO, "O");
        setClickListener(buttonP, "P");
        setClickListener(buttonQ, "Q");
        setClickListener(buttonR, "R");
        setClickListener(buttonS, "S");
        setClickListener(buttonT, "T");
        setClickListener(buttonU, "U");
        setClickListener(buttonV, "V");
        setClickListener(buttonW, "W");
        setClickListener(buttonX, "X");
        setClickListener(buttonY, "Y");
        setClickListener(buttonZ, "Z");

        mode = getIntent().getIntExtra("EXTRA_MODE", 2);
        word = getIntent().getStringExtra("EXTRA_WORD");
        word = word.toUpperCase();
        letters = word.split("(?!^)");
        Arrays.fill(wonBooleans, 0, letters.length, false);

        Log.d("GAME_DEBUG","amount of letters "+ word.length());

        int wordLength = word.length();

        if(wordLength <= 14){
            textViewLetter15.setVisibility(View.GONE);
        }
        if(wordLength <= 13){
            textViewLetter14.setVisibility(View.GONE);
        }
        if(wordLength <= 12){
            textViewLetter13.setVisibility(View.GONE);
        }
        if(wordLength <= 11){
            textViewLetter12.setVisibility(View.GONE);
        }
        if(wordLength <= 10){
            textViewLetter11.setVisibility(View.GONE);
        }
        if(wordLength <= 9){
            textViewLetter10.setVisibility(View.GONE);
        }
        if(wordLength <= 8){
            textViewLetter9.setVisibility(View.GONE);
        }
        if(wordLength <= 7){
            textViewLetter8.setVisibility(View.GONE);
        }
        if(wordLength <= 6){
            textViewLetter7.setVisibility(View.GONE);
        }
        if(wordLength <= 5){
            textViewLetter6.setVisibility(View.GONE);
        }

        System.out.println(word);
    }

    private void doOpenMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void setClickListener(final Button button, final String letterPressed){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLetterClick(button, letterPressed);
            }
        });
    }

    private void doLetterClick(Button button, String letterPressed) {
        button.setClickable(false);
        Boolean correctLetter = false;

        for(int i = 0; i < letters.length; i++){
            if (letters[i].equals(letterPressed)){
                button.setTextColor(Color.GREEN);
                button.setBackgroundColor(Color.TRANSPARENT);
                correctLetter = true;
                textViewWriter(i).setText(letterPressed);
                wonBooleans[i] = true;
                checkIfWon();
            }
        }
        if (!correctLetter){
            errors++;
            if (mode == 1){
                if(Settings.getPlayer1Setting() == 1 || Settings.getPlayer1Setting() == 2){
                    updatePicture(10);
                } else if (Settings.getPlayer1Setting() == 3){
                    updatePicture(5);
                } else {
                    updatePicture(10);
                }
            } else if (mode == 2){
                if(Settings.getPlayer2Setting() == 1){
                    updatePicture(10);
                } else if (Settings.getPlayer2Setting() == 2){
                    updatePicture(5);
                } else {
                    updatePicture(10);
                }
            }
            button.setTextColor(Color.RED);
            button.setBackgroundColor(Color.TRANSPARENT);
        }
    }

    private void checkIfWon() {
        Boolean won = true;
        for (int i = 0; i < 15; i++){
            if (!wonBooleans[i]){
                won = false;
            }
        }
        if (won){
            Intent intent = new Intent(this, WonActivity.class);
            startActivity(intent);
        }
    }

    private void updatePicture(int value) {
        if (value == 10) {
            if (errors == 1) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture1transparent);
            } else if (errors == 2) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture2transparent);
            } else if (errors == 3) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture3transparent);
            } else if (errors == 4) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture4transparent);
            } else if (errors == 5) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture5transparent);
            } else if (errors == 6) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture6transparent);
            } else if (errors == 7) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture7transparent);
            } else if (errors == 8) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture8transparent);
            } else if (errors == 9) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture9transparent);
            } else if (errors == 10) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture10transparent);
                lost();
            }
        } else if (value == 5){
            if (errors == 1) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture5transparent);
            } else if (errors == 2) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture6transparent);
            } else if (errors == 3) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture8transparent);
            } else if (errors == 4) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture9transparent);
            } else if (errors == 5) {
                imageViewGamePicture.setImageResource(R.drawable.hangmangamepicture10transparent);
                lost();
            }
        }
    }

    private void lost() {
        Intent intent = new Intent(this, LostActivity.class);
        startActivity(intent);
    }

    private TextView textViewWriter(int index){
        if (index == 0){
            return textViewLetter1;
        } else if (index == 1){
            return textViewLetter2;
        }
        else if (index == 2){
            return textViewLetter3;
        }
        else if (index == 3){
            return textViewLetter4;
        }
        else if (index == 4){
            return textViewLetter5;
        }
        else if (index == 5){
            return textViewLetter6;
        }
        else if (index == 6){
            return textViewLetter7;
        }
        else if (index == 7){
            return textViewLetter8;
        }
        else if (index == 8){
            return textViewLetter9;
        }
        else if (index == 9){
            return textViewLetter10;
        }
        else if (index == 10){
            return textViewLetter11;
        }
        else if (index == 11){
            return textViewLetter12;
        }
        else if (index == 12){
            return textViewLetter13;
        }
        else if (index == 13){
            return textViewLetter14;
        }
        else if (index == 14){
            return textViewLetter15;
        }
        return null;
    }

    public void setUnderline(TextView textView) {
        SpannableString string = new SpannableString("     ");
        string.setSpan(new UnderlineSpan(), 0, 4, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(string);
    }
}