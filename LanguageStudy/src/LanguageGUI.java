
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;

import java.awt.GridBagConstraints;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import java.awt.Insets;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.accessibility.AccessibleContext;

import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JRootPane;

import javax.swing.JTextField;

/**
 *
 * @author cderh
 */
public class LanguageGUI extends JFrame implements ActionListener {

    NewClass no = new NewClass();

    private JLabel languageLabel;
    private JLabel english;
    private JButton button;
    private JTextField textField;

    public String[] getTxt(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        List<String> englishTxt = new ArrayList<String>();
        while (scan.hasNextLine()) {
            englishTxt.add(scan.nextLine());
        }
        String[] englishArray = englishTxt.toArray(new String[0]);
        return englishArray;
    }

    public String[] getSpanishTxt(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        List<String> spanishTxt = new ArrayList<String>();
        while (scan.hasNextLine()) {
            spanishTxt.add(scan.nextLine());
        }
        String[] spanishArray = spanishTxt.toArray(new String[0]);
        return spanishArray;
    }

    // File file = new File("C:\\Users\\cderh\\OneDrive\\Desktop\\School\\english.txt");
    // File file2 = new File("C:\\Users\\cderh\\OneDrive\\Desktop\\School\\spanish.txt");
    // BufferedReader fileOne = new BufferedReader(new FileReader(file));
    // BufferedReader fileTwo = new BufferedReader(new FileReader(file2));
    String[] englishArray = getTxt("english.txt");

    String[] spanishArray = getSpanishTxt("spanish.txt");


    /*while ((line = fileOne.readLine()) != null) {
            System.out.println(st);
        }

        while ((st2 = fileTwo.readLine()) != null) {
            System.out.println(st2);
        }
     */
    // System.out.println(.readLine());
    public LanguageGUI() throws HeadlessException, NullPointerException, FileNotFoundException, IOException {
        super();

        // title of the JFrame
        setTitle("LanguageGUI");

        // Layout
        setLayout(new GridBagLayout());

        // GridBagConstraints creates a layout object to pass 
        GridBagConstraints layoutConstraints = new GridBagConstraints();

        layoutConstraints.insets = new Insets(10, 10, 10, 10);

        // create a new label
        languageLabel = new JLabel("Type the translation into the field below");

        // Random label
        Random randomW = new Random();
        Random randomL = new Random();
        int word = randomW.nextInt(33);
        int l = randomL.nextInt(3);
        String w = englishArray[word];
        String x = spanishArray[word];
        if (l == 0) {
            english = new JLabel(w);
        } else {
            english = new JLabel(x);
        }
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        add(english, layoutConstraints);

        // set label position
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 0;
        add(languageLabel, layoutConstraints); // add the label, and pass the layout in the label

        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 1;
        add(english, layoutConstraints);

        // instantiate JTextFields
        textField = new JTextField("");

        // textField
        layoutConstraints.gridx = 1;
        layoutConstraints.gridy = 1;
        add(textField, layoutConstraints);
        textField.setText("");
        textField.setPreferredSize(new Dimension(100, 20));
        textField.setMinimumSize(textField.getPreferredSize());
        textField.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String whatever = textField.getText();

                no.setUsersGuest(whatever);

            }
        });

        // create new button
        button = new JButton("Ok");

        // set button position
        layoutConstraints.gridx = 0;
        layoutConstraints.gridy = 2;
        add(button, layoutConstraints);
        button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String one = english.getText().toLowerCase();
                String two = no.getUsersGuest().toLowerCase();

                if (one.equals(two)) {
                    languageLabel.setText("Correct");
                } else {
                    if (l == 0) {
                        languageLabel.setText("Incorrect answer " + x);
                    } else {
                        languageLabel.setText("Incorrect answer " + w);
                    }
                }

            }

        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
