package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.WorldRegion;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ondrej on 23.1.2016.
 */
public class MapPanel extends JPanel implements UpdateableView {

    private JPanel[][] worldRegionPanel;
    private int mapWidth = 2;
    private int mapHeight = 2;
    private int mapTileWidth = 300;
    private int mapTileHeight = 300;

    public MapPanel(MainModel model) {

        setSize(1200,1200);
        setLayout(null);
        setBackground(new Color(255, 255, 255));


        //TODO get height and width of map in other, not fixed way
        worldRegionPanel = new JPanel[mapWidth][mapHeight];

        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {
                worldRegionPanel[x][y]= new JPanel();

                Color regionColor = model.getWorldRegions()[x][y].getRegionColor();
                worldRegionPanel[x][y].setBackground(regionColor);
                worldRegionPanel[x][y].setLayout(null);
                worldRegionPanel[x][y].setBounds(x* mapTileWidth, y*mapTileHeight, mapTileWidth, mapTileHeight);
                this.add(worldRegionPanel[x][y]);
                worldRegionPanel[x][y].setVisible(true);

            }

        }

      setVisible(true);

    }

    @Override
    public void updateView(MainModel model) {

        repaint();

    }
}
