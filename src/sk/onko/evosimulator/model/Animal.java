package sk.onko.evosimulator.model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Animal {
    //RGB values of animals color (0-255)

    private String speciesCode = "";
    //Time that this animal spent classified as new species,
    //after it passes certain number, it is officially classified as new species

    private int generationsInNewSpecies;

    private int R;
    private int G;
    private int B;
    private int furLevel = 130;
    private int size = 130;
    private int claws = 130;

    private int breedChance = 50;
    private int breedChanceWithoutPlague = 50;

    private String causeOfDeath;
    private Map<Integer, String> evolutionHistory = new TreeMap<Integer, String>();


    //TODO change default herbivore
    private int carnivoreRatio = 40;
    private int herbivoreRatio = 60;

    public Animal() {
        this.setR(150);
        this.setG(150);
        this.setB(0);
    }

    //For copying animals , when breeding
    //TODO : always keep this up to date
    public Animal(Animal animal) {
        this.R = animal.getR();
        this.G = animal.getG();
        this.B = animal.getB();
        this.breedChance = animal.getBreedChance();
        this.breedChanceWithoutPlague = animal.getBreedChanceWithoutPlague();
        this.furLevel = animal.getFurLevel();
        this.herbivoreRatio = animal.getHerbivoreRatio();
        this.carnivoreRatio = animal.getCarnivoreRatio();
        this.size = animal.getSize();
        this.claws = animal.getClaws();
        this.speciesCode = animal.getSpeciesCode();
        this.generationsInNewSpecies = animal.getGenerationsInNewSpecies();
        this.causeOfDeath = animal.getCauseOfDeath();
        this.evolutionHistory = animal.getEvolutionHistory();
    }


    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = from0To255(r);
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = from0To255(g);
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = from0To255(b);
    }

    public int getBreedChance() {
        return breedChance;
    }

    public void setBreedChance(int breedChance) {
        this.breedChance = breedChance;
    }

    public int getBreedChanceWithoutPlague() {
        return breedChanceWithoutPlague;
    }

    public void setBreedChanceWithoutPlague(int breedChanceWithoutPlague) {
        this.breedChanceWithoutPlague = breedChanceWithoutPlague;
    }

    public int getFurLevel() {
        return furLevel;
    }

    public void setFurLevel(int furLevel) {
        this.furLevel = from0To255(furLevel);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = from0To255(size);
    }

    public int getCarnivoreRatio() {
        return carnivoreRatio;
    }

    public int getClaws() {
        return claws;
    }

    public void setClaws(int claws) {
        this.claws = from0To255(claws);
    }

    public void setCarnivoreRatio(int carnivoreRatio) {
        if (carnivoreRatio >= 100) {
            this.carnivoreRatio = 100;
        } else
            this.carnivoreRatio = carnivoreRatio;

        this.herbivoreRatio = 100 - carnivoreRatio;

    }

    public int getHerbivoreRatio() {
        return herbivoreRatio;
    }

    public void setHerbivoreRatio(int herbivoreRatio) {
        if (herbivoreRatio >= 100) {
            this.herbivoreRatio = 100;
        } else
            this.herbivoreRatio = herbivoreRatio;

        this.carnivoreRatio = 100 - herbivoreRatio;
    }

    public String getSpeciesCode() {
        return speciesCode;
    }

    public void setSpeciesCode(String speciesCode) {
        this.speciesCode = speciesCode;
    }

    public int getGenerationsInNewSpecies() {
        return generationsInNewSpecies;
    }

    public void setGenerationsInNewSpecies(int generationsInNewSpecies) {
        this.generationsInNewSpecies = generationsInNewSpecies;
    }

    //Validation for setters
    private int from0To255(int number) {
        if (number < 0) {
            return 0;
        } else if (number > 255) {
            return 255;
        } else
            return number;
    }

    public String getCauseOfDeath() {
        return causeOfDeath;
    }

    public void setCauseOfDeath(String causeOfDeath) {
        this.causeOfDeath = causeOfDeath;
    }

    public Map<Integer, String> getEvolutionHistory() {
        return evolutionHistory;
    }

    public void setEvolutionHistory(Map<Integer, String> evolutionHistory) {
        this.evolutionHistory = evolutionHistory;
    }
}
