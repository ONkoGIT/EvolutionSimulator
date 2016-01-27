package sk.onko.evosimulator.model;

import sk.onko.evosimulator.gui.GraphMark;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainModel {

    private int cyclesElapsed;

    private int mapWidth;
    private int mapHeight;

    private Map<Coordinates,WorldRegion> worldRegionMap;

    public int getCyclesElapsed() {
        return cyclesElapsed;
    }

    public void setCyclesElapsed(int cyclesElapsed) {
        this.cyclesElapsed = cyclesElapsed;
    }

    public MainModel() {

    }

    public List<Integer> getAverageBreedChances() {
        return averageBreedChances;
    }

    public void setAverageBreedChances(List<Integer> averageBreedChances) {
        this.averageBreedChances = averageBreedChances;
    }

    public int getAverageBreedChance() {
        return averageBreedChance;
    }

    public void setAverageBreedChance(int averageBreedChance) {
        this.averageBreedChance = averageBreedChance;
    }

    public List<Color> getAllAverageColors() {
        return allAverageColors;
    }

    public void setAllAverageColors(List<Color> allAverageColors) {
        this.allAverageColors = allAverageColors;
    }

    public List<GraphMark> getGraphMarks() {
        return graphMarks;
    }

    public void setGraphMarks(List<GraphMark> graphMarks) {
        this.graphMarks = graphMarks;
    }

    List<Integer> averageBreedChances = new ArrayList<Integer>();

    int averageBreedChance = 0;

    List<Color> allAverageColors = new ArrayList<Color>();
    List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    public Map<Coordinates, WorldRegion> getWorldRegionMap() {
        return worldRegionMap;
    }

    public void setWorldRegionMap(Map<Coordinates, WorldRegion> worldRegionMap) {
        this.worldRegionMap = worldRegionMap;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public void setMapWidth(int mapWidth) {
        this.mapWidth = mapWidth;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public void setMapHeight(int mapHeight) {
        this.mapHeight = mapHeight;
    }
}