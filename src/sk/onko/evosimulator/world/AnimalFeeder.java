package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;
import sk.onko.evosimulator.utils.EvoStatistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Ondrej on 14.2.2016.
 */
public class AnimalFeeder {

    private FightClub fightClub = new FightClub();
    private WorldRegion worldRegion;

    public WorldRegion feedAnimals(WorldRegion worldRegion) {
        this.worldRegion = worldRegion;
        int currentSpeciesNumber = 0;

        List<Animal> allAnimalsFromRegion = new ArrayList<Animal>();

        for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {
            for (Animal animal : animalSpecies.getAnimals()) {
                allAnimalsFromRegion.add(animal);
            }
            currentSpeciesNumber++;
        }

        Collections.shuffle(allAnimalsFromRegion);
        for (Animal animal : allAnimalsFromRegion){
            if ((Math.random() * 100) <= animal.getHerbivoreRatio()) {
                animalWantsToEatPlant(animal);
            } else {
                animalWantsToEatAnimal(animal);
            }
        }

        return worldRegion;
    }

    private void animalWantsToEatPlant(Animal animal){
        int newBreedChance = animal.getBreedChance();

        //Can it find a plant to eat ?
        if (!worldRegion.getPlantSpeciesList().isEmpty() && !worldRegion.getPlantSpeciesList().get(0).getPlants().isEmpty()) {
            worldRegion.getPlantSpeciesList().get(0).getPlants().remove(0);
            EvoStatistics.numOfPlantsEaten++;

            //Eats plant successfully = becomes more herbivorous
            animal.setHerbivoreRatio(animal.getHerbivoreRatio() + 1);
        } else {
            newBreedChance = newBreedChance / 2;
            // System.out.println("Not enough plants in the region");
            animal.setCarnivoreRatio(animal.getCarnivoreRatio() + 1);
        }

        animal.setBreedChance(newBreedChance);
    }

    private void animalWantsToEatAnimal(Animal animal){
        int newBreedChance = animal.getBreedChance();

        //TODO
        //Can it find any prey in the region ? From other species

        //Prevents cannibalism
        int preySpeciesNumber = (int) (Math.random() * worldRegion.getAnimalSpeciesList().size());
                    /*
                    while (preySpeciesNumber == currentSpeciesNumber) {
                        preySpeciesNumber = (int) Math.random() * worldRegion.getAnimalSpeciesList().size();
                        System.out.print("x");
                    }*/

        if (!worldRegion.getAnimalSpeciesList().isEmpty() && !worldRegion.getAnimalSpeciesList().get(preySpeciesNumber).getAnimals().isEmpty()) {
            //Can it hunt the prey successfully ?

            Animal prey = worldRegion.getAnimalSpeciesList().get(preySpeciesNumber).getAnimals().get(0);
            if (fightClub.hunt(animal, prey)) {
                // region.getAnimalSpeciesList().get(1).getAnimals().remove(0);

                //Instead of removing from list, set the prey's breedChance to -1
                worldRegion.getAnimalSpeciesList().get(preySpeciesNumber).getAnimals().get(0).setBreedChance(-1);
                EvoStatistics.numOfAnimalsEaten++;

                //Eats animal successfully = becomes more carnivorous
                animal.setCarnivoreRatio(animal.getCarnivoreRatio() + 1);
                //System.out.println("Hunt successful");
            } else {
                newBreedChance = newBreedChance / 2;
                //  System.out.println("Hunt not successful");
                animal.setHerbivoreRatio(animal.getHerbivoreRatio() + 1);
            }

        } else {
            newBreedChance = newBreedChance / 2;
            animal.setCarnivoreRatio(animal.getCarnivoreRatio() - 1);
            //    System.out.println("No prey found");
        }

        animal.setBreedChance(newBreedChance);
    }

}
