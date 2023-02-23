package ui;

import model.IntervalList;
import model.Keyboard;
import model.StatsPage;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Activity where given 2 notes, must identity the interval
public class IdentifyInterval {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private boolean gameOn;
    private IntervalList intervals;
    private StatsPage stats;

    // EFFECTS: creates and runs the identification activity with given list of intervals
    public IdentifyInterval(IntervalList intervals, StatsPage stats) {
        gameOn = true;
        this.intervals = intervals;
        this.stats = stats;
        runActivity();
    }

    // REQUIRES: intervals.size() > 0
    // MODIFIES: stats page
    // EFFECTS: runs the identification activity and updates stats page
    private void runActivity() {
        int bound = intervals.getLength();
        while (gameOn) {
            int note1Number = random.nextInt(13); // picks a random note
            int index = random.nextInt(bound); // picks a random interval from the list
            String note1 = kb.getNoteName(note1Number);
            String name = intervals.getAt(index);
            String note2 = kb.getNextNote(note1, name);

            System.out.println(note1 + " " + note2);
            String guess = scanner.nextLine();
            if (guess.compareTo("q") == 0) {
                gameOn = false;
            } else if (guess.compareTo(name) == 0) {
                System.out.println("Correct");
                stats.correctInterval();
            } else {
                stats.incorrectInterval(name);
                System.out.println("Incorrect");
                System.out.println("Correct answer: " + name);
            }
        }
    }

}
