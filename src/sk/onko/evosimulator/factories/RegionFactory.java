package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class RegionFactory {


    private SpeciesFactory speciesFactory = new SpeciesFactory();

    //TODO add normal getters for regions, or random regions
    public WorldRegion getColoredRegion(int R, int G, int B){

        WorldRegion worldRegion = new WorldRegion();


        List<AnimalSpecies> animalSpeciesList = new ArrayList<AnimalSpecies>();
        animalSpeciesList.add(speciesFactory.getColoredPopulation(80,80,80));

        worldRegion.setAnimalSpeciesList(animalSpeciesList);

        return  worldRegion;

    }
}
