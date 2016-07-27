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

}
