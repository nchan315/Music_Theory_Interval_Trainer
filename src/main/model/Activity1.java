package model;

import java.util.Random;
import java.util.Scanner;

// Activity where given 2 notes, must identity the interval
public class Activity1 {

    private boolean gameOn;
    private IntervalList intList;

    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    public Activity1(IntervalList intList) {
        gameOn = true;
        this.intList = intList;
    }

    public void activity1() {
        int note1, note2;
        while (gameOn) {
            note1 = random.nextInt(26);
            note2 = random.nextInt(13) + note1;
            System.out.println(kb.getNoteName(note1) + " " + kb.getNoteName(note2));
            String guess = scanner.nextLine();
            String actual = intList.getCorrectInterval(note1, note2);
            if (guess.equals(actual)) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
                System.out.println("Correct answer: " + actual);
            }

        }
    }


}
