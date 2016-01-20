package sk.onko.evosimulator.model;

import sk.onko.evosimulator.factories.EnvironmentFactory;
import sk.onko.evosimulator.factories.MainModelFactory;
import sk.onko.evosimulator.gui.GraphMark;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainModel {

    private Environment environment;

    //Creature list
    private List<Animal> animals;

    private int cyclesElapsed;

    public int getCyclesElapsed() {
        return cyclesElapsed;
    }

    public void setCyclesElapsed(int cyclesElapsed) {
        this.cyclesElapsed = cyclesElapsed;
    }

    int averageAnimalR;
    int averageAnimalG;
    int averageAnimalB;

    public int getAverageAnimalR() {
        return averageAnimalR;
    }

    public MainModel() {

    }

    public void setAverageAnimalR(int averageAnimalR) {
        this.averageAnimalR = averageAnimalR;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getAverageAnimalG() {
        return averageAnimalG;
    }

    public void setAverageAnimalG(int averageAnimalG) {
        this.averageAnimalG = averageAnimalG;
    }

    public int getAverageAnimalB() {
        return averageAnimalB;
    }

    public void setAverageAnimalB(int averageAnimalB) {
        this.averageAnimalB = averageAnimalB;
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

    public List<Color> getColorList() {
        return colorList;
    }

    public void setColorList(List<Color> colorList) {
        this.colorList = colorList;
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

    List<Color> colorList = new ArrayList<Color>();
    List<Color> allAverageColors = new ArrayList<Color>();
    List<GraphMark> graphMarks = new ArrayList<GraphMark>();

}
