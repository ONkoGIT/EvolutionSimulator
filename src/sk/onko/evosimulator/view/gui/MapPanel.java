package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.Coordinates;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.WorldRegion;

import javax.swing.*;
import java.awt.*;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ondrej on 23.1.2016.
 */
public class MapPanel extends JPanel implements UpdateableView {

    private Map<Coordinates, RegionPanel> worldRegionPanelMap;
    private int mapWidth;
    private int mapHeight;
    private int mapTileWidth = 250;
    private int mapTileHeight = 250;

    //TODO Image backgrounds
    //private ImageIcon desertImage = new ImageIcon("src/Images/Desert.jpg");


    public MapPanel(MainModel model) {

        setSize(1200, 1200);
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        mapWidth = model.getMapWidth();
        mapHeight = model.getMapHeight();

        worldRegionPanelMap = new Hashtable<>();

        Color regionColor;
        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {

                // System.out.println("RegionPanel created at " + x + "|" + y);

                RegionPanel worldRegionPanel = new RegionPanel();

                regionColor = model.getWorldRegionMap().get(new Coordinates(x, y)).getColor();
                System.out.println("Color " + regionColor);
                worldRegionPanel.setBackground(regionColor);
                worldRegionPanel.getRegionInfoPanel().getRegionTypeLabel().setText(model.getWorldRegionMap().get(new Coordinates(x, y)).getEnvironmentType().toString());
                worldRegionPanel.getRegionInfoPanel().getRegionInfoLabel().setText("Temperature: " + model.getWorldRegionMap().get(new Coordinates(x, y)).getTemperature() + " °C");

                worldRegionPanel.setBounds(x * mapTileWidth, y * mapTileHeight, mapTileWidth, mapTileHeight);
                this.add(worldRegionPanel);

                worldRegionPanelMap.put(new Coordinates(x, y), worldRegionPanel);
            }
        }
        setVisible(true);
    }

    @Override
    public void updateView(MainModel model) {

        mapWidth = model.getMapWidth();
        mapHeight = model.getMapHeight();

        Color regionColor;
        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {

                RegionPanel regionPanel = worldRegionPanelMap.get(new Coordinates(x, y));

                //TUTO TODO
                //regionPanel.getSpeciesPanels()[0]

                WorldRegion currentRegion = model.getWorldRegionMap().get(new Coordinates(x, y));

                int inhabitantNumber = currentRegion.getInhabitantNumber();

                int plantNumber = currentRegion.getPlantNumber();

                AnimalSpecies species = currentRegion.getAnimalSpeciesList().get(0);

                //   System.out.println("Getting panel from coords X:" + x + " Y:" + y);
                //  regionPanel.getPopulationNameLabel().setText("Species : " + species.getSpeciesName());
                //   regionPanel.getTotalPopulationNumberLabel().setText("Population: " + inhabitantNumber);
                //    regionPanel.getFurLevelLabel().setText("Fur level: " + species.getAverageFurLevel());
                //     regionPanel.getPopulationAvgColorLabel().setBackground(species.getAverageColor());
                //     regionPanel.getTotalPlantNumberLabel().setText("Plants: " + plantNumber);

                //NEW
                //int numberOfSpecies = currentRegion.getAnimalSpeciesList().size();

                for (int i = 0; i <= 2; i++) {

                    AnimalSpecies currentSpecies = currentRegion.getAnimalSpeciesList().get(i);

                    regionPanel.getSpeciesPanels()[i].getNameAndNumberLabel().setText(currentSpecies.getSpeciesName() + " " + currentSpecies.getAnimals().size());
                    regionPanel.getSpeciesPanels()[i].getStatsLabel().setText("Fur: " + currentSpecies.getAverageFurLevel() + " Clw: " + currentSpecies.getAverageClaws() + " Brd:" + currentSpecies.getAverageBreedChance());
                    regionPanel.getSpeciesPanels()[i].getAverageColorSquareLabel().setBackground(currentSpecies.getAverageColor());

                }
            }
        }
        repaint();
    }
}
