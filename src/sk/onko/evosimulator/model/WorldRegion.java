package sk.onko.evosimulator.model;

import java.awt.*;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class WorldRegion {


    public enum EnvironmentType {
        ARCTIC(new Color(252, 252, 252)),
        DESERT(new Color(253, 234, 158)),
        FOREST(new Color(0, 154, 0)),
        PLAINS(new Color(204, 204, 0)),
        OCEAN(new Color(68, 193, 255));

        private Color color;

        EnvironmentType(Color color) {
            setColor(color);


        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    private EnvironmentType environmentType;

    private List<AnimalSpecies> animalSpeciesList;

    private List<PlantSpecies> plantSpeciesList;


    private int temperature;
    // private Color color;
    private int inhabitantNumber;
    private int plagueLevel;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

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

    public int getPopulationPortion;

    public int getPlantPortion;

    public List<AnimalSpecies> getAnimalSpeciesList() {
        return animalSpeciesList;
    }

    public void setAnimalSpeciesList(List<AnimalSpecies> animalSpeciesList) {
        this.animalSpeciesList = animalSpeciesList;
    }

    public Color getColor() {
        return this.environmentType.getColor();
    }

    /*
    public void setColor(Color regionColor) {
        this.regionColor = regionColor;
    }
    */

    public EnvironmentType getEnvironmentType() {
        return environmentType;
    }

    public void setEnvironmentType(EnvironmentType environmentType) {
        this.environmentType = environmentType;
    }

    public List<PlantSpecies> getPlantSpeciesList() {
        return plantSpeciesList;
    }

    public void setPlantSpeciesList(List<PlantSpecies> plantSpeciesList) {
        this.plantSpeciesList = plantSpeciesList;
    }

}
