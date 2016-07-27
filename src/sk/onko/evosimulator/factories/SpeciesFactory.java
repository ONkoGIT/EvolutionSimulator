package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class SpeciesFactory {

    public AnimalSpecies getGrizzlyBears() {

        AnimalSpecies animalSpecies = new AnimalSpecies();
        int animalNumber = 50;

        List<Animal> animals = new ArrayList<Animal>();

        for (int i = 0; i <= animalNumber; i++) {
            animals.add(AnimalFactory.getGrizzlyBear());
        }

        animalSpecies.setAnimals(animals);
        System.out.println(animalSpecies.getAnimals().size() + " bears created");
        animalSpecies.setSpeciesName("Grizzly Bear");
        return animalSpecies;


    }

    public AnimalSpecies getElephants(int count) {
        AnimalSpecies animalSpecies = new AnimalSpecies();
        List<Animal> animals = new ArrayList<Animal>();
        for (int i = 0; i <= count; i++) {
            animals.add(AnimalFactory.getElephant());
        }
        animalSpecies.setAnimals(animals);
        animalSpecies.setSpeciesName("Elephant");
        return animalSpecies;
    }

    public AnimalSpecies getColoredPopulation(int R, int G, int B) {

        AnimalSpecies animalSpecies = new AnimalSpecies();

        int animalNumber = 50;

        List<Animal> animals = new ArrayList<Animal>();

        for (int i = 0; i >= animalNumber; i++) {
            Animal animal = new Animal();
            animal.setR(R);
            animal.setG(G);
            animal.setB(B);
            animals.add(animal);
        }

        animalSpecies.setAnimals(animals);
        animalSpecies.setSpeciesName("Defaultoid");
        return animalSpecies;
    }
}
