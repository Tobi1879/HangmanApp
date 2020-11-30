package com.example.hangmanapp.model;

import com.orm.SugarRecord;
import com.orm.util.Collection;

import java.util.ArrayList;
import java.util.List;

public class Words extends SugarRecord {
    private List words = new ArrayList();
    //private static String[] words = {"Abend", "Abfahrt", "Abflug", "Absender", "Adresse", "Alkohol", "Alter", "Ampel", "Anfang", "Angebot", "Angestellte", "Angst", "Ankunft", "Anmeldung", "Anrede", "Anruf", "Anrufbeantworter", "Ansage", "Anschluss", "Antwort", "Anzeige", "Anzug", "Apfel", "Apotheke", "Appartement", "Appetit", "April", "Arbeit", "Arbeitsplatz", "Arm", "Arzt", "Aufenthalt", "Aufgabe", "Aufzug", "Auge", "August", "Ausbildung", "Ausflug", "Ausgang", "Auskunft", "Ausländer", "Ausländerin", "Ausland", "Aussage", "Ausstellung", "Ausweis", "Auto", "Autobahn", "Automat", "Bäckerei", "Büro", "Baby", "Bad", "Bahn", "Bahnhof", "Bahnsteig", "Balkon", "Banane", "Bank", "Batterie", "Baum", "Beamte", "Beamtin", "Bein", "Beispiel", "Bekannte", "Benzin", "Beratung", "Berg", "Beruf", "Berufsschule", "Besuch", "Betrag", "Bett", "Bewerbung", "Bier", "Bild", "Bildschirm", "Birne", "Bitte", "Blatt", "Bleistift", "Blick", "Blume", "Bluse", "Blut", "Bogen", "Bohne", "Brötchen", "Brücke", "Brief", "Briefkasten", "Briefmarke", "Brieftasche", "Briefumschlag", "Brille", "Brot", "Bruder", "Buch", "Buchstabe", "Bus", "Butter", "Café", "CD", "CD-ROM", "Chef", "Computer", "Creme", "Dach", "Dame", "Dank", "Datum", "Dauer", "Deutsche", "Dezember", "Dienstag", "Ding", "Disco", "Doktor", "Dom", "Donnerstag", "Doppelzimmer", "Dorf", "Drucker", "Durchsage", "Durst", "Dusche", "E-Mail", "Ecke", "Ehefrau", "Ehemann", "Ei", "Einführung", "Eingang", "Einladung", "Eintritt", "Einwohner", "Einzelzimmer", "Eis", "Eltern", "Empfänger", "Empfang", "Ende", "Enkel", "Entschuldigung", "Erdgeschoss", "Erfahrung", "Ergebnis", "Erlaubnis", "Ermäßigung", "Erwachsene", "Essen", "Export", "Fähre", "Führerschein", "Führung", "Fabrik", "Fahrer", "Fahrkarte", "Fahrplan", "Fahrrad", "Familie", "Familienname", "Familienstand", "Farbe", "Fax", "Februar", "Fehler", "Fenster", "Ferien", "Fernsehgerät", "Fest", "Feuer", "Feuerwehr", "Feuerzeug", "Fieber", "Film", "Firma", "Fisch", "Flasche", "Fleisch", "Flughafen", "Flugzeug", "Flur", "Fluss", "Formular", "Foto", "Fotoapparat", "Frühjahr", "Frühling", "Frühstück", "Frage", "Frau", "Freitag", "Freizeit", "Freund", "Freundin", "Friseur", "Frist", "Fuß", "Fußball", "Fundbüro", "Gabel", "Garage", "Garten", "Gas", "Gast", "Gebühr", "Geburtsjahr", "Geburtsort", "Geburtstag", "Gegenteil", "Geld", "Geldbörse", "Gemüse", "Gepäck", "Gericht", "Gesamtschule", "Geschäft", "Geschenk", "Geschirr", "Geschwister", "Gesicht", "Gespräch", "Gesundheit", "Getränk", "Gewicht", "Gewitter", "Glück", "Glückwunsch", "Glas", "Gleis", "Goethe-Institut", "Größe", "Die Grenze", "Grippe", "Großeltern", "Großmutter", "Großvater", "Gruß", "Grundschule", "Gruppe", "Guthaben", "Gymnasium", "Hähnchen", "Haar", "Halbpension", "Halle", "Hals", "Haltestelle", "Hand", "Handtuch", "Handy", "Haus", "Hausaufgabe", "Hausfrau", "Haushalt", "Hausmann", "Heimat", "Heizung", "Hemd", "Herbst", "Herd", "Herr", "Herz", "Hilfe", "Hobby", "Holz", "Hose", "Hund", "Hunger", "Idee", "Import", "Industrie", "Information", "Inhalt", "Internet", "Jacke", "Jahr", "Januar", "Job", "Jugendherberge", "Jugendliche", "Juli", "Junge", "Juni", "Käse", "Körper", "Küche", "Kühlschrank", "Kündigung", "Kaffee", "Kalender", "Kamera", "Kanne", "Karte", "Kartoffel", "Kasse", "Kassette", "Kassettenrecorder", "Katze", "Keller", "Kellner", "Kenntnisse", "Kennzeichen", "Kette", "Kfz", "Kind", "Kindergarten", "Kinderwagen", "Kino", "Kiosk", "Kirche", "Klasse", "Kleid", "Kleidung", "Kneipe", "Koffer", "Kollege", "Kollegin", "Konsulat", "Kontakt", "Konto", "Kontrolle", "Konzert", "Kopf", "Kosmetik", "Krankenkasse", "Krankheit", "Kredit", "Kreditkarte", "Kreis", "Kreuzung", "Kuchen", "Kugelschreiber", "Kunde", "Kundin", "Kurs", "Löffel", "Lösung", "Laden", "Lager", "Lampe", "Land", "Landschaft", "Leben", "Lebensmittel", "Leid", "Lehre", "Lehrer", "Lehrerin", "Leute", "Licht", "Lied", "Lkw", "Loch", "Lohn", "Lokal", "Luft", "Lust", "Mädchen", "März", "Möbel", "Müll", "Mülltonne", "Magen", "Mai", "Mal", "Mann", "Mantel", "Markt"};

    public Words() {

    }

    public Words(List words) {
        this.words = words;
    }

    public List getWords() {
        return words;
    }

    public void setWords(List words) {
        this.words = words;
    }
}
