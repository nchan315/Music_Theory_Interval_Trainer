package ui;

import model.IntervalList;
import model.StatsPage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI to add/remove intervals
public class AddRemoveGUI implements ActionListener {
    private JFrame frame;
    private JPanel oldPanel;
    private IntervalList intervals;
    private StatsPage stats;

    private JPanel newPanel;
    private JLabel addLabel;
    private JLabel removeLabel;
    private JLabel intervalsLabel;
    private JButton back;
    private JButton addButton;
    private JButton removeButton;
    private JTextField addField;
    private JTextField removeField;

    // EFFECTS: creates the Add/Remove GUI
    public AddRemoveGUI(JFrame frame, JPanel oldPanel, IntervalList intervals, StatsPage stats) {
        this.frame = frame;
        this.oldPanel = oldPanel;
        this.intervals = intervals;
        this.stats = stats;

        makeComponents();
        setUp();
        addActions();
    }

    // MODIFIES: this
    // EFFECTS: creates the components
    private void makeComponents() {
        newPanel = new JPanel();
        newPanel.setLayout(null);
        newPanel.setLocation(20, 20);
        back = new JButton("Back");
        back.setBounds(20, 20, 100, 30);
        addLabel = new JLabel("Add: ");
        addLabel.setBounds(20, 60, 100, 30);
        removeLabel = new JLabel("Remove: ");
        removeLabel.setBounds(20, 100, 100, 30);
        addButton = new JButton("Add all");
        addButton.setBounds(20, 140, 100, 30);
        removeButton = new JButton("Remove all");
        removeButton.setBounds(140, 140, 100, 30);
        intervalsLabel = new JLabel("asdf");
        intervalsLabel.setBounds(20, 180, 400, 30);
        addField = new JTextField();
        addField.setBounds(140, 60, 100, 30);
        removeField = new JTextField();
        removeField.setBounds(140, 100, 100, 30);
    }

    // MODIFIES: this
    // EFFECTS: puts components on panel on frame
    private void setUp() {
        frame.remove(oldPanel);

        newPanel.add(back);
        newPanel.add(addLabel);
        newPanel.add(removeLabel);
        newPanel.add(addField);
        newPanel.add(removeField);
        newPanel.add(addButton);
        newPanel.add(removeButton);
        newPanel.add(intervalsLabel);

        frame.add(newPanel);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds actionListener to components
    private void addActions() {
        back.addActionListener(this);
        addField.addActionListener(this);
        removeField.addActionListener(this);
        addButton.addActionListener(this);
        removeButton.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: deals with the buttons and text fields
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == back) {
            exitPage();
        } else if (source == addField) {
            addInterval(e.getActionCommand());
        } else if (source == removeField) {
            removeInterval(e.getActionCommand());
        } else if (source == addButton) {
            intervals.addAllIntervals();
        } else if (source == removeButton) {
            intervals.removeAllIntervals();
        }
        updateIntervals();
    }

    // MODIFIES: this
    // EFFECTS: adds an interval to intervals
    private void addInterval(String toAdd) {
        if (intervals.isValid(toAdd)) {
            intervals.addInterval(toAdd);
        }
    }

    // MODIFIES: this
    // EFFECTS: removes an interval from intervals
    private void removeInterval(String toRemove) {
        if (intervals.isValid(toRemove)) {
            intervals.removeInterval(toRemove);
        }
    }

    // EFFECTS: gets us out of here
    private void exitPage() {
        frame.getContentPane().remove(newPanel);
        frame.repaint();
        frame.add(oldPanel);
    }

    // EFFECTS: updates the list of intervals
    private void updateIntervals() {
        intervalsLabel.setText(intervals.allIntervalNames());
    }
}
