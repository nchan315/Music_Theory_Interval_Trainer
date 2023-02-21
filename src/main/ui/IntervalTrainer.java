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
        runIntervalTrainer();
    }

    // MODIFIES: this
    // EFFECTS: runs the interval trainer
    private void runIntervalTrainer() {
        System.out.println("Welcome to the Interval Trainer!");
        System.out.println("Add some intervals to be tested:");
        intervals.addIntervals();
    }


    //System.out.println("[i]: Identify intervals");
    //System.out.println("[f]: Find next note");


}
