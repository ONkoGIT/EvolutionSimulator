package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.WorldRegion;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class BreedChanceCalculator {


    public int calculateBreedChance(Animal animal, WorldRegion region) {

        int newBreedChance = -30;

        //Get Color Bonus
        //TODO other algorithm
        newBreedChance += getEnvironmentBonus(animal, region);

        //TODO eating of plants

        return newBreedChance;

    }

    private int getEnvironmentBonus(Animal animal, WorldRegion region) {
        int environmentBonus = 0;
        environmentBonus += (765 - (Math.abs(animal.getR() - region.getColor().getRed())) - (Math.abs(animal.getG() - region.getColor().getGreen())) - (Math.abs(animal.getB() - region.getColor().getBlue()))) / 7;

        //temperature bonus TODO test, optimize, etc
        //optimal line calculated by optimalTemperature= 50 + (-0.235 * fur)
        //You know, y = a + bx

        int optimalTemperatureForFur = (50 + ((int)(-0.235*animal.getFurLevel())));
        int temperatureBonus = Math.abs(optimalTemperatureForFur-region.getTemperature());
        temperatureBonus = Math.abs(100 - temperatureBonus) ;
        environmentBonus+=temperatureBonus;

        return environmentBonus;
    }
}
