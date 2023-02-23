package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// a list of intervals to be tested
public class IntervalList {
    private List<String> intervals;
    private Scanner scanner;

    // EFFECTS: constructs an empty list of Intervals
    public IntervalList() {
        intervals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // MODIFIES: this
    // EFFECTS: adds interval(s) to the list of intervals
    public int addIntervals() {
        boolean run = true;
        System.out.println("Type \"all\" to add all intervals or \"done\" when finished");

        while (run) {
            String input = scanner.nextLine();
            if (input.equals("all")) {
                addAllIntervals();
                run = false;
            } else if (input.equals("done")) {
                run = false;
            } else {
                addInterval(input);
            }
            System.out.println(allIntervalNames());
        }
        return 0;
    }

    // MODIFIES: this
    // EFFECTS: adds all possible intervals to the list of intervals
    protected void addAllIntervals() {
        addInterval("min2");
        addInterval("maj2");
        addInterval("min3");
        addInterval("maj3");
        addInterval("p4");
        addInterval("aug4");
        addInterval("dim5");
        addInterval("p5");
        addInterval("min6");
        addInterval("maj6");
        addInterval("min7");
        addInterval("maj7");
        addInterval("p8");
    }

    // MODIFIES: this
    // EFFECTS: adds an interval to the list of intervals
    protected void addInterval(String interval) {
        intervals.add(interval);
    }

    // EFFECTS: returns all the intervals in the list
    protected String allIntervalNames() {
        String string = "";
        for (String i : intervals) {
            string = string + i + " ";
        }
        return string;
    }

    // REQUIRES: i < intervals.size()
    // EFFECTS: returns the interval at the index
    public String getAt(int i) {
        return intervals.get(i);
    }

    // EFFECTS: returns the length of the interval list
    public int getLength() {
        return intervals.size();
    }

    // EFFECTS: returns true if interval is in the list
    public boolean inList(String interval) {
        return intervals.contains(interval);
    }

}
