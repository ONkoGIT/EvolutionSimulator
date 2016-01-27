package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.Coordinates;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.WorldRegion;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ondrej on 23.1.2016.
 */
public class MapPanel extends JPanel implements UpdateableView {

    private Map<Coordinates, RegionPanel> worldRegionPanelMap;
    private int mapWidth;
    private int mapHeight;
    private int mapTileWidth = 300;
    private int mapTileHeight = 300;


    public MapPanel(MainModel model) {

        setSize(1200, 1200);
        setLayout(null);
        setBackground(new Color(255, 255, 255));

        mapWidth = model.getMapWidth();
        mapHeight = model.getMapHeight();

        worldRegionPanelMap = new TreeMap<Coordinates, RegionPanel>();

        Color regionColor;
        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {

                RegionPanel worldRegionPanel = new RegionPanel();

                regionColor = model.getWorldRegionMap().get(new Coordinates(x, y)).getColor();
                System.out.println("Color " + regionColor);
                worldRegionPanel.setBackground(regionColor);

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

                WorldRegion currentRegion = model.getWorldRegionMap().get(new Coordinates(x, y));

                int inhabitantNumber = currentRegion.getInhabitantNumber();

                AnimalSpecies species = currentRegion.getAnimalSpeciesList().get(0);

                regionPanel.getTotalPopulationNumberLabel().setText("Population: " + inhabitantNumber);
                regionPanel.getFurLevelLabel().setText("Fur level: " + species.getAverageFurLevel());
                regionPanel.getPopulationAvgColorLabel().setBackground(species.getAverageColor());

            }

        }

        repaint();

    }
}
