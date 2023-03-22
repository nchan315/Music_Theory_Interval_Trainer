package ui;

import model.IntervalList;
import model.Keyboard;
import model.StatsPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

// Activity where given 2 notes, must identity the interval
public class IdentifyIntervalGUI implements ActionListener {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private boolean gameOn;
    private IntervalList intervals;
    private StatsPage stats;

    private JFrame frame;
    private JPanel oldPanel;
    private JPanel newPanel;
    private JButton back;
    private JLabel label;
    private JTextField textField;

    // EFFECTS: creates and runs the identification activity with given list of intervals
    public IdentifyIntervalGUI(IntervalList intervals, StatsPage stats,
                               JFrame frame, JPanel oldPanel) {
        gameOn = true;

        //this.intervals = intervals;
        this.intervals = new IntervalList();
        this.intervals.addInterval("maj3");
        this.intervals.addInterval("p5");

        this.stats = stats;
        this.frame = frame;
        this.oldPanel = oldPanel;

        makeComponents();
        setUp();

        runActivity();
    }

    // MODIFIES: this
    // EFFECTS: creates the components
    private void makeComponents() {
        newPanel = new JPanel();
        newPanel.setLayout(null);

        back = new JButton("Back");
        back.setBounds(20, 20, 150, 30);
        back.addActionListener(this);
        label = new JLabel("asdf");
        label.setBounds(20, 150, 150, 30);
        textField = new JTextField();
        textField.setBounds(20, 200, 150, 30);
        textField.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: sets up the GUI (puts components on frame)
    private void setUp() {
        frame.remove(oldPanel);

        newPanel.add(back);
        newPanel.add(label);
        newPanel.add(textField);
        frame.add(newPanel);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: controls all the component actions
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    // REQUIRES: intervals.size() > 0
    // MODIFIES: stats page
    // EFFECTS: runs the identification activity and updates stats page
    private void runActivity() {
        int bound = intervals.getLength();
        System.out.println(bound);
        while (gameOn) {
            int note1Number = random.nextInt(13); // picks a random note
            int index = random.nextInt(bound); // picks a random interval from the list
            String note1 = kb.getNoteName(note1Number);
            String name = intervals.getAt(index);
            String note2 = kb.getNextNote(note1, name);

            label.setText(note1 + " " + note2);
//            String guess = scanner.nextLine(); // TODO:
//            if (guess.compareTo("q") == 0) {
//                gameOn = false;
//            } else if (guess.compareTo(name) == 0) {
//                System.out.println("Correct");
//                stats.correctInterval();
//            } else {
//                stats.incorrectInterval(name);
//                System.out.println("Incorrect");
//                System.out.println("Correct answer: " + name);
//            }
        }
    }
}



