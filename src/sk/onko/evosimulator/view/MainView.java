package sk.onko.evosimulator.view;

import sk.onko.evosimulator.gui.GraphMark;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.util.*;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainView {


    //NOT YET USED


    java.util.List<Color> colorList = new ArrayList<Color>();
    java.util.List<Color> allAverageColors = new ArrayList<Color>();
    java.util.List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    JFrame f = new JFrame();
    JFrame f2 = new JFrame();
    JFrame f3 = new JFrame();
    JFrame f4 = new JFrame();

    JPanel p = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();
    JPanel p4 = new JPanel();

    JLabel generationNumberLabel = new JLabel();
    JLabel plagueLabel = new JLabel();
    JLabel populationLabel = new JLabel();


    JButton animalzCurrent = new JButton();
    JButton animalzGenMinus30 = new JButton();
    JButton animalzGenMinus60 = new JButton();

    public MainView(){
        createView();
    }

    private void createView() {
        f.setLocation(200, 200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setResizable(false);
        f.setTitle("Evolution simulation");

        p.setSize(500, 500);
        p.setLayout(null);
        p.setBackground(Color.BLUE);
        f.add(p);

        animalzCurrent.setBounds(250, 150, 200, 200);
        animalzCurrent.setText("Average color of animals");
        p.add(animalzCurrent);
        animalzCurrent.setVisible(true);

        animalzGenMinus30.setBounds(140, 150, 100, 100);
        animalzGenMinus30.setText("G-30");
        p.add(animalzGenMinus30);
        animalzGenMinus30.setVisible(true);

        animalzGenMinus60.setBounds(50, 150, 80, 80);
        animalzGenMinus60.setText("G-60");
        p.add(animalzGenMinus60);
        animalzGenMinus60.setVisible(true);

        generationNumberLabel.setText("Generation");
        generationNumberLabel.setBounds(300, 400, 200, 30);
        p.add(generationNumberLabel);


        plagueLabel.setText("Environment is friendly.");
        plagueLabel.setBounds(50, 50, 250, 30);
        p.add(plagueLabel);
        plagueLabel.setVisible(true);

        populationLabel.setText("Population :");
        populationLabel.setBounds(300, 430, 250, 30);
        p.add(populationLabel);
        populationLabel.setVisible(true);

        p.setVisible(true);
        f.setVisible(true);

        f2.setLocation(200, 100);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f2.setSize(1500, 100);
        f2.setResizable(false);
        f2.setTitle("Color view of every animal");

        p2.setSize(1500, 100);
        p2.setLayout(null);
        f2.add(p2);

        p2.setBackground(new Color(0, 0, 0));
        p2.setVisible(true);
        f2.setVisible(true);

        f3.setLocation(200, 100);
        f3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f3.setSize(1500, 100);
        f3.setResizable(false);
        f3.setTitle("Color evolution trend ");

        p3.setSize(1500, 100);
        p3.setLayout(null);
        f3.add(p3);

        p3.setBackground(new Color(0, 0, 0));
        p3.setVisible(true);
        f3.setVisible(true);

        f4.setLocation(200, 100);
        f4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f4.setSize(1500, 600);
        f4.setResizable(false);
        f4.setTitle("Color evolution trend ");

        p4.setSize(1500, 600);
        p4.setLayout(null);
        f4.add(p4);

        for (int i=0;i<50;i++){
            graphMarks.add(new GraphMark());

            graphMarks.get(i).setBounds(i*25,(270- graphMarks.get(i).getY()),15,15);
            p4.add(graphMarks.get(i));
        }

        p4.setBackground(new Color(255,255,255));
        p4.setVisible(true);
        f4.setVisible(true);

    }
}
