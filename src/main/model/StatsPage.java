package model;

import java.util.HashMap;

public class StatsPage {
    private float correct;
    private float total;

    // stores all interval names and how many times wrong
    private HashMap<String, Integer> record;

    // EFFECTS: Constructor for StatsPage which sets correct, total to 0, and creates a hashmap of all intervals
    public StatsPage() {
        correct = 0;
        total = 0;
        record = new HashMap<String, Integer>();
        makeFreshRecord();
    }

    // MODIFIES: this
    // EFFECTS: adds all possible intervals to record with a value of 0
    private void makeFreshRecord() {
        record.put("min2", 0);
        record.put("maj2", 0);
        record.put("min3", 0);
        record.put("maj3", 0);
        record.put("p4", 0);
        record.put("aug4", 0);
        record.put("p5", 0);
        record.put("min6", 0);
        record.put("maj6", 0);
        record.put("min7", 0);
        record.put("maj7", 0);
        record.put("p8", 0);
    }

    // MODIFIES: this
    // EFFECTS: adds 1 to correct intervals and total number of intervals
    public void correctInterval() {
        correct++;
        total++;
    }

    // REQUIRES: string s is one of the possible intervals
    // MODIFIES: this
    // EFFECTS: adds 1 to the value associated with the interval
    public void incorrectInterval(String s) {
        int value = record.get(s);
        value++;
        record.put(s, value);
        total++;
    }

    // EFFECTS: displays the summary stats
    public int displayStats() {
        if (total == 0) {
            System.out.println("No summary stats to display yet");
        } else {
            System.out.println("Accuracy: " + (correct / total) * 100 + "%");
        }
        return 0;
    }

    // EFFECTS: given an interval name, return the number of times wrong
    public int getFromRecord(String s) {
        return record.get(s);
    }

    // EFFECTS: gets the number of correct
    public float getCorrect() {
        return correct;
    }

    // EFFECTS: gets the total
    public float getTotal() {
        return total;
    }
}
