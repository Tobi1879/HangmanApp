package com.example.hangmanapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.hangmanapp.model.Words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    public static final String WORD_LIST = "wordList";

    Button button1Player;
    Button button2Players;
    Button buttonSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // db
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        final Editor editor = pref.edit();
        if (!pref.contains("1Player") || !pref.contains("2Players") || !pref.contains(WORD_LIST)) {
            System.out.println("refernced");

            String[] wordList = {"Abend", "Abfahrt", "Abflug", "Absender", "Adresse", "Alkohol", "Alter", "Ampel", "Anfang", "Angebot", "Angestellte", "Angst", "Ankunft", "Anmeldung", "Anrede", "Anruf", "Anrufbeantworter", "Ansage", "Anschluss", "Antwort", "Anzeige", "Anzug", "Apfel", "Apotheke", "Appartement", "Appetit", "April", "Arbeit", "Arbeitsplatz", "Arm", "Arzt", "Aufenthalt", "Aufgabe", "Aufzug", "Auge", "August", "Ausbildung", "Ausflug", "Ausgang", "Auskunft", "Ausländer", "Ausländerin", "Ausland", "Aussage", "Ausstellung", "Ausweis", "Auto", "Autobahn", "Automat", "Bäckerei", "Büro", "Baby", "Bad", "Bahn", "Bahnhof", "Bahnsteig", "Balkon", "Banane", "Bank", "Batterie", "Baum", "Beamte", "Beamtin", "Bein", "Beispiel", "Bekannte", "Benzin", "Beratung", "Berg", "Beruf", "Berufsschule", "Besuch", "Betrag", "Bett", "Bewerbung", "Bier", "Bild", "Bildschirm", "Birne", "Bitte", "Blatt", "Bleistift", "Blick", "Blume", "Bluse", "Blut", "Bogen", "Bohne", "Brötchen", "Brücke", "Brief", "Briefkasten", "Briefmarke", "Brieftasche", "Briefumschlag", "Brille", "Brot", "Bruder", "Buch", "Buchstabe", "Bus", "Butter", "Café", "CD", "CD-ROM", "Chef", "Computer", "Creme", "Dach", "Dame", "Dank", "Datum", "Dauer", "Deutsche", "Dezember", "Dienstag", "Ding", "Disco", "Doktor", "Dom", "Donnerstag", "Doppelzimmer", "Dorf", "Drucker", "Durchsage", "Durst", "Dusche", "E-Mail", "Ecke", "Ehefrau", "Ehemann", "Ei", "Einführung", "Eingang", "Einladung", "Eintritt", "Einwohner", "Einzelzimmer", "Eis", "Eltern", "Empfänger", "Empfang", "Ende", "Enkel", "Entschuldigung", "Erdgeschoss", "Erfahrung", "Ergebnis", "Erlaubnis", "Ermäßigung", "Erwachsene", "Essen", "Export", "Fähre", "Führerschein", "Führung", "Fabrik", "Fahrer", "Fahrkarte", "Fahrplan", "Fahrrad", "Familie", "Familienname", "Familienstand", "Farbe", "Fax", "Februar", "Fehler", "Fenster", "Ferien", "Fernsehgerät", "Fest", "Feuer", "Feuerwehr", "Feuerzeug", "Fieber", "Film", "Firma", "Fisch", "Flasche", "Fleisch", "Flughafen", "Flugzeug", "Flur", "Fluss", "Formular", "Foto", "Fotoapparat", "Frühjahr", "Frühling", "Frühstück", "Frage", "Frau", "Freitag", "Freizeit", "Freund", "Freundin", "Friseur", "Frist", "Fuß", "Fußball", "Fundbüro", "Gabel", "Garage", "Garten", "Gas", "Gast", "Gebühr", "Geburtsjahr", "Geburtsort", "Geburtstag", "Gegenteil", "Geld", "Geldbörse", "Gemüse", "Gepäck", "Gericht", "Gesamtschule", "Geschäft", "Geschenk", "Geschirr", "Geschwister", "Gesicht", "Gespräch", "Gesundheit", "Getränk", "Gewicht", "Gewitter", "Glück", "Glückwunsch", "Glas", "Gleis", "Goethe-Institut", "Größe", "Die Grenze", "Grippe", "Großeltern", "Großmutter", "Großvater", "Gruß", "Grundschule", "Gruppe", "Guthaben", "Gymnasium", "Hähnchen", "Haar", "Halbpension", "Halle", "Hals", "Haltestelle", "Hand", "Handtuch", "Handy", "Haus", "Hausaufgabe", "Hausfrau", "Haushalt", "Hausmann", "Heimat", "Heizung", "Hemd", "Herbst", "Herd", "Herr", "Herz", "Hilfe", "Hobby", "Holz", "Hose", "Hund", "Hunger", "Idee", "Import", "Industrie", "Information", "Inhalt", "Internet", "Jacke", "Jahr", "Januar", "Job", "Jugendherberge", "Jugendliche", "Juli", "Junge", "Juni", "Käse", "Körper", "Küche", "Kühlschrank", "Kündigung", "Kaffee", "Kalender", "Kamera", "Kanne", "Karte", "Kartoffel", "Kasse", "Kassette", "Kassettenrecorder", "Katze", "Keller", "Kellner", "Kenntnisse", "Kennzeichen", "Kette", "Kfz", "Kind", "Kindergarten", "Kinderwagen", "Kino", "Kiosk", "Kirche", "Klasse", "Kleid", "Kleidung", "Kneipe", "Koffer", "Kollege", "Kollegin", "Konsulat", "Kontakt", "Konto", "Kontrolle", "Konzert", "Kopf", "Kosmetik", "Krankenkasse", "Krankheit", "Kredit", "Kreditkarte", "Kreis", "Kreuzung", "Kuchen", "Kugelschreiber", "Kunde", "Kundin", "Kurs", "Löffel", "Lösung", "Laden", "Lager", "Lampe", "Land", "Landschaft", "Leben", "Lebensmittel", "Leid", "Lehre", "Lehrer", "Lehrerin", "Leute", "Licht", "Lied", "Lkw", "Loch", "Lohn", "Lokal", "Luft", "Lust", "Mädchen", "März", "Möbel", "Müll", "Mülltonne", "Magen", "Mai", "Mal", "Mann", "Mantel", "Markt"};
            Set<String> wordListSet = new HashSet<String>();
            wordListSet.addAll(Arrays.asList(wordList));
            editor.putStringSet(WORD_LIST, wordListSet);
            editor.commit();
            editor.putInt("1Player", 1);
            editor.putInt("2Players", 1);
            wordDeleter();
        }
        wordDeleter();

        // Button 1 Player
        button1Player = (Button) findViewById(R.id.button1Player);
        button1Player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenGameActivity();
            }
        });

        // Button 2 Player
        button2Players = (Button) findViewById(R.id.button2Players);
        button2Players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenChooseWordActivity();
            }
        });

        buttonSettings = (Button) findViewById(R.id.buttonSettings);
        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doOpenSettingsActivity();
            }
        });
    }

    private void doOpenGameActivity() {
        System.out.println("in");
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        SinglePlayerWordPicker singlePlayerWordPicker = new SinglePlayerWordPicker();
        String word = singlePlayerWordPicker.wordPicker(pref);

        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("EXTRA_WORD", word);
        intent.putExtra("EXTRA_MODE", 1);
        startActivity(intent);
    }

    private void doOpenSettingsActivity() {
        Intent intent = new Intent(this, DifficultySettingsActivity.class);
        startActivity(intent);
    }

    public void doOpenChooseWordActivity() {
        Intent intent = new Intent(this, ChooseWordActivity.class);
        startActivity(intent);
    }

    public String doWordsString(String words){
        String words2 = words.replace("\n", "', '");
        return words2;
    }

    public void wordDeleter(){
        final SharedPreferences pref = getApplicationContext().getSharedPreferences("Settings", MODE_PRIVATE);
        final Editor editor = pref.edit();
        System.out.println("worddeleter");
        Set<String> wordList = pref.getStringSet(WORD_LIST, null);
        List<String> removeList = new ArrayList();

        Iterator<String> it = wordList.iterator();
        while(it.hasNext()) {
            String word;
            word = it.next();
            if (word.length() < 5 ||word.length() > 15 || word.contains("Ä") || word.contains("ä") || word.contains("Ö") || word.contains("ö") || word.contains("Ü") || word.contains("ü") || word.contains("ß")) {
                //wordList.remove(word);
                //System.out.println("delete " + word);
                removeList.add(word);
            }
        }
        wordList.removeAll(removeList);
        System.out.println(wordList);
        System.out.println(wordList.size());
        editor.putStringSet(WORD_LIST, wordList);
        System.out.println(editor.commit());
        System.out.println(pref.getStringSet(WORD_LIST, null).size());
        Log.d("PREFERENCES",pref.getStringSet(WORD_LIST, null).size()+"");
    }
}