package sk.onko.evosimulator.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class AnimalSpecies implements Comparable<AnimalSpecies> {

    private String speciesName;
    private String speciesCode;

    private List<Animal> animals;

    int averageAnimalR;
    int averageAnimalG;
    int averageAnimalB;
    int averageFurLevel;
    int averageClaws;

    List<Integer> averageBreedChances = new ArrayList<Integer>();

    int averageBreedChance = 0;

    List<Color> allAverageColors = new ArrayList<Color>();

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getAverageAnimalR() {
        return averageAnimalR;
    }

    public void setAverageAnimalR(int averageAnimalR) {
        this.averageAnimalR = averageAnimalR;
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

    public List<Color> getAllAverageColors() {
        return allAverageColors;
    }

    public void setAllAverageColors(List<Color> allAverageColors) {
        this.allAverageColors = allAverageColors;
    }

    public String getSpeciesName() {
        return speciesName;
    }

    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }

    public int getAverageFurLevel() {
        return averageFurLevel;
    }

    public void setAverageFurLevel(int averageFurLevel) {
        this.averageFurLevel = averageFurLevel;
    }

    public Color getAverageColor() {
        return new Color(averageAnimalR, averageAnimalG, averageAnimalB);

    }
    public int getAverageClaws() {
        return averageClaws;
    }

    public void setAverageClaws(int averageClaws) {
        this.averageClaws = averageClaws;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnimalSpecies that = (AnimalSpecies) o;

        return speciesCode.equals(that.speciesCode);
    }

    @Override
    public int hashCode() {
        return speciesCode.hashCode();
    }

    @Override
    public int compareTo(AnimalSpecies other) {
        if (this.getAnimals().size() > other.getAnimals().size()) {
            return 1;
        } else if (this.getAnimals().size() < other.getAnimals().size()) {
            return -1;
        }

        return 0;
    }
}
