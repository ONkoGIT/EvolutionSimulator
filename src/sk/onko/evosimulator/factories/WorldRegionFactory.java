package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.WorldRegion;

/**
 * Created by ondrej.janosik on 27/01/2016.
 */

//TODO use this
public class WorldRegionFactory {


    public WorldRegion getArcticRegion(){
        WorldRegion worldRegion = new WorldRegion();
        worldRegion.setEnvironmentType(WorldRegion.EnvironmentType.ARCTIC);
        return  worldRegion;
    }
}
