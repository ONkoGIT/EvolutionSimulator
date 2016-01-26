package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.Environment;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.WorldRegion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class MainModelFactory {
    private RegionFactory regionFactory = new RegionFactory();
    private int mapWidth = 2;
    private int mapHeight = 2;

    public  MainModel getBasicMainModel(){

        MainModel mainModel = new MainModel();
        mainModel.setEnvironment(EnvironmentFactory.getBasicEnvironment());

        WorldRegion[][] worldRegions ;
        worldRegions = new WorldRegion[mapWidth][mapHeight];

        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {

                worldRegions[x][y] = regionFactory.getColoredRegion(x*100,200,y*100);

            }

        }

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
