package ui;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        try {
            new IntervalTrainer();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

    }
}
