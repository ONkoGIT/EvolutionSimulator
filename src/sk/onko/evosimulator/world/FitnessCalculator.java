package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.awt.*;

/**
 * Created by Ondrej on 14.2.2016.
 */
public class FitnessCalculator {

    public WorldRegion calculateFitness(WorldRegion worldRegion) {

        for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {
            for (Animal animal : animalSpecies.getAnimals()) {
                int fitness = 0;
                fitness += calculateColorBonus(animal, worldRegion.getColor());
                fitness += calculateTemperatureBonus(animal, worldRegion.getTemperature());
                animal.setBreedChance(fitness);
            }
        }
        return worldRegion;
    }

    /* temperature bonus TODO test, optimize, etc
    optimal line calculated by optimalTemperature= 50 + (-0.235 * fur)
    You know, y = a + bx */
    public int calculateTemperatureBonus(Animal animal, int regionTemperature){
        int optimalTemperatureForFur = (50 + ((int) (-0.235 * animal.getFurLevel())));
        int temperatureBonus = Math.abs(optimalTemperatureForFur - regionTemperature);
        //System.out.println("Animal fur level= " + animal.getFurLevel() + " regionTemperature= "  + regionTemperature + " Bonus= " + Math.abs(100 - temperatureBonus));
        return Math.abs(100 - temperatureBonus);
    }

    public int calculateColorBonus(Animal animal, Color regionColor){
        int deltaR = Math.abs(animal.getR() - regionColor.getRed());
        int deltaG = Math.abs(animal.getG() - regionColor.getGreen());
        int deltaB = Math.abs(animal.getB() - regionColor.getBlue());
        int colorBonus = 0;
        return colorBonus += (442 - Math.sqrt(Math.pow((Math.sqrt(Math.pow(deltaR, 2) + Math.pow(deltaG, 2))), 2) + Math.pow(deltaB, 2))) / 4.41;
    }

}
