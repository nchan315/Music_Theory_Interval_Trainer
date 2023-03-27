package ui;

import model.IntervalList;
import model.Keyboard;
import model.StatsPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Scanner;

// Activity where student names the next note given note and interval
public class FindNoteGUI implements ActionListener {
    Random random = new Random();
    Keyboard kb = new Keyboard();

    private IntervalList intervals;
    private StatsPage stats;
    String currentInterval;
    String currentNote;

    private JFrame frame;
    private JPanel oldPanel;
    private JPanel newPanel;
    private JButton back;
    private JLabel label;
    private JLabel feedback;
    private JTextField textField;

    // EFFECTS: creates and runs find note activity with given list of intervals
    public FindNoteGUI(IntervalList intervals, StatsPage stats,
                       JFrame frame, JPanel oldPanel) {
        this.intervals = intervals;

        this.stats = stats;
        this.frame = frame;
        this.oldPanel = oldPanel;

        makeComponents();
        setUp();
    }

    // MODIFIES: this
    // EFFECTS: creates the components
    private void makeComponents() {
        newPanel = new JPanel();
        newPanel.setLayout(null);
        newPanel.setLocation(400, 20);

        back = new JButton("Back");
        back.setBounds(20, 20, 150, 30);
        back.addActionListener(this);
        label = new JLabel();
        label.setBounds(20, 60, 150, 90);
        textField = new JTextField();
        textField.setBounds(20, 160, 150, 30);
        textField.addActionListener(this);
        feedback = new JLabel("");
        feedback.setBounds(20, 200, 150, 30);
    }

    // MODIFIES: this
    // EFFECTS: sets up the GUI (puts components on frame)
    private void setUp() {
        frame.remove(oldPanel);

        newPanel.add(back);
        newPanel.add(label);
        newPanel.add(textField);
        newPanel.add(feedback);
        frame.add(newPanel);
        frame.setVisible(true);

        int note1Number = random.nextInt(13); // picks a random note
        int index = random.nextInt(intervals.getLength()); // picks a random interval from the list
        String note1 = kb.getNoteName(note1Number);
        currentInterval = intervals.getAt(index);
        currentNote = kb.getNextNote(note1, currentInterval);

        label.setText(note1 + " " + currentInterval);
    }

    // MODIFIES: this
    // EFFECTS: controls all the component actions
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == textField) {
            String message = e.getActionCommand();
            System.out.println(message);
            sendFeedback(message);
            update();
        }
        if (source == back) {
            frame.getContentPane().remove(newPanel);
            frame.repaint();
            frame.add(oldPanel);
            System.out.println("asdf");
        }
    }

    // MODIFIES: stats
    // EFFECTS: gives feedback for each guess
    private void sendFeedback(String message) {
        if (currentNote.equals(message)) {
            stats.correctInterval();
            feedback.setText("Correct");
        } else {
            stats.incorrectInterval(currentInterval);
            feedback.setText("Incorrect: " + currentNote);
        }
    }

    // EFFECTS: prints the next interval
    private void update() {
        int note1Number = random.nextInt(13); // picks a random note
        int index = random.nextInt(intervals.getLength()); // picks a random interval from the list
        String note1 = kb.getNoteName(note1Number);
        currentInterval = intervals.getAt(index);
        currentNote = kb.getNextNote(note1, currentInterval);

        label.setText(note1 + " " + currentInterval);
    }
}
