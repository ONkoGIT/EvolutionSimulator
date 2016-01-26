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
    private int inhabitantNumber;
    private int plagueLevel;

    public int getPlagueLevel() {
        return plagueLevel;
    }

    public void setPlagueLevel(int plagueLevel) {
        this.plagueLevel = plagueLevel;
    }

    public int getInhabitantNumber() {
        return inhabitantNumber;
    }

    public void setInhabitantNumber(int inhabitantNumber) {
        this.inhabitantNumber = inhabitantNumber;
    }

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
