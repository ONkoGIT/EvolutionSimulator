package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class WorldRegionFactory {


    public WorldRegion getRandomRegion() {

        WorldRegion currentRegion = new WorldRegion();
        currentRegion.setTemperature(25);

        int randomNumber = (int) (Math.random() * 6);
        System.out.println("EnvironmentType case " + randomNumber);

        switch (randomNumber) {
            case 0:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                currentRegion.setTemperature(20);
                break;
            case 1:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.ARCTIC);
                currentRegion.setTemperature(-10);
                break;
            case 2:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.OCEAN);
                currentRegion.setTemperature(10);
                break;
            case 3:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.DESERT);
                currentRegion.setTemperature(50);
                break;
            case 4:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.PLAINS);
                currentRegion.setTemperature(30);
                break;
            case 5:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                currentRegion.setTemperature(20);
                break;
            case 6:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.PLAINS);
                currentRegion.setTemperature(30);
                break;

            default:
                currentRegion.setEnvironmentType(WorldRegion.EnvironmentType.FOREST);
                currentRegion.setTemperature(20);
                break;

        }

        return currentRegion;


    }
}
