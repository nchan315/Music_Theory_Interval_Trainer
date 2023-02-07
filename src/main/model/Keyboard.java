package model;

// Represents a set of keys with each key being an integer
// G is represented as 0, each semitone up from G is the next integer

public class Keyboard {

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

    public void fullKeyboard() {}

}
