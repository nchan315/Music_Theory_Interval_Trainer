package model;

// Represents a set of keys with each key being an integer
// G is represented as 0, each semitone up from G is the next integer

import java.util.ArrayList;

public class Keyboard {
    protected ArrayList<String[]> intervalRef;

    // EFFECTS: constructs a keyboard with all the intervals
    public Keyboard() {
        intervalRef = new ArrayList<>();
        String[] glist = {"Ab", "A", "Bb", "B", "C", "C#", "Db", "D", "Eb", "E", "F", "F#", "G"};
        String[] gslist = {"A", "A#", "B", "B#", "C#", "Cx", "D", "D#", "E", "E#", "F#", "Fx", "G#"};
        String[] alist = {"Bb", "B", "C", "C#", "D", "D#", "Eb", "E", "F", "F#", "G", "G#", "A"};
        String[] bflist = {"Cb", "C", "Db", "D", "Eb", "E", "Fb", "F", "Gb", "G", "Ab", "A", "Bb"};
        String[] blist = {"C", "C#", "D", "D#", "E", "E#", "F", "F#", "G", "G#", "A", "A#", "B"};
        String[] clist = {"Db", "D", "Eb", "E", "F", "F#", "Gb", "G", "Ab", "A", "Bb", "B", "C"};
        String[] cslist = {"D", "D#", "E", "E#", "F#", "Fx", "G", "G#", "A", "A#", "B", "B#", "C#"};
        String[] dlist = {"Eb", "E", "F", "F#", "G", "G#", "Ab", "A", "Bb", "B", "C", "C#", "D"};
        String[] eflist = {"Fb", "F", "Gb", "G", "Ab", "A", "Bbb", "Bb", "Cb", "C", "Db", "D", "Eb"};
        String[] elist = {"F", "F#", "G", "G#", "A", "A#", "Bb", "B", "C", "C#", "D", "D#", "E"};
        String[] flist = {"Gb", "G", "Ab", "A", "Bb", "B", "Cb", "C", "Db", "D", "Eb", "E", "F"};
        String[] fslist = {"G", "G#", "A", "A#", "B", "B#", "C", "C#", "D", "D#", "E", "E#", "F#"};
        intervalRef.add(glist);
        intervalRef.add(gslist);
        intervalRef.add(alist);
        intervalRef.add(bflist);
        intervalRef.add(blist);
        intervalRef.add(clist);
        intervalRef.add(cslist);
        intervalRef.add(dlist);
        intervalRef.add(eflist);
        intervalRef.add(elist);
        intervalRef.add(flist);
        intervalRef.add(fslist);
    }

    // REQUIRES: one of the valid interval names
    // EFFECTS: returns the position of the interval in the string array
    public int getIntervalRef(String name) {
        if (name.matches("min2")) {
            return 0;
        } else if (name.matches("maj2")) {
            return 1;
        } else if (name.matches("min3")) {
            return 2;
        } else if (name.matches("maj3")) {
            return 3;
        } else if (name.matches("p4")) {
            return 4;
        } else if (name.matches("aug4")) {
            return 5;
        } else if (name.matches("dim5")) {
            return 6;
        } else if (name.matches("p5")) {
            return 7;
        } else if (name.matches("min6")) {
            return 8;
        } else if (name.matches("maj6")) {
            return 9;
        } else if (name.matches("min7")) {
            return 10;
        } else if (name.matches("maj7")) {
            return 11;
        } else {
            return 12;
        }
    }

    // REQUIRES: one of the valid note names
    // EFFECTS: returns the position of the note array in the array of string arrays
    public int getNoteRef(String name) {
        if (name == "G") {
            return 0;
        } else if (name == "G#") {
            return 1;
        } else if (name == "A") {
            return 2;
        } else if (name == "Bb") {
            return 3;
        } else if (name == "B") {
            return 4;
        } else if (name == "C") {
            return 5;
        } else if (name == "C#") {
            return 6;
        } else if (name == "D") {
            return 7;
        } else if (name == "Eb") {
            return 8;
        } else if (name == "E") {
            return 9;
        } else if (name == "F") {
            return 10;
        } else {
            return 11;
        }
    }

    // EFFECTS: given note and interval name, return the correct note
    public String getNextNote(String note1, String name) {
        int noteRef = getNoteRef(note1);
        int nameRef = getIntervalRef(name);
        return intervalRef.get(noteRef)[nameRef];
    }

    // EFFECTS: returns the note name given an int
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public String getNoteName(int i) {
        i = i % 12;
        if (i == 0) {
            return "G";
        } else if (i == 1) {
            return "G#";
        } else if (i == 2) {
            return "A";
        } else if (i == 3) {
            return "Bb";
        } else if (i == 4) {
            return "B";
        } else if (i == 5) {
            return "C";
        } else if (i == 6) {
            return "C#";
        } else if (i == 7) {
            return "D";
        } else if (i == 8) {
            return "Eb";
        } else if (i == 9) {
            return "E";
        } else if (i == 10) {
            return "F";
        } else {
            return "F#";
        }
    }

}
