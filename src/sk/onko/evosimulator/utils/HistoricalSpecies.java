package sk.onko.evosimulator.utils;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;

import java.awt.*;
import java.util.List;

/**
 * Created by Ondrej on 27.7.2016.
 */
public class HistoricalSpecies {

    private String speciesCode;
    private String speciesName;

    private Color averageColor;
    private int averageFurLevel;
    private int averageClaws;
    private int averageBreedChance;

    public HistoricalSpecies(AnimalSpecies animalSpecies){
        this.speciesCode = animalSpecies.getSpeciesCode();
        this.averageColor = new Color(animalSpecies.getAverageAnimalR(), animalSpecies.getAverageAnimalG(),animalSpecies.getAverageAnimalB());
        this.averageClaws = animalSpecies.getAverageClaws();
        this.averageFurLevel = animalSpecies.getAverageFurLevel();
        this.averageBreedChance = animalSpecies.getAverageBreedChance();
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public Color getAverageColor() {
        return averageColor;
    }

    public void setAverageColor(Color averageColor) {
        this.averageColor = averageColor;
    }

    public int getAverageFurLevel() {
        return averageFurLevel;
    }

    public void setAverageFurLevel(int averageFurLevel) {
        this.averageFurLevel = averageFurLevel;
    }

    public int getAverageClaws() {
        return averageClaws;
    }

    public void setAverageClaws(int averageClaws) {
        this.averageClaws = averageClaws;
    }

    public int getAverageBreedChance() {
        return averageBreedChance;
    }

    public void setAverageBreedChance(int averageBreedChance) {
        this.averageBreedChance = averageBreedChance;
    }
}
