package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// GUI for the start screen
public class StartScreenGUI implements ActionListener {
    private JFrame frame;
    private JPanel oldPanel;
    private JPanel newPanel;
    private JLabel label;
    private JLabel imageLabel;
    private JButton start;

    // EFFECTS: creates the start screen
    public StartScreenGUI(JFrame frame, JPanel oldPanel) {
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
        newPanel.setLocation(20, 20);

        label = new JLabel("Interval Trainer", SwingConstants.CENTER);
        label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 18));
        label.setBounds(150, 40, 200, 30);

        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon("data/Resized_142109580_MUSIC_TONES_400.jpg"));
        // IMAGE FROM https://cliply.co/clip/music-notes/ and resized
        imageLabel.setBounds(200, 100, 100, 100);

        start = new JButton("Start");
        start.setBounds(200, 250, 100, 30);
        start.addActionListener(this);
    }

    // MODIFIES: this
    // EFFECTS: puts components on the frame
    private void setUp() {
        frame.remove(oldPanel);

        newPanel.add(label, new GridBagConstraints());
        newPanel.add(imageLabel);
        newPanel.add(start);

        frame.add(newPanel);
        frame.setVisible(true);
    }

    // EFFECTS: goes to menu screen when start button pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.getContentPane().remove(newPanel);
        frame.repaint();
        frame.add(oldPanel);
    }

}
