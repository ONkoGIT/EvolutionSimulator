package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.WorldRegion;
import sk.onko.evosimulator.utils.EvoLogger;

/**
 * Created by Ondrej on 14.2.2016.
 */
public class PlagueMaker {

    public WorldRegion managePlagues(WorldRegion worldRegion) {

        int plagueLevel = 0;

        if (worldRegion.getInhabitantNumber() >= 900 && worldRegion.getInhabitantNumber() < 1200) {
            plagueLevel = 1;
        } else if (worldRegion.getInhabitantNumber() >= 1200 && worldRegion.getInhabitantNumber() < 1800) {
            plagueLevel = 2;
        } else if (worldRegion.getInhabitantNumber() >= 1800) {
            plagueLevel = 3;
        }

        if (EvoLogger.loggingPlagueLevels) System.out.println("- - - Plague level " + plagueLevel + " - - -");

        worldRegion.setPlagueLevel(plagueLevel);
        return worldRegion;
    }

}
