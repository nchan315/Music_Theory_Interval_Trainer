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
    // EFFECTS: adds all possible intervals to the list of intervals
    public void addAllIntervals() {
        intervals = new ArrayList<>();
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
    public void addInterval(String interval) {
        intervals.add(interval);
    }

    // MODIFIES: this
    // EFFECTS: removes an interval from the list of intervals
    public void removeInterval(String interval) {
        intervals.remove(interval);
    }

    // EFFECTS: returns all the intervals in the list
    public String allIntervalNames() {
        String string = "";
        for (String i : intervals) {
            string = string + i + " ";
        }
        return string;
    }

    // MODIFIES: this
    // EFFECTS: removes all intervals in the list
    public void removeAllIntervals() {
        intervals = new ArrayList<>();
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

    // EFFECTS: returns true if string is valid interval
    public boolean isValid(String interval) {
        return interval.equals("min2") || interval.equals("maj2") || interval.equals("min3")
                || interval.equals("maj3") || interval.equals("p4") || interval.equals("aug4")
                || interval.equals("dim5") || interval.equals("p5") || interval.equals("min6")
                || interval.equals("maj6") || interval.equals("min7") || interval.equals("maj7")
                || interval.equals("p8");
    }

}
