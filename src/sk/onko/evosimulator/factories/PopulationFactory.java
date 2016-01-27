package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class PopulationFactory {

    public AnimalSpecies getColoredPopulation(int R, int G, int B) {

        AnimalSpecies animalSpecies = new AnimalSpecies();

        //TODO create AnimalFactory?

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
        return animalSpecies;
    }
}
