package ui;

import model.IntervalList;
import model.StatsPage;

import java.util.Scanner;

// Interval trainer app main page
public class IntervalTrainer {
    private StatsPage stats;
    private IntervalList intervals;
    private Scanner scanner;

    // EFFECTS: creates an interval trainer with empty stats page and empty list of intervals
    public IntervalTrainer() {
        stats = new StatsPage();
        intervals = new IntervalList();
        scanner = new Scanner(System.in);
        runIntervalTrainer();
    }

    // MODIFIES: this
    // EFFECTS: runs the interval trainer
    private void runIntervalTrainer() {
        System.out.println("Welcome to the Interval Trainer!");
        System.out.println("Add some intervals to be tested:");
        intervals.addIntervals();

        boolean run = true;
        System.out.println("[i]: Identify intervals\n[f]: Find next note\n[s]: View stats");
        while (run) {
            String input = scanner.next();
            if (input.equals("i")) {
                new IdentifyInterval(intervals);
            } else if (input.equals("f")) {
                new FindNote(intervals);
            } else if (input.equals("s")) {
                stats.displayStats();
            } else {
                System.out.println("Invalid input");
            }
        }


    }


}
