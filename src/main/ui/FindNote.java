package ui;

import model.IntervalList;
import model.Keyboard;
import model.StatsPage;

import java.util.Random;
import java.util.Scanner;

// Activity where student names the next note given note and interval
public class FindNote {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private boolean gameOn;
    private IntervalList intervals;
    private StatsPage stats;

    // EFFECTS: creates and runs the note-naming activity with given list of intervals
    public FindNote(IntervalList intervals, StatsPage stats) {
        gameOn = true;
        this.intervals = intervals;
        this.stats = stats;
        runActivity();
    }

    // REQUIRES: intervals.size() > 0
    // MODIFIES: stats page
    // EFFECTS: runs the note-naming activity and updates stats page
    public void runActivity() {
        int size = intervals.getLength();
        while (gameOn) {
            int note1Number = random.nextInt(13);
            int index = random.nextInt(size);
            String name = intervals.getAt(index);
            String note1 = kb.getNoteName(note1Number);
            String note2 = kb.getNextNote(note1, name);

            System.out.println(note1 + " " + name);
            String guess = scanner.next();
            if (guess.compareTo("q") == 0) {
                gameOn = false;
            } else if (guess.equals(note2)) {
                System.out.println("Correct");
                stats.correctInterval();
            } else {
                System.out.println("Incorrect");
                System.out.println("Correct answer: " + note2);
                stats.incorrectInterval(name);
            }
        }
    }
}
