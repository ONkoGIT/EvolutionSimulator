package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Plant;
import sk.onko.evosimulator.model.PlantSpecies;
import sk.onko.evosimulator.model.WorldRegion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 14.2.2016.
 */
public class PlantGrower {

    public WorldRegion growPlants(WorldRegion worldRegion) {

        for (PlantSpecies plantSpecies : worldRegion.getPlantSpeciesList()) {
            //plants growing
            List<Plant> newPlantList = new ArrayList<>();
            int totalNumberOfNewPlants = 0;
            //   System.out.println(plantSpecies.getPlants().size() + " plants currently.");

            for (Plant plant : plantSpecies.getPlants()) {
                if (totalNumberOfNewPlants < 1000) {
                    if (Math.random() <= 0.6) {
                        newPlantList.add(new Plant(plant));
                        totalNumberOfNewPlants++;
                    }
                }
            }

            //Generating plants, regardless of actual plants. Even, if zero - prevents extinction
            int randomNumberOfPlants = (int) (Math.random() * 800);
            for (int i = 0; i < randomNumberOfPlants; i++) {
                newPlantList.add(new Plant());
            }
            totalNumberOfNewPlants += randomNumberOfPlants;

            // System.out.println(totalNumberOfNewPlants + " new plants created.");
            plantSpecies.setPlants(newPlantList);

        }
        return worldRegion;
    }
}
