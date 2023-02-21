package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// a list of intervals to be tested
public class IntervalList {
    private List<Interval> intervals;
    private Scanner scanner;

    // EFFECTS: constructs an empty list of Intervals
    public IntervalList() {
        intervals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // MODIFIES: this
    // EFFECTS: adds interval(s) to the list of intervals
    public void addIntervals() {
        boolean run = true;
        System.out.println("Type \"all\" for all intervals or \"done\" when finished");

        while (run) {
            String input = scanner.next();
            if (input.equals("all")) {
                addAllIntervals();
                run = false;
            } else if (input.equals("done")) {
                run = false;
            } else {
                addInterval(new Interval(input));
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: adds an interval to the list of intervals
    protected void addInterval(Interval interval) {
        intervals.add(interval);
    }

    // MODIFIES: this
    // EFFECTS: adds all possible intervals to the list of intervals
    protected void addAllIntervals() {
        addInterval(new Interval("min2"));
        addInterval(new Interval("maj2"));
        addInterval(new Interval("min3"));
        addInterval(new Interval("maj3"));
        addInterval(new Interval("p4"));
        addInterval(new Interval("aug4"));
        addInterval(new Interval("p5"));
        addInterval(new Interval("min6"));
        addInterval(new Interval("maj6"));
        addInterval(new Interval("min7"));
        addInterval(new Interval("maj7"));
        addInterval(new Interval("p8"));
    }

    // EFFECTS: returns the length of the interval list
    public int getLength() {
        return intervals.size();
    }

    // EFFECTS: returns true if interval is in the list
    public boolean inList(Interval interval) {
        return intervals.contains(interval);
    }
}
