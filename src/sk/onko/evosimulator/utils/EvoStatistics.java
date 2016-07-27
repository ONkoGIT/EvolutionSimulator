package sk.onko.evosimulator.utils;

import sk.onko.evosimulator.model.Coordinates;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ondrej on 26.7.2016.
 */
public class EvoStatistics {

    public static int numOfMutations = 0;
    public static int numOfPlantsEaten = 0;
    public static int numOfAnimalsEaten = 0;

    List<Map> timelineOfWorldRegions = new ArrayList<>();
    Map<Coordinates, HistoricalWorldRegion> historicalWorldRegionMap = new HashMap<Coordinates, HistoricalWorldRegion>();

    //Transform WorldRegions to more lightweight HistoricalWorldRegions and add the map to the list
    public static void recordWorldToHistory(Map<Coordinates,WorldRegion> world){

    }
}
