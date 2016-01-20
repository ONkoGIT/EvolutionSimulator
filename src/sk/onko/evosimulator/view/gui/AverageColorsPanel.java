package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class AverageColorsPanel extends JPanel implements UpdateableView {

    public AverageColorsPanel() {

        setSize(1500, 100);
        setLayout(null);
        setBackground(new Color(0, 0, 0));
        setVisible(true);
    }

    @Override
    public void updateView(MainModel model) {
        removeAll();
        int position = 0;

        System.out.println(" - - - Number of beings : " + model.getAnimals().size() + " - - -");

        for (Color color : model.getAllAverageColors()) {

            int sizeOfAllAverageColors = model.getAllAverageColors().size();
            java.util.List<Color> allAverageColors = model.getAllAverageColors();

            JLabel colorHistoryLabel = new JLabel();
            colorHistoryLabel.setOpaque(true);

            int x_pos = ((1000 / sizeOfAllAverageColors) * position);
            colorHistoryLabel.setBounds(x_pos, 0, (1500 / sizeOfAllAverageColors), 100);

            colorHistoryLabel.setBackground(color);

            add(colorHistoryLabel);
            colorHistoryLabel.setVisible(true);
            position++;

        }

        repaint();

    }
}
