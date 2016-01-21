package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.Environment;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class MainModelFactory {

    public static MainModel getBasicMainModel(){

        MainModel mainModel = new MainModel();
        mainModel.setEnvironment(EnvironmentFactory.getBasicEnvironment());

        WorldRegion[][] worldRegions = {{new WorldRegion(),new WorldRegion()},{}};
        mainModel.setWorldRegions(worldRegions);

        mainModel.setAnimals(new ArrayList<>());
        for (int i = 0; i < 100; i++) {
            Animal animal = new Animal();
            animal.setR(80);
            animal.setG(200);
            animal.setB(50);
            mainModel.getAnimals().add(animal);

        }

        return mainModel;
    }
}
