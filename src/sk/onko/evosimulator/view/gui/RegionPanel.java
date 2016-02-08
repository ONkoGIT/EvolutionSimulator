package sk.onko.evosimulator.view.gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;

/**
 * Created by ondrej.janosik on 27/01/2016.
 */
public class RegionPanel extends JPanel {


    private RegionInfoPanel regionInfoPanel = new RegionInfoPanel();
    private SpeciesPanel[] speciesPanels = {new SpeciesPanel(), new SpeciesPanel()};
    private JLabel totalPopulationNumberLabel = new JLabel("Population:");
    JLabel populationNameLabel = new JLabel("Species:");
    JLabel furLevelLabel = new JLabel("Average fur level:");
    JLabel populationAvgColorTextLabel = new JLabel("Average color of species:");
    JLabel populationAvgColorLabel = new JLabel();
    JLabel totalPlantNumberLabel = new JLabel("Plants:");
    //  private List<JLabel> populationNameLabels = new ArrayList<>();
    //  private List<JLabel> populationAverageColorLabels = new ArrayList<>();


    public RegionPanel() {
        this.setLayout(null);
        this.setVisible(true);

        javax.swing.border.Border raisedBevel = BorderFactory.createRaisedBevelBorder();
        javax.swing.border.Border loweredbevel = BorderFactory.createLoweredBevelBorder();

        this.setBorder(BorderFactory.createCompoundBorder(raisedBevel, loweredbevel));


        int componentNumber = 0;

        regionInfoPanel.setSize(200, 50);
        this.add(regionInfoPanel);
        regionInfoPanel.setLocation(10, (componentNumber * regionInfoPanel.getHeight()) + 10 + (10 * componentNumber));


        componentNumber++;

        for (SpeciesPanel speciesPanel : speciesPanels) {

            //TODO
            //speciesPanel.setSize(this.getWidth() - 20, this.getHeight() / 4);


            speciesPanel.setSize(200, 50);
            speciesPanel.setLocation(10, (componentNumber * speciesPanel.getHeight()) + 10 + (10 * componentNumber));
            System.out.println("SpeciesPanel created at " + speciesPanel.getBounds());
            this.add(speciesPanel);
            componentNumber++;
        }
/*
        totalPopulationNumberLabel.setBounds(10, 10, 200, 50);
        this.add(totalPopulationNumberLabel);
        totalPopulationNumberLabel.setVisible(true);

        populationNameLabel.setBounds(10, 50, 200, 50);
        this.add(populationNameLabel);
        populationNameLabel.setVisible(true);

        furLevelLabel.setBounds(10, 70, 200, 50);
        this.add(furLevelLabel);
        furLevelLabel.setVisible(true);

        populationAvgColorTextLabel.setBounds(10, 90, 200, 50);
        this.add(populationAvgColorTextLabel);
        populationAvgColorTextLabel.setVisible(true);
        */

     //   populationAvgColorLabel.setBounds(10, 140, 50, 50);
     //   this.add(populationAvgColorLabel);
     //   populationAvgColorLabel.setOpaque(true);
     //   populationAvgColorLabel.setVisible(true);

        totalPlantNumberLabel.setBounds(10, 200, 200, 50);
        this.add(totalPlantNumberLabel);
        totalPlantNumberLabel.setVisible(true);
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

    public JLabel getTotalPlantNumberLabel() {
        return totalPlantNumberLabel;
    }

    public void setTotalPlantNumberLabel(JLabel totalPlantNumberLabel) {
        this.totalPlantNumberLabel = totalPlantNumberLabel;
    }

    public SpeciesPanel[] getSpeciesPanels() {
        return speciesPanels;
    }

    public void setSpeciesPanels(SpeciesPanel[] speciesPanels) {
        this.speciesPanels = speciesPanels;
    }

    public RegionInfoPanel getRegionInfoPanel() {
        return regionInfoPanel;
    }

    public void setRegionInfoPanel(RegionInfoPanel regionInfoPanel) {
        this.regionInfoPanel = regionInfoPanel;
    }
}
