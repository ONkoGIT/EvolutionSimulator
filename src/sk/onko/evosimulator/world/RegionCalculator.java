package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 14.2.2016.
 */
public class RegionCalculator {
    public WorldRegion calculateStats(WorldRegion worldRegion) {

        int inhabitantNumber = 0;

        for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {

            inhabitantNumber += animalSpecies.getAnimals().size();
        }
        worldRegion.setInhabitantNumber(inhabitantNumber);

        int regionPlantNumber = 0;
        for (PlantSpecies plantSpecies : worldRegion.getPlantSpeciesList()) {
            regionPlantNumber = plantSpecies.getPlants().size();
        }

        worldRegion.setPlantNumber(regionPlantNumber);

                for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {

                    int averageAnimalR = 0;
                    int averageAnimalG = 0;
                    int averageAnimalB = 0;
                    int averageBreedChance = 0;
                    int averageFurLevel = 0;
                    int averageClaws = 0;

                    for (Animal animal : animalSpecies.getAnimals()) {

                        averageAnimalR += animal.getR();
                        averageAnimalG += animal.getG();
                        averageAnimalB += animal.getB();

                        averageFurLevel += animal.getFurLevel();
                        averageClaws += animal.getClaws();

                        averageBreedChance += animal.getBreedChanceWithoutPlague();

                        //TODO 3 implement average color histories for populations

                        averageBreedChance = averageBreedChance / animalSpecies.getAnimals().size();
                    }

                    if (animalSpecies.getAnimals().size() != 0) {
                        averageAnimalR /= animalSpecies.getAnimals().size();
                        averageAnimalG /= animalSpecies.getAnimals().size();
                        averageAnimalB /= animalSpecies.getAnimals().size();

                        averageFurLevel /= animalSpecies.getAnimals().size();

                        averageClaws /= animalSpecies.getAnimals().size();

                    }

                    animalSpecies.setAverageAnimalR(averageAnimalR);
                    animalSpecies.setAverageAnimalG(averageAnimalG);
                    animalSpecies.setAverageAnimalB(averageAnimalB);
                    animalSpecies.setAverageFurLevel(averageFurLevel);
                    animalSpecies.setAverageClaws(averageClaws);
                }
        return worldRegion;
    }
}
