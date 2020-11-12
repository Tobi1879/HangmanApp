package com.example.hangmanapp.model;

import com.orm.SugarRecord;

public class Settings extends SugarRecord {
    private static int player1Setting;
    private static int player2Setting;

    public static int getPlayer1Setting() {
        return player1Setting;
    }

    public static void setPlayer1Setting(int player1Setting) {
        Settings.player1Setting = player1Setting;
    }

    public static int getPlayer2Setting() {
        return player2Setting;
    }

    public static void setPlayer2Setting(int player2Setting) {
        Settings.player2Setting = player2Setting;
    }
}
