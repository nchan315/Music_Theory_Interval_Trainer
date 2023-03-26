package ui;

import model.IntervalList;
import model.StatsPage;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class IntervalTrainerGUI extends JFrame implements ActionListener {
    private static final String JSON_STORE = "./data/myFile.json";
    private StatsPage stats;
    private IntervalList intervals;
    private Scanner scanner;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private JFrame frame;
    private JPanel panel;
    private JButton addIntervals;
    private JButton removeIntervals;
    private JButton save;
    private JButton load;
    private JButton viewStats;
    private JButton identify;
    private JButton findNote;
    private JLabel mainLabel;

    // EFFECTS: creates an interval trainer with empty stats page and empty list of intervals
    public IntervalTrainerGUI() throws FileNotFoundException {
        stats = new StatsPage();
        intervals = new IntervalList();
        scanner = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);

        makeFrame();
        makeButtons();
        makeLabels();
        makePanel();
        addActions();
        new StartScreenGUI(frame, panel);
    }

    // MODIFIES: this
    // EFFECTS: makes the frame
    private void makeFrame() {
        frame = new JFrame();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Interval Trainer");
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: makes all the buttons
    private void makeButtons() {
        addIntervals = new JButton("Add Intervals");
        addIntervals.setBounds(20, 20, 150, 30);
        removeIntervals = new JButton("Remove Intervals");
        removeIntervals.setBounds(20, 60, 150, 30);
        save =  new JButton("Save");
        save.setBounds(20, 100, 150, 30);
        load =  new JButton("Load");
        load.setBounds(20, 140, 150, 30);

        viewStats = new JButton("View Stats");
        viewStats.setBounds(200, 20, 150, 30);
        identify = new JButton("Identify");
        identify.setBounds(200, 60, 150, 30);
        findNote =  new JButton("Find Note");
        findNote.setBounds(200, 100, 150, 30);
    }

    // MODIFIES: this
    // EFFECTS: makes all the labels
    private void makeLabels() {
        mainLabel = new JLabel("Message");
        mainLabel.setBounds(200, 180, 150, 30);
    }

    // MODIFIES: this
    // EFFECTS: make panel with components and add to frame
    private void makePanel() {
        panel = new JPanel();
        panel.setLayout(null);

        panel.add(addIntervals);
        panel.add(removeIntervals);
        panel.add(save);
        panel.add(load);
        panel.add(viewStats);
        panel.add(identify);
        panel.add(findNote);
        panel.add(mainLabel);

        frame.add(panel);
        frame.setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds an actionListener to each component
    private void addActions() {
        addIntervals.addActionListener(this);
        removeIntervals.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);

        viewStats.addActionListener(this);
        identify.addActionListener(this);
        findNote.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == save) {
            saveIntervalTrainer();
        } else if (source == load) {
            loadIntervalTrainer();
        } else if (source == viewStats) {
            mainLabel.setText(stats.displayStats());
        } else if (source == identify) {
            startIdentifyInterval();
        } else if (source == findNote) {
            startFindNote();
        }
    }

    // EFFECTS: starts the identification activity if list size > 0
    private void startIdentifyInterval() {
        if (intervals.getLength() >= 0) {
            new IdentifyIntervalGUI(intervals, stats, frame, panel);
        } else {
            mainLabel.setText("Empty intervals");
        }
    }

    // EFFECTS: starts the find note activity if list size > 0
    private void startFindNote() {
        if (intervals.getLength() >= 0) {
            new FindNoteGUI(intervals, stats, frame, panel);
        } else {
            mainLabel.setText("Empty intervals");
        }
    }

    // EFFECTS: saves the interval trainer's data
    private void saveIntervalTrainer() {
        try {
            jsonWriter.open();
            jsonWriter.write(intervals, stats);
            jsonWriter.close();
            mainLabel.setText("Progress saved to JSON");
        } catch (FileNotFoundException e) {
            mainLabel.setText("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads interval trainer from file
    private void loadIntervalTrainer() {
        try {
            stats = jsonReader.readStats();
            intervals = jsonReader.readIntervals();
            mainLabel.setText("Loaded progress from JSON");
        } catch (IOException e) {
            mainLabel.setText("Unable to read from file: " + JSON_STORE);
        }
    }


}
