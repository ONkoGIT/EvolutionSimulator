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

                    for (Animal animal : animalSpecies.getAnimals()) {

                        averageAnimalR += animal.getR();
                        averageAnimalG += animal.getG();
                        averageAnimalB += animal.getB();

                        averageFurLevel += animal.getFurLevel();

                        averageBreedChance += animal.getBreedChanceWithoutPlague();


                        //TODO 3 implement average color histories for populations
                        //  mainModel.getAllAverageColors().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));

                        averageBreedChance = averageBreedChance / animalSpecies.getAnimals().size();

                        //  mainModel.setAverageBreedChance(averageBreedChance);
                        //   mainModel.getAverageBreedChances().add(averageBreedChance);


                    }


                    if(animalSpecies.getAnimals().size()!=0){
                        averageAnimalR /= animalSpecies.getAnimals().size();
                        averageAnimalG /= animalSpecies.getAnimals().size();
                        averageAnimalB /= animalSpecies.getAnimals().size();

                        averageFurLevel /= animalSpecies.getAnimals().size();
                    }



                    animalSpecies.setAverageFurLevel(averageFurLevel);
                    animalSpecies.setAverageAnimalR(averageAnimalR);
                    animalSpecies.setAverageAnimalG(averageAnimalG);
                    animalSpecies.setAverageAnimalB(averageAnimalB);
                }

                //plant stuff for particular region

                for (PlantSpecies plantSpecies : currentRegion.getPlantSpeciesList()) {
                    //plants growing
                    List<Plant> newPlantList = new ArrayList<>();
                    int totalNumberOfNewPlants = 0;
                    for (Plant plant : plantSpecies.getPlants()) {

                        if (totalNumberOfNewPlants < 1000) {
                            newPlantList.add(new Plant(plant));
                            newPlantList.add(new Plant(plant));
                            totalNumberOfNewPlants++;
                            totalNumberOfNewPlants++;
                        }


                    }

                    System.out.println(totalNumberOfNewPlants + " new plants created.");
                    plantSpecies.setPlants(newPlantList);

                }
            }

        }
    }


}

