package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Population;
import sk.onko.evosimulator.model.WorldRegion;

import java.awt.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class RegionFactory {

    private PopulationFactory populationFactory = new PopulationFactory();

    //TODO add normal getters for regions, or random regions
    public WorldRegion getColoredRegion(int R, int G, int B){

        WorldRegion worldRegion = new WorldRegion();


        List<Population> populationList = new ArrayList<Population>();
        populationList.add(populationFactory.getColoredPopulation(80,80,80));

        worldRegion.setPopulationList(populationList);

        return  worldRegion;

    }
}
