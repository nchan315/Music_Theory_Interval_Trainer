package ui;

import java.io.FileNotFoundException;

public class MainGUI {
    public static void main(String[] args) {
        try {
            new IntervalTrainerGUI();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}
