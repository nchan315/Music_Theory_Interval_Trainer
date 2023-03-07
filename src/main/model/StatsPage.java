package model;

import java.util.HashMap;

public class StatsPage {
    private float correct;
    private float total;

    // EFFECTS: Constructor for StatsPage which sets correct, total to 0, and creates a hashmap of all intervals
    public StatsPage() {
        correct = 0;
        total = 0;
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
        total++;
    }

    // EFFECTS: displays the summary stats
    public String displayStats() {
        String message;
        if (total == 0) {
            message = "No summary stats to display yet";
        } else {
            message = "Accuracy: " + (correct / total) * 100 + "%";
        }
        return message;
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
