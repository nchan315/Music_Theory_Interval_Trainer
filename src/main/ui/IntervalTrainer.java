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
        boolean run = true;
        while (run) {
            displayMenu();
            String input = scanner.nextLine();
            if (input.equals("a")) {
                addIntervals();
            } else if (input.equals("r")) {
                removeIntervals();
            } else if (input.equals("i")) {
                startIdentifyInteval();
            } else if (input.equals("f")) {
                startFindNote();
            } else if (input.equals("s")) {
                String message = stats.displayStats();
                System.out.println(message);
            } else if (input.equals("q")) {
                run = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    // EFFECTS: starts the identification activity if list size > 0
    private void startIdentifyInteval() {
        if (intervals.getLength() > 0) {
            new IdentifyInterval(intervals, stats);
        } else {
            displaySizeError();
        }
    }

    // EFFECTS: starts the find note activity if list size > 0
    private void startFindNote() {
        if (intervals.getLength() > 0) {
            new FindNote(intervals, stats);
        } else {
            displaySizeError();
        }
    }

    // EFFECTS: displays the menu options
    private void displayMenu() {
        System.out.println("[a]: Add interval\n[r]: Remove interval\n[i]: Identify intervals\n[f]: Find next note"
                + "\n[s]: View stats\n[q]: Quit");
    }

    // EFFECTS: displays the error message
    private void displaySizeError() {
        System.out.println("Must have at least 1 interval in the list!");
    }

    // MODIFIES: this
    // EFFECTS: ui for adding testable intervals
    private void addIntervals() {
        System.out.println("Add some intervals to be tested:\nType \"all\" for all intervals"
                + " or \"done\" when finished");
        Boolean addMore = true;
        while (addMore) {
            String toAdd = scanner.nextLine();
            if (toAdd.equals("all")) {
                intervals.addAllIntervals();
                addMore = false;
            } else if (toAdd.equals("done")) {
                addMore = false;
            } else {
                if (intervals.isValid(toAdd)) {
                    intervals.addInterval(toAdd);
                } else {
                    System.out.println("Invalid interval");
                }
            }
        }
        System.out.println(intervals.allIntervalNames());
    }

    // MODIFIES: this
    // EFFECTS: ui for removing testable intervals
    private void removeIntervals() {
        System.out.println("Remove some intervals:\nType \"all\" for all intervals"
                + " or \"done\" when finished");
        Boolean removeMore = true;
        while (removeMore) {
            String remove = scanner.nextLine();
            if (remove.equals("all")) {
                intervals.removeAllIntervals();
                removeMore = false;
            } else if (remove.equals("done")) {
                removeMore = false;
            } else {
                if (intervals.isValid(remove)) {
                    intervals.removeInterval(remove);
                } else {
                    System.out.println("Invalid interval");
                }
            }
        }
        System.out.println(intervals.allIntervalNames());
    }

}
