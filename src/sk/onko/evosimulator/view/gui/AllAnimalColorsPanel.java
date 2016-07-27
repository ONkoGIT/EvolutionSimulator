package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class AllAnimalColorsPanel extends JPanel implements UpdateableView {

    public AllAnimalColorsPanel() {
        setSize(1500, 100);
        setLayout(null);
        setBackground(new Color(0, 0, 0));
        setVisible(true);
    }

    @Override
    public void updateView(MainModel model){/*
        int position = 0;
         removeAll();

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

            add(animalColorLabel);
            animalColorLabel.setVisible(true);
            position++;

        }
       repaint();
*/
    }



}
