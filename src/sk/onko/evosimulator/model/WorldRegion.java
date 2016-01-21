package sk.onko.evosimulator.model;

import java.awt.*;
import java.util.*;
import java.util.List;

import sk.onko.evosimulator.model.Population;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class WorldRegion {

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
}
