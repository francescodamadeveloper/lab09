package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame("My second graphical interface");
    private final Controller controller = new Controller();

    /**
     * Constructs a SimpleGUIWithFileChooser.
     */
    public SimpleGUIWithFileChooser() {
        final JPanel myPanel = new JPanel();
        final JTextArea myArea = new JTextArea();
        final JButton myButton = new JButton("Save");
        final JPanel browsePanel = new JPanel();
        final JTextField browseTextField = new JTextField(this.controller.getPath());
        final JButton browseButton = new JButton("BROWSE...");
        browseTextField.setEditable(false);
        myPanel.setLayout(new BorderLayout());
        browsePanel.setLayout(new BorderLayout());
        myPanel.add(myArea, BorderLayout.CENTER);
        myPanel.add(myButton, BorderLayout.SOUTH);
        browsePanel.add(browseTextField, BorderLayout.CENTER);
        browsePanel.add(browseButton, BorderLayout.LINE_END);
        myPanel.add(browsePanel, BorderLayout.NORTH);
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

        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final JFileChooser chooser = new JFileChooser();
                final int result = chooser.showSaveDialog(browseButton);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(chooser.getSelectedFile());
                    browseTextField.setText(controller.getPath());
                    frame.validate();
                } else if (result != JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
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
        final SimpleGUIWithFileChooser simple = new SimpleGUIWithFileChooser();
        simple.display();
    }

}
