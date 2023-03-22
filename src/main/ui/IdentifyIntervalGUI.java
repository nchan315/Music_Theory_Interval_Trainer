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
    private JPanel panel;
    private JButton back;
    private JLabel label;
    private JTextField;

    // EFFECTS: creates and runs the identification activity with given list of intervals
    public IdentifyIntervalGUI(IntervalList intervals, StatsPage stats, JFrame frame) {
        gameOn = true;
        this.intervals = intervals;
        this.stats = stats;
        this.frame = frame;

        setUp();







        //runActivity();
    }

    // MODIFIES: this
    // EFFECTS: sets up the GUI
    private void setUp() {

    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
