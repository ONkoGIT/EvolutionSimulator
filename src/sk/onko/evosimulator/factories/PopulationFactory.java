package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.Population;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class PopulationFactory {

    public Population getColoredPopulation(int R,int G,int B){

        Population population = new Population();

        //TODO create AnimalFactory?

        int animalNumber = 50;

        List<Animal> animals = new ArrayList<Animal>();

        for(int i=0; i>= animalNumber; i++){
            Animal animal = new Animal();
            animal.setR(R);
            animal.setG(G);
            animal.setB(B);
            animals.add(animal);
        }

        population.setAnimals(animals);
        return population;
    }
}
