package model;

public class Interval {
    private String interval;
    private int distance;

    // REQUIRES: interval is one of min2, maj2, min3, maj3, p4, aug4, dim5, p5,
    //           min 6, maj 6, min 7, maj 7, p8
    // EFFECTS: Constructor that creates an Interval with name and distance
    public Interval(String interval) {
        this.interval = interval;
        distance = getDistance(interval);
    }

    // EFFECTS: returns the distance given the interval name
    @SuppressWarnings({"checkstyle:MethodLength", "checkstyle:SuppressWarnings"})
    private int getDistance(String interval) {
        if (interval == "min2") {
            return 1;
        } else if (interval == "maj2") {
            return 2;
        } else if (interval == "min3") {
            return 3;
        } else if (interval == "maj3") {
            return 4;
        } else if (interval == "p4") {
            return 5;
        } else if (interval == "aug4" || interval == "dim5") {
            return 6;
        } else if (interval == "p5") {
            return 7;
        } else if (interval == "min6") {
            return 8;
        } else if (interval == "maj6") {
            return 9;
        } else if (interval == "min7") {
            return 10;
        } else if (interval == "maj7") {
            return 11;
        } else {
            return 12;
        }
    }

    // EFFECTS: returns interval name
    public String getIntervalName() {
        return interval;
    }

    // EFFECTS: returns interval distance
    public int getIntervalDistance() {
        return distance;
    }


}
