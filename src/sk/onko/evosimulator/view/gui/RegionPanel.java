package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;

/**
 * Created by ondrej.janosik on 27/01/2016.
 */
public class RegionPanel extends JPanel {

    private JLabel totalPopulationNumberLabel = new JLabel("Population : ");

    public RegionPanel() {
        this.setLayout(null);
        this.setVisible(true);

        totalPopulationNumberLabel.setBounds(10, 10, 200, 50);
        this.add(totalPopulationNumberLabel);
        totalPopulationNumberLabel.setVisible(true);
    }


    public JLabel getTotalPopulationNumberLabel() {
        return totalPopulationNumberLabel;
    }

    public void setTotalPopulationNumberLabel(JLabel totalPopulationNumberLabel) {
        this.totalPopulationNumberLabel = totalPopulationNumberLabel;
    }
}
