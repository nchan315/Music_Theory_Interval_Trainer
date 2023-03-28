package ui;

import java.io.FileNotFoundException;

// runs the GUI version of the Interval Trainer
public class MainGUI {
    public static void main(String[] args) {
        try {
            new IntervalTrainerGUI();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
