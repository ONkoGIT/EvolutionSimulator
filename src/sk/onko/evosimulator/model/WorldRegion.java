package sk.onko.evosimulator.model;

import java.awt.*;
import java.util.*;
import java.util.List;

import sk.onko.evosimulator.model.Population;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class WorldRegion {

    private enum EnvironmentType {
        ARCTIC(new Color(252, 252, 252)),
        DESERT(new Color(253,234,158)),
        FOREST(new Color(0,154,0)),
        PLAINS(new Color(204,204,0)),
        OCEAN(new Color(0,0,204));

        private Color color;

        EnvironmentType(Color color){
            setColor(color);

        };

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    private EnvironmentType environmentType;

    private Color regionColor;

    private List<Population> populationList;

    public int getPopulationPortion;

    public int getPlantPortion;

    public List<Population> getPopulationList() {
        return populationList;
    }

    public void setPopulationList(List<Population> populationList) {
        this.populationList = populationList;
    }

    public Color getRegionColor() {
        return regionColor;
    }

    public void setRegionColor(Color regionColor) {
        this.regionColor = regionColor;
    }

    public EnvironmentType getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(EnvironmentType environmentType) {
        this.environmentType = environmentType;
    }
}
