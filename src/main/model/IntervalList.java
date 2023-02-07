package model;

import java.util.ArrayList;
import java.util.List;

public class IntervalList {
    private List<Interval> intervalList;

    public IntervalList() {
        intervalList = new ArrayList<>();
    }

    public void addInterval(Interval interval) {
        intervalList.add(interval);
    }

    public void removeInterval(Interval interval) {
        intervalList.remove(interval);
    }

    public String getCorrectInterval(int note1, int note2) {
        int dist = note2 - note1;
        if (dist == 1) {
            return "min2";
        } else if (dist == 2) {
            return "maj2";
        } else if (dist == 3) {
            return "min3";
        } else if (dist == 4) {
            return "maj3";
        } else if (dist == 5) {
            return "p4";
        } else if (dist == 6) {
            return "aug4";
        } else if (dist == 7) {
            return "p5";
        } else if (dist == 8) {
            return "min6";
        } else if (dist == 9) {
            return "maj6";
        } else if (dist == 10) {
            return "min7";
        } else if (dist == 11) {
            return "maj7";
        } else {
            return "p8";
        }
    }

    /*
    public void addAllIntervals() {

        intervalList.addInterval(new Interval("min2"));

        Interval maj2 = new Interval("maj2");
        Interval min3 = new Interval("min3");
        Interval maj3 = new Interval("maj3");
        Interval p4 = new Interval("p4");
        Interval aug4 = new Interval("aug4");
        Interval p5 = new Interval("p5");
        Interval min6 = new Interval("min6");
        Interval maj6 = new Interval("maj6");
        Interval min7 = new Interval("min7");
        Interval maj7 = new Interval("maj7");
        Interval p8 = new Interval("p8");


    }
    */
}
