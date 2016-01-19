package sk.onko.evosimulator.view;

import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainView {


    //NOT YET USED


   // java.util.List<Color> colorList = new ArrayList<Color>();
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
        f.setTitle("VIEW - Evolution simulation");

        p.setSize(500, 500);
        p.setLayout(null);
        p.setBackground(Color.BLUE);
        f.add(p);

        animalzCurrent.setBounds(250, 150, 200, 200);
        animalzCurrent.setText("VIEW - Average color of animals");
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

        populationLabel.setText("Population :" );
        populationLabel.setBounds(300, 430, 250, 30);
        p.add(populationLabel);
        populationLabel.setVisible(true);

        p.setVisible(true);
        f.setVisible(true);

        f2.setLocation(200, 100);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f2.setSize(1500, 100);
        f2.setResizable(false);
        f2.setTitle("VIEW - Color view of every animal");

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
        f3.setTitle("VIEW - Color evolution trend ");

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
        f4.setTitle("VIEW - Color evolution trend ");

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

    public void updateView(MainModel model){

        populationLabel.setText("Population : " + model.getAnimals().size());

        //TODO let breeder set plagueLevel in model
        //switch (model.getEnvironment().getPlagueLevel()) {
        switch (0) {

            case 1:
                plagueLabel.setText("<html><font color=red>Plague level 1 in the world </font></html>");
                break;
            case 2:
                plagueLabel.setText("<html><font color=red>Plague level 2 in the world </font></html>");
                break;
            case 3:
                plagueLabel.setText("<html><font color=red>Plague level 3 in the world </font></html>");
                break;
            default:
                plagueLabel.setText("Environment is friendly.");

        }

        int position = 0;
        p2.removeAll();

        //getting average colors of animals
        for (Animal animal : model.getAnimals()) {


            // JButton animalColorLabel = new JButton();
            JLabel animalColorLabel = new JLabel();
            animalColorLabel.setOpaque(true);

            int x_pos = ((1000 / model.getAnimals().size()) * position);
            animalColorLabel.setBounds(x_pos, 0, (1500 / model.getAnimals().size()), 100);

            int redColor = animal.getR();
            int greenColor = animal.getG();
            int blueColor = animal.getB();

            animalColorLabel.setBackground(new Color(redColor, greenColor, blueColor));

            p2.add(animalColorLabel);
            animalColorLabel.setVisible(true);
            position++;

        }

        p2.repaint();

        p3.removeAll();
        position = 0;


        System.out.println(" - - - Number of beings : " + model.getAnimals().size() + " - - -");

        for (Color color : allAverageColors) {


            JLabel colorHistoryLabel = new JLabel();
            colorHistoryLabel.setOpaque(true);

            int x_pos = ((1000 / allAverageColors.size()) * position);
            colorHistoryLabel.setBounds(x_pos, 0, (1500 / allAverageColors.size()), 100);

            colorHistoryLabel.setBackground(color);

            p3.add(colorHistoryLabel);
            colorHistoryLabel.setVisible(true);
            position++;

        }

        p3.repaint();

        int averageAnimalR = model.getAverageAnimalR();
        int averageAnimalG = model.getAverageAnimalG();
        int averageAnimalB = model.getAverageAnimalB();


        List<Color> colorList = model.getAllAverageColors();

        if (colorList.size() < 60) {
            animalzGenMinus30.setBackground(colorList.get(0));
            animalzGenMinus60.setBackground(colorList.get(0));
        }

        if (colorList.size() >= 60) {
            animalzGenMinus30.setBackground(colorList.get(30));
            animalzGenMinus60.setBackground(colorList.get(0));
                   }

        try {
            animalzCurrent.setBackground(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
        } catch (IllegalArgumentException e) {

            System.out.println("Error trying to set color to :" + averageAnimalR + " " + averageAnimalG + " " + averageAnimalB);
            System.out.println("Size of beings list is  :" + model.getAnimals().size());
            e.printStackTrace();

        }

        generationNumberLabel.setText("Generation " + model.getCyclesElapsed());
        //updateGraph(model);

    }


    private void updateGraph(MainModel model) {
        int positionOfGraphMarker = 0;

        for(GraphMark graphMark : graphMarks){
            graphMark.setBackground(allAverageColors.get((positionOfGraphMarker*(allAverageColors.size()/50))));
            graphMark.setYfromBottom(model.getAverageBreedChances().get((positionOfGraphMarker*(model.getAverageBreedChances().size()/50))));


            positionOfGraphMarker++;
        }
        p4.repaint();
        System.out.println("Graph updated");
    }
}
