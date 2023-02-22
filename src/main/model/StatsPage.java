package model;

import java.util.HashMap;

public class StatsPage {
    private float correct;
    private float total;

    // stores all interval names and how many times wrong
    private HashMap<String, Integer> record;

    // EFFECTS: Constructor for StatsPage which sets correct, total to 0, and creates a hashmap of all intervals
    public StatsPage() {
        correct = 1;
        total = 3;
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

    // REQUIRES: string s is one of the possible intervals
    // MODIFIES: this
    // EFFECTS: adds 1 to the value associated with the interval
    public void newMistake(String s) {
        int value = record.get(s);
        value++;
        record.put(s, value);
    }

    // EFFECTS: displays the summary stats
    public void displayStats() {
        //System.out.println("Accuracy: " + (correct / total) * 100 + "%");
        System.out.println("No summary stats to display yet");
    }
}
