package sk.onko.evosimulator.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class ModelUpdater {

    /*
    public void resetAverageValues(MainModel mainModel) {
        mainModel.setAverageBreedChance(0);
        mainModel.setAverageAnimalR(0);
        mainModel.setAverageAnimalG(0);
        mainModel.setAverageAnimalB(0);
    }
*/

    public void calculateAverageValuesNEW(MainModel mainModel) {

        for (int x = 0; x < mainModel.getMapWidth(); x++) {
            for (int y = 0; y < mainModel.getMapHeight(); y++) {
                WorldRegion currentRegion = mainModel.getWorldRegionMap().get(new Coordinates(x, y));

                for (AnimalSpecies animalSpecies : currentRegion.getAnimalSpeciesList()) {

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
                        //  mainModel.getAllAverageColors().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));

                        averageBreedChance = averageBreedChance / animalSpecies.getAnimals().size();

                        //  mainModel.setAverageBreedChance(averageBreedChance);
                        //   mainModel.getAverageBreedChances().add(averageBreedChance);

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

                //plant stuff for particular region

                for (PlantSpecies plantSpecies : currentRegion.getPlantSpeciesList()) {
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
                    int randomNumberOfPlants = (int) (Math.random() * 200);
                    for (int i = 0; i < randomNumberOfPlants; i++) {
                        newPlantList.add(new Plant());
                    }

                    totalNumberOfNewPlants += randomNumberOfPlants;
                    // System.out.println(totalNumberOfNewPlants + " new plants created.");

                    plantSpecies.setPlants(newPlantList);
                }
            }
        }
    }


}

