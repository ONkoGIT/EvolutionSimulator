package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;

/**
 * Created by Ondrej on 23.7.2016.
 */
public class AnimalFactory {

    public static Animal getElephant(){
        Animal animal = new Animal();
        animal.setR(50);
        animal.setG(50);
        animal.setB(80);
        animal.setClaws(30);
        animal.setFurLevel(30);
        animal.setCarnivoreRatio(0);
        return animal;
    }

    public static Animal getGrizzlyBear(){
        Animal animal = new Animal();
        animal.setR(130);
        animal.setG(60);
        animal.setB(0);
        animal.setClaws(180);
        animal.setFurLevel(200);
        animal.setCarnivoreRatio(80);
        return animal;
    }
}
