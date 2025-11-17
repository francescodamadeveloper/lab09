package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My first graphical interface");
    private Controller controller;

    /**
     * Constructs a SimpleGui.
     */
    public SimpleGUI() {
        final JPanel myPanel = new JPanel();
        final JTextArea myArea = new JTextArea();
        final JButton myButton = new JButton("Save");
        myPanel.setLayout(new BorderLayout());
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.SOUTH);
        frame.setContentPane(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*
         * Handlers
         */
        myButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                controller.saveString(myArea.getText());
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
     * Sets the controller of this GUI.
     * 
     * @param controller to be set
     */
    private void setController(final Controller controller) {
        this.controller = controller;
    }

    /**
     * Tests the GUI.
     * 
     * @param args //
     */
    public static void main(final String[] args) {
        final SimpleGUI simple = new SimpleGUI();
        simple.setController(new Controller());
        simple.display();
    }
}
