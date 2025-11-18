package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My third graphical interface");
    private final SimpleController controller = new SimpleController();

    /**
     * Constructs a SimpleGui.
     */
    public SimpleGUI() {
        final JPanel mainPanel = new JPanel();
        final JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show History");
        final JTextField inputField = new JTextField("Write here...");
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputField, BorderLayout.NORTH);
        mainPanel.add(historyArea, BorderLayout.CENTER);
        final JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(printButton);
        buttonsPanel.add(historyButton);
        mainPanel.add(buttonsPanel, BorderLayout.SOUTH);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.setNextString(inputField.getText());
                controller.printString();
            }
        });

        historyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                for (final String s : controller.getHistory()) {
                    historyArea.append(s);
                    historyArea.append("");
                }
            }
        });
    }

    /**
     * Sets the frame dimensions, based on the used display.
     */
    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Tests the GUI.
     * 
     * @param args //
     */
    public static void main(final String[] args) {
        final SimpleGUI simple = new SimpleGUI();
        simple.display();
    }
}
