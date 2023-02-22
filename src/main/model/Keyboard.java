package model;

// Represents a set of keys with each key being an integer
// G is represented as 0, each semitone up from G is the next integer

public class Keyboard {

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
            return "A#";
        } else if (i == 4) {
            return "B";
        } else if (i == 5) {
            return "C";
        } else if (i == 6) {
            return "C#";
        } else if (i == 7) {
            return "D";
        } else if (i == 8) {
            return "D#";
        } else if (i == 9) {
            return "E";
        } else if (i == 10) {
            return "F";
        } else {
            return "F#";
        }
    }

    // EFFECTS: returns the interval given 2 note integers
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public String getCorrectInterval(int note1, int note2) {
        int dist = note2 - note1;
        if (dist == 1) {
            return "min2";
        } else if (dist == 2) {
            return "maj2";
        } else if (dist == 3) {
            return "min3";
        } else if (dist == 4) {
            return "maj3";
        } else if (dist == 5) {
            return "p4";
        } else if (dist == 6) {
            return "aug4";
        } else if (dist == 7) {
            return "p5";
        } else if (dist == 8) {
            return "min6";
        } else if (dist == 9) {
            return "maj6";
        } else if (dist == 10) {
            return "min7";
        } else if (dist == 11) {
            return "maj7";
        } else {
            return "p8";
        }
    }

    // REQUIRES: note1 >= 0
    // EFFECTS: returns the next note given bottom note and interval
    public int getNextNote(int note1, String name) {
        Interval interval = new Interval(name);
        int dist = interval.getIntervalDistance();
        int note2 = note1 + dist;
        return note2;
    }
}
