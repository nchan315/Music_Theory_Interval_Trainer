package ui;

import model.IntervalList;
import model.Keyboard;

import java.util.Random;
import java.util.Scanner;

// Activity where given 2 notes, must identity the interval
public class IdentifyInterval {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private boolean gameOn;
    private IntervalList intervals;

    // EFFECTS: creates and runs the identification activity with given list of intervals
    public IdentifyInterval(IntervalList intervals) {
        gameOn = true;
        this.intervals = intervals;
        runActivity();
    }

    // REQUIRES: intervals.size() > 0
    // MODIFIES: stats page
    // EFFECTS: runs the identification activity and updates stats page
    private void runActivity() {
        int note1, note2, index;
        int bound = intervals.getLength();
        while (gameOn) {
            note1 = random.nextInt(13);
            index = random.nextInt(bound);
            note2 = note1 + intervals.getIntervalDist(index);

            System.out.println(kb.getNoteName(note1) + " " + kb.getNoteName(note2));
            String guess = scanner.nextLine();
            String actual = kb.getCorrectInterval(note1, note2);
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
