package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ondrej.janosik on 27/01/2016.
 */
public class RegionPanel extends JPanel {

    private JLabel totalPopulationNumberLabel = new JLabel("Population:");
    JLabel populationNameLabel = new JLabel("Species:");
    JLabel furLevelLabel = new JLabel("Average fur level:");
    JLabel populationAvgColorTextLabel = new JLabel("Average color of species:");
    JLabel populationAvgColorLabel = new JLabel();
  //  private List<JLabel> populationNameLabels = new ArrayList<>();
  //  private List<JLabel> populationAverageColorLabels = new ArrayList<>();


    public RegionPanel() {
        this.setLayout(null);
        this.setVisible(true);

        totalPopulationNumberLabel.setBounds(10, 10, 200, 50);
        this.add(totalPopulationNumberLabel);
        totalPopulationNumberLabel.setVisible(true);

        populationNameLabel.setBounds(10, 50, 200, 50);
        this.add(populationNameLabel);
        populationNameLabel.setVisible(true);

        furLevelLabel.setBounds(10, 70, 200, 50);
        this.add(    furLevelLabel);
        furLevelLabel.setVisible(true);

        populationAvgColorTextLabel.setBounds(10, 90, 200, 50);
        this.add( populationAvgColorTextLabel);
        populationAvgColorTextLabel.setVisible(true);

        populationAvgColorLabel.setBounds(10, 140, 50, 50);
        this.add(populationAvgColorLabel);
        populationAvgColorLabel.setOpaque(true);
        populationAvgColorLabel.setVisible(true);
    }


    public JLabel getTotalPopulationNumberLabel() {
        return totalPopulationNumberLabel;
    }

    public void setTotalPopulationNumberLabel(JLabel totalPopulationNumberLabel) {
        this.totalPopulationNumberLabel = totalPopulationNumberLabel;
    }

    public JLabel getPopulationNameLabel() {
        return populationNameLabel;
    }

    public void setPopulationNameLabel(JLabel populationNameLabel) {
        this.populationNameLabel = populationNameLabel;
    }

    public JLabel getPopulationAvgColorLabel() {
        return populationAvgColorLabel;
    }

    public void setPopulationAvgColorLabel(JLabel populationAvgColorLabel) {
        this.populationAvgColorLabel = populationAvgColorLabel;
    }

    public JLabel getFurLevelLabel() {
        return furLevelLabel;
    }

    public void setFurLevelLabel(JLabel furLevelLabel) {
        this.furLevelLabel = furLevelLabel;
    }
}
