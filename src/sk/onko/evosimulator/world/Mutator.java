package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;
import sk.onko.evosimulator.utils.EvoStatistics;
import sk.onko.evosimulator.utils.SimulationSettings;

import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Mutator {
   // BreedChanceCalculator breedChanceCalculator = new BreedChanceCalculator();

    public WorldRegion mutate(WorldRegion worldRegion) {
        for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {
            for (Animal animal : animalSpecies.getAnimals()) {

                if ((Math.random() * 100) <= SimulationSettings.MUTATION_RATE) {
                    EvoStatistics.numOfMutations++;
                    animal.setR((int) (animal.getR() + (Math.random() * 8) - 4));
                    animal.setG((int) (animal.getG() + (Math.random() * 8)) - 4);
                    animal.setB((int) (animal.getB() + (Math.random() * 8) - 4));
                    animal.setFurLevel((int) (animal.getFurLevel() + (Math.random() * 8) - 4));
                    animal.setClaws((int) (animal.getClaws() + (Math.random() * 8) - 4));
                    // int newBreedChance = breedChanceCalculator.calculateBreedChance(animal,region);
                    //animal.setBreedChance( newBreedChance );
                    // animal.setBreedChanceWithoutPlague( newBreedChance );
                    //System.out.println("Mutation !, new RGB is : " + animal.getR() + " " + animal.getG()+ " "  + animal.getB() + " Breed chance: " + animal.getBreedChance());
                }
            }
        }
        return worldRegion;
    }

    //Takes a set of unmutated animals and outputs mutated animals
    @Deprecated
    public List<Animal> mutate(List<Animal> inputSet, WorldRegion region) {

        for (Animal animal : inputSet) {

            if ((Math.random() * 100) <= SimulationSettings.MUTATION_RATE) {

                animal.setR((int) (animal.getR() + (Math.random() * 8) - 4));
                animal.setG((int) (animal.getG() + (Math.random() * 8)) - 4);
                animal.setB((int) (animal.getB() + (Math.random() * 8) - 4));
                animal.setFurLevel((int) (animal.getFurLevel() + (Math.random() * 8) - 4));
                animal.setClaws((int) (animal.getClaws() + (Math.random() * 8) - 4));

                // int newBreedChance = breedChanceCalculator.calculateBreedChance(animal,region);
                //animal.setBreedChance( newBreedChance );
                // animal.setBreedChanceWithoutPlague( newBreedChance );
                //System.out.println("Mutation !, new RGB is : " + animal.getR() + " " + animal.getG()+ " "  + animal.getB() + " Breed chance: " + animal.getBreedChance());
            }
        }

        return inputSet;
    }
}
