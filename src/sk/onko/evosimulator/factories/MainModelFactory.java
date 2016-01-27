package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class MainModelFactory {
    private RegionFactory regionFactory = new RegionFactory();
    private int mapWidth = 2;
    private int mapHeight = 2;

    public MainModel getBasicMainModel() {

        MainModel mainModel = new MainModel();

        mainModel.setMapWidth(mapWidth);
        mainModel.setMapHeight(mapHeight);

        Map<Coordinates, WorldRegion> worldRegionMap = new HashMap<Coordinates, WorldRegion>();

        for (int x = 0; x <= mainModel.getMapWidth(); x++) {
            for (int y = 0; y <= mainModel.getMapHeight(); y++) {

                WorldRegion currentRegion = new WorldRegion();
                currentRegion.setTemperature(25);

                int randomNumber = (int) (Math.random() * 6);
                System.out.println("EnvironmentType case " + randomNumber);

                switch (randomNumber) {
                    case 0:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                        break;
                    case 1:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.ARCTIC);
                        break;
                    case 2:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.OCEAN);
                        break;
                    case 3:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.DESERT);
                        break;
                    case 4:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.PLAINS);
                        break;
                    case 5:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                        break;
                    case 6:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.PLAINS);
                        break;

                    default:
                        currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                        break;

                }

                List<Population> populationList = new ArrayList<Population>();

                for (int populationNumber = 0; populationNumber < 1; populationNumber++) {
                    Population population = new Population();

                    List<Animal> animalList = new ArrayList<>();
                    for (int i = 0; i < 20; i++) {
                        Animal animal = new Animal();
                        animal.setR(80);
                        animal.setG(200);
                        animal.setB(50);

                        animalList.add(animal);
                    }
                    System.out.println("Animals created : " + animalList.size());

                    population.setAnimals(animalList);
                    populationList.add(population);

                }

                currentRegion.setPopulationList(populationList);
                worldRegionMap.put(new Coordinates(x, y), currentRegion);


            }
        }

        mainModel.setWorldRegionMap(worldRegionMap);

        return mainModel;
    }
}
