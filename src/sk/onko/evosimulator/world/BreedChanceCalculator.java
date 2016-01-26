package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.Environment;
import sk.onko.evosimulator.model.WorldRegion;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class BreedChanceCalculator {

    //TODO, remove single-region code
    public int calculateBreedChance (Animal animal, Environment environment){

        int newBreedChance = 50;

        //Get Color Bonus
        //TODO other algorithm
        newBreedChance+= (765 - (Math.abs(animal.getR()-environment.getR())) - (Math.abs(animal.getG()-environment.getG())) - (Math.abs(animal.getB()-environment.getB())))/7;

        //TODO eating of plants

       return newBreedChance;

    }

    public int calculateBreedChance (Animal animal, WorldRegion region){

        int newBreedChance = 50;

        //Get Color Bonus
        //TODO other algorithm
        newBreedChance+= (765 - (Math.abs(animal.getR()-region.getRegionColor().getRed())) - (Math.abs(animal.getG()-region.getRegionColor().getGreen())) - (Math.abs(animal.getB()-region.getRegionColor().getBlue())))/7;

        //TODO eating of plants

        return newBreedChance;

    }
}
