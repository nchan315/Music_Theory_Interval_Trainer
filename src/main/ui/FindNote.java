package ui;

import model.IntervalList;
import model.Keyboard;

import java.util.Random;
import java.util.Scanner;

// Activity where student names the next note given note and interval
public class FindNote {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private boolean gameOn;
    private IntervalList intervals;

    // EFFECTS: creates and runs the note-naming activity with given list of intervals
    public FindNote(IntervalList intervals) {
        gameOn = true;
        this.intervals = intervals;
        runActivity();
    }

    // REQUIRES: intervals.size() > 0
    // MODIFIES: stats page
    // EFFECTS: runs the note-naming activity and updates stats page
    public void runActivity() {
        int size = intervals.getLength();
        while (gameOn == true) {
            int note1 = random.nextInt(13);
            int index = random.nextInt(size);
            String interval = intervals.getIntervalName(index);
            System.out.println(kb.getNoteName(note1) + " " + interval);
            int note2 = kb.getNextNote(note1, interval);

            String guess = scanner.next();
            String actual = kb.getNoteName(note2);
            if (guess.compareTo("quit") == 0) {
                gameOn = false;
            } else if (guess.equals(actual)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
                System.out.println("Correct answer: " + actual);
            }
        }
    }
}
