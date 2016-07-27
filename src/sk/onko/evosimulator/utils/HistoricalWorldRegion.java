package sk.onko.evosimulator.utils;

import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ondrej on 27.7.2016.
 */
public class HistoricalWorldRegion {

    Map<String, HistoricalSpecies> historicalSpeciesMap = new HashMap<String, HistoricalSpecies>();

    public HistoricalWorldRegion(WorldRegion worldRegion){
        for(AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()){
            historicalSpeciesMap.put(animalSpecies.getSpeciesCode(), new HistoricalSpecies(animalSpecies));
        }
    }
}
