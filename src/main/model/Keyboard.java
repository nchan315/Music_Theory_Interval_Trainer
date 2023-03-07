package model;

// Represents a set of keys with each key being an integer
// G is represented as 0, each semitone up from G is the next integer

import java.util.ArrayList;

public class Keyboard {
    protected ArrayList<String[]> intervalRef;
    protected ArrayList<String> allNotes;
    protected ArrayList<String> allIntervals;

    // EFFECTS: constructs a keyboard with all the intervals
    public Keyboard() {
        makeIntervalRef();
        makeAllNotes();
        makeAllIntervals();
    }

    // MODIFIES: this
    // EFFECTS: creates all possible intervals in a list
    private void makeIntervalRef() {
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

    // MODIFIES: this
    // EFFECTS: puts all notes in a list
    private void makeAllNotes() {
        allNotes = new ArrayList<>();
        allNotes.add("G");
        allNotes.add("G#");
        allNotes.add("A");
        allNotes.add("Bb");
        allNotes.add("B");
        allNotes.add("C");
        allNotes.add("C#");
        allNotes.add("D");
        allNotes.add("Eb");
        allNotes.add("E");
        allNotes.add("F");
        allNotes.add("F#");
    }

    // MODIFIES: this
    // EFFECTS: puts all intervals in a list
    private void makeAllIntervals() {
        allIntervals = new ArrayList<>();
        allIntervals.add("min2");
        allIntervals.add("maj2");
        allIntervals.add("min3");
        allIntervals.add("maj3");
        allIntervals.add("p4");
        allIntervals.add("aug4");
        allIntervals.add("dim5");
        allIntervals.add("p5");
        allIntervals.add("min6");
        allIntervals.add("maj6");
        allIntervals.add("min7");
        allIntervals.add("maj7");
        allIntervals.add("p8");
    }

    // REQUIRES: one of the valid interval names
    // EFFECTS: returns the position of the interval in the string array
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    public int getIntervalRefNum(String name) {
        return allIntervals.indexOf(name);
    }

    // REQUIRES: one of the valid note names
    // EFFECTS: returns the position of the note array in the array of string arrays
    public int getNoteRef(String name) {
        return allNotes.indexOf(name);
    }

    // EFFECTS: given note and interval name, return the correct note
    public String getNextNote(String note1, String name) {
        int noteRef = getNoteRef(note1);
        int nameRef = getIntervalRefNum(name);
        return intervalRef.get(noteRef)[nameRef];
    }

    // EFFECTS: returns the note name given an int
    public String getNoteName(int i) {
        i = i % 12;
        return allNotes.get(i);
    }

}
