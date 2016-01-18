package sk.onko.world;

import java.util.List;
import java.util.Set;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Mutator {
    BreedChanceCalculator breedChanceCalculator = new BreedChanceCalculator();

    //Chance in % for mutation to occur
    public static final int MUTATION_RATE = 10;

    //Takes a set of unmutated animals and outputs mutated animals
    public List<Animal> mutate(List<Animal> inputSet, Environment environment){

        for (Animal animal : inputSet){

            if ((Math.random()*100) <= MUTATION_RATE ){

                animal.setR((int)(animal.getR()+(Math.random()*8)-4));
                animal.setG((int)(animal.getG()+(Math.random()*8))-4);
                animal.setB((int)(animal.getB()+(Math.random()*8)-4));

                int newBreedChance = breedChanceCalculator.calculateBreedChance(animal,environment);

                animal.setBreedChance( newBreedChance );
                animal.setBreedChanceWithoutPlague( newBreedChance );
                //System.out.println("Mutation !, new RGB is : " + animal.getR() + " " + animal.getG()+ " "  + animal.getB() + " Breed chance: " + animal.getBreedChance());
                }
        }

        return inputSet;
    }
}
