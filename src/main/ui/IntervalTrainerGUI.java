package ui;

import model.IntervalList;
import model.StatsPage;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class IntervalTrainerGUI implements ActionListener {
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
    private JButton quit;
    private JButton viewStats;
    private JButton identify;
    private JButton findNote;
    private JButton listen;
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




        //runIntervalTrainer();
    }

    // MODIFIES: this
    // EFFECTS: makes the frame
    private void makeFrame() {
        frame = new JFrame();
        frame.setSize(500, 300);
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
        quit = new JButton("Quit");
        quit.setBounds(20, 180, 150, 30);

        viewStats = new JButton("View Stats");
        viewStats.setBounds(200, 20, 150, 30);
        identify = new JButton("Identify");
        identify.setBounds(200, 60, 150, 30);
        findNote =  new JButton("Find Note");
        findNote.setBounds(200, 100, 150, 30);
        listen = new JButton("Listen");
        listen.setBounds(200, 140, 150, 30);
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
        panel.add(quit);
        panel.add(viewStats);
        panel.add(identify);
        panel.add(findNote);
        panel.add(listen);
        panel.add(mainLabel);

        frame.add(panel);
    }

    // MODIFIES: this
    // EFFECTS: adds an actionListener to each component
    private void addActions() {
        addIntervals.addActionListener(this);
        removeIntervals.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        quit.addActionListener(this);

        viewStats.addActionListener(this);
        identify.addActionListener(this);
        findNote.addActionListener(this);
        listen.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == identify) {
            // do something
        }
    }
}
