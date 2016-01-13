package sk.onko.world;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class BreedChanceCalculator {

    public int calculateBreedChance (Animal animal, Environment environment){

        int newBreedChance = 60;

        //Get Color Bonus
        newBreedChance+= (765 - (Math.abs(animal.getR()-environment.getR())) - (Math.abs(animal.getG()-environment.getG())) - (Math.abs(animal.getB()-environment.getB())))/7;


       return newBreedChance;

    }
}
