package sk.onko.evosimulator.utils;

import sk.onko.evosimulator.model.Coordinates;
import sk.onko.evosimulator.model.MainModel;
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

    public static List<Map> timelineOfWorldRegions = new ArrayList<>();
    public static Map<Coordinates, HistoricalWorldRegion> historicalWorldRegionMap = new HashMap<Coordinates, HistoricalWorldRegion>();

    //Transform WorldRegions to more lightweight HistoricalWorldRegions and add the map to the list
    public static void recordWorldToHistory(MainModel mainModel){
        for (int x = 0; x < mainModel.getMapWidth(); x++) {
            for (int y = 0; y < mainModel.getMapHeight(); y++) {
                WorldRegion currentRegion = mainModel.getWorldRegionMap().get(new Coordinates(x, y));
                historicalWorldRegionMap.put(new Coordinates(x,y), new HistoricalWorldRegion(currentRegion));
            }
        }
    }
}
