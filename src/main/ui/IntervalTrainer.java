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
        System.out.println("Add some intervals to be tested:\nType \"all\" for all intervals"
                + " or \"done\" when finished");
        addIntervals();

        boolean run = true;
        while (run) {
            displayMenu();
            String input = scanner.next();
            if (input.equals("i")) {
                new IdentifyInterval(intervals, stats);
            } else if (input.equals("f")) {
                new FindNote(intervals, stats);
            } else if (input.equals("s")) {
                stats.displayStats();
            } else if (input.equals("q")) {
                run = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    // EFFECTS: displays the menu options
    private void displayMenu() {
        System.out.println("[i]: Identify intervals\n[f]: Find next note\n[s]: View stats\n[q]: Quit");
    }

    // MODIFIES: IntervalList
    // EFFECTS: ui for adding testable intervals
    private void addIntervals() {
        Boolean addMore = true;
        while (addMore) {
            String toAdd = scanner.next();
            if (toAdd.equals("all")) {
                intervals.addAllIntervals();
                addMore = false;
            } else if (toAdd.equals("done")) {
                addMore = false;
            } else {
                intervals.addInterval(toAdd);
            }
        }
        System.out.println(intervals.allIntervalNames());
    }


}
