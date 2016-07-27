package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Breeder {

    public int plagueLevel;

    public WorldRegion breed(WorldRegion region) {
        plagueLevel = region.getPlagueLevel();

        for (AnimalSpecies animalSpecies : region.getAnimalSpeciesList()) {
            List<Animal> newAnimals = new ArrayList<Animal>();

            for (Animal animal : animalSpecies.getAnimals()) {
                updateAnimalBreedChanceWithPlague(animal, plagueLevel);

                if (animal.getBreedChance() >= 100) {

                    int numberOfBirthedAnimals = animal.getBreedChance() / 100;

                    for (int i = 0; i < numberOfBirthedAnimals; i++) {
                        //Creates a copy of birthing animal
                        newAnimals.add(new Animal(animal));
                    }

                    if (Math.random() * 100 <= animal.getBreedChance() % 100) {
                        newAnimals.add(new Animal(animal));
                    }

                } else if (animal.getBreedChance() >= 0 && Math.random() * 100 <= animal.getBreedChance() % 100) {
                    newAnimals.add(new Animal(animal));
                }
            }
            animalSpecies.setAnimals(newAnimals);
        }

        return region;

    }

    private void updateAnimalBreedChanceWithPlague(Animal animal, int plagueLevel){
        switch (plagueLevel) {
            case (1):
                animal.setBreedChance(animal.getBreedChance() - 10);
                break;
            case (2):
                animal.setBreedChance(animal.getBreedChance() - 30);
                break;
            case (3):
                animal.setBreedChance(animal.getBreedChance() - 50);
                break;
            default:
        }
    }
/*
    public List<Animal> breed(List<Animal> animals, WorldRegion region) {

        plagueLevel = region.getPlagueLevel();

        List<Animal> newAnimals = new ArrayList<Animal>();

        plagueLevel = 0;

        if (animals.size() >= 300 && animals.size() < 400) {

            plagueLevel = 1;

            System.out.println("- - - Plague level 1 - - -");
        } else if (animals.size() >= 400 && animals.size() < 500) {
            plagueLevel = 2;
            System.out.println("- - - Plague level 2 - - -");
        } else if (animals.size() >= 500) {
            plagueLevel = 3;
            System.out.println("- - - Plague level 3 - - -");
        }

        region.setPlagueLevel(plagueLevel);

        for (Animal animal : animals) {

            switch (plagueLevel) {
                case (1):
                    animal.setBreedChance(animal.getBreedChance() - 5);
                    break;
                case (2):
                    animal.setBreedChance(animal.getBreedChance() - 15);
                    break;
                case (3):
                    animal.setBreedChance(animal.getBreedChance() - 30);
                    break;
                default:
            }

            if (animal.getBreedChance() >= 100) {

                int numberOfBirthedAnimals = animal.getBreedChance() / 100;

                for (int i = 0; i < numberOfBirthedAnimals; i++) {
                    //Creates a copy of birthing animal
                    newAnimals.add(new Animal(animal));
                }

                if (Math.random() * 100 <= animal.getBreedChance() % 100) {
                    newAnimals.add(new Animal(animal));
                }

            } else if (animal.getBreedChance() >= 0 && Math.random() * 100 <= animal.getBreedChance() % 100) {
                newAnimals.add(new Animal(animal));
            }

        }

        return newAnimals;
    }
*/
}
