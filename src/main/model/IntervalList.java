package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static javax.swing.UIManager.get;

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
        System.out.println("Type \"all\" to add all intervals or \"done\" when finished");

        while (run) {
            String input = scanner.nextLine();
            if (input.equals("all")) {
                addAllIntervals();
                run = false;
            } else if (input.equals("done")) {
                System.out.println(allIntervalNames());
                run = false;
            } else {
                addInterval(new Interval(input));
            }
        }
    }

    // EFFECTS: returns all the intervals in the list
    protected String allIntervalNames() {
        String string = "";
        for (Interval i : intervals) {
            string = string + i.getIntervalName() + " ";
        }
        return string;
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

    // REQUIRES: j < intervals.size()
    // EFFECTS: returns the name of an interval at index j
    public String getIntervalName(int j) {
        Interval i = intervals.get(j);
        return i.getIntervalName();
    }

    // REQUIRES: j < intervals.size()
    // EFFECTS: returns the distance of an interval at index j
    public int getIntervalDist(int j) {
        Interval i = intervals.get(j);
        return i.getIntervalDistance();
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
