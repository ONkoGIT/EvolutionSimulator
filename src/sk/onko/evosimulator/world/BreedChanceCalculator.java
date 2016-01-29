package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.WorldRegion;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class BreedChanceCalculator {


    public int calculateBreedChance(Animal animal, WorldRegion region) {

        int newBreedChance = -30;

        newBreedChance += getEnvironmentBonus(animal, region);

        //TODO eating of plants
        if (!region.getPlantSpeciesList().isEmpty() && !region.getPlantSpeciesList().get(0).getPlants().isEmpty()) {
            region.getPlantSpeciesList().get(0).getPlants().remove(0);
        } else {
            newBreedChance = 5;
            System.out.println("Not enough plants in the region");
        }

        System.out.println("Breedchance " +  newBreedChance);
        return newBreedChance;

    }

    private int getEnvironmentBonus(Animal animal, WorldRegion region) {
        int environmentBonus = 0;

        //color bonus
        //int deltaR = Math.abs(animal.getR() - region.getColor().getRed());
       // int deltaG = Math.abs(animal.getG() - region.getColor().getGreen());
       // int deltaB = Math.abs(animal.getB() - region.getColor().getBlue());


      //  environmentBonus += (442 - Math.sqrt(Math.pow((Math.sqrt(Math.pow(deltaR, 2) + Math.pow(deltaG, 2))), 2) + Math.pow(deltaB, 2))) / 4.41;
       // System.out.println("Environment bonus = " + (442 - Math.sqrt(Math.pow((Math.sqrt(Math.pow(255, 2) + Math.pow(255, 2))), 2) + Math.pow(255, 2))) / 4.41);
         environmentBonus += (765 - (Math.abs(animal.getR() - region.getColor().getRed())) - (Math.abs(animal.getG() - region.getColor().getGreen())) - (Math.abs(animal.getB() - region.getColor().getBlue()))) / 7;

        //temperature bonus TODO test, optimize, etc
        //optimal line calculated by optimalTemperature= 50 + (-0.235 * fur)
        //You know, y = a + bx

        int optimalTemperatureForFur = (50 + ((int) (-0.235 * animal.getFurLevel())));
        int temperatureBonus = Math.abs(optimalTemperatureForFur - region.getTemperature());
        temperatureBonus = Math.abs(100 - temperatureBonus);

        environmentBonus += temperatureBonus;

        return environmentBonus;
    }
}
