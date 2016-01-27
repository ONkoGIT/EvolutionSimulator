package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */

@Deprecated
public class MainPanel extends JPanel implements UpdateableView {

    JButton animalzCurrent = new JButton();
    JButton animalzGenMinus30 = new JButton();
    JButton animalzGenMinus60 = new JButton();

    JLabel generationNumberLabel = new JLabel();
    JLabel plagueLabel = new JLabel();
    JLabel populationLabel = new JLabel();

    public MainPanel() {
        setSize(500, 500);
        setLayout(null);
        setBackground(Color.BLUE);

        animalzCurrent.setBounds(250, 150, 200, 200);
        animalzCurrent.setText("VIEW - Average color of animals");
        this.add(animalzCurrent);
        animalzCurrent.setVisible(true);

        animalzGenMinus30.setBounds(140, 150, 100, 100);
        animalzGenMinus30.setText("G-30");
        add(animalzGenMinus30);
        animalzGenMinus30.setVisible(true);

        animalzGenMinus60.setBounds(50, 150, 80, 80);
        animalzGenMinus60.setText("G-60");
        add(animalzGenMinus60);
        animalzGenMinus60.setVisible(true);

        generationNumberLabel.setText("Generation");
        generationNumberLabel.setBounds(300, 400, 200, 30);
        add(generationNumberLabel);

        plagueLabel.setText("Environment is friendly.");
        plagueLabel.setBounds(50, 50, 250, 30);
        add(plagueLabel);
        plagueLabel.setVisible(true);

        populationLabel.setText("AnimalSpecies :");
        populationLabel.setBounds(300, 430, 250, 30);
        add(populationLabel);
        populationLabel.setVisible(true);
    }

    @Override
    public void updateView(MainModel model) {

    }
/*
    @Override
    public void updateView(MainModel model) {
        setBackground(model.getEnvironment().getColor());

        populationLabel.setText("AnimalSpecies : " + model.getAnimals().size());

        switch (model.getEnvironment().getPlagueLevel()) {

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

        List<Color> allAverageColors = model.getAllAverageColors();

        int averageAnimalR = model.getAverageAnimalR();
        int averageAnimalG = model.getAverageAnimalG();
        int averageAnimalB = model.getAverageAnimalB();

        int cyclesElapsed = model.getCyclesElapsed();

        if (allAverageColors.size() < 60) {
            animalzGenMinus30.setBackground(allAverageColors.get(0));
            animalzGenMinus60.setBackground(allAverageColors.get(0));
           // System.out.println(" Label gen-60 color changed to " + allAverageColors.get(0));
        }

        if (allAverageColors.size() > 60) {
            animalzGenMinus30.setBackground(allAverageColors.get(cyclesElapsed - 30));
            animalzGenMinus60.setBackground(allAverageColors.get(cyclesElapsed - 60));
           // System.out.println(" Label gen-60 color changed to " + allAverageColors.get(cyclesElapsed - 60));
        }

        try {
            animalzCurrent.setBackground(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
        } catch (IllegalArgumentException e) {

            System.out.println("Error trying to set color to :" + averageAnimalR + " " + averageAnimalG + " " + averageAnimalB);
            System.out.println("Size of beings list is  :" + model.getAnimals().size());
            e.printStackTrace();

        }

        generationNumberLabel.setText("Generation " + model.getCyclesElapsed());

    }*/

}
