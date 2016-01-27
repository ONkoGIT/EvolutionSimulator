package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Mutator {
    BreedChanceCalculator breedChanceCalculator = new BreedChanceCalculator();

    //Chance in % for mutation to occur
    public static final int MUTATION_RATE = 10;

    //Takes a set of unmutated animals and outputs mutated animals
    public List<Animal> mutate(List<Animal> inputSet, WorldRegion region){

        for (Animal animal : inputSet){

            if ((Math.random()*100) <= MUTATION_RATE ){

                animal.setR((int)(animal.getR()+(Math.random()*8)-4));
                animal.setG((int)(animal.getG()+(Math.random()*8))-4);
                animal.setB((int)(animal.getB()+(Math.random()*8)-4));
                animal.setFurLevel((int)(animal.getFurLevel()+(Math.random()*8)-4));

                int newBreedChance = breedChanceCalculator.calculateBreedChance(animal,region);

                animal.setBreedChance( newBreedChance );
                animal.setBreedChanceWithoutPlague( newBreedChance );
                //System.out.println("Mutation !, new RGB is : " + animal.getR() + " " + animal.getG()+ " "  + animal.getB() + " Breed chance: " + animal.getBreedChance());
                }
        }

        return inputSet;
    }
}
