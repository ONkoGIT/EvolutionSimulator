package sk.onko.evosimulator.model;

import java.awt.*;

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

                for (Population population : currentRegion.getPopulationList()) {

                    int averageAnimalR = 0;
                    int averageAnimalG = 0;
                    int averageAnimalB = 0;
                    int averageBreedChance = 0;

                    for (Animal animal : population.getAnimals()) {

                        averageAnimalR += animal.getR();
                        averageAnimalG += animal.getG();
                        averageAnimalB += animal.getB();

                        averageBreedChance += animal.getBreedChanceWithoutPlague();

                        averageAnimalR /= population.getAnimals().size();
                        averageAnimalG /= population.getAnimals().size();
                        averageAnimalB /= population.getAnimals().size();

                        population.setAverageAnimalR(averageAnimalR);
                        population.setAverageAnimalG(averageAnimalG);
                        population.setAverageAnimalB(averageAnimalB);

                        //TODO 3 implement average color histories for populations
                      //  mainModel.getAllAverageColors().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));

                        averageBreedChance = averageBreedChance / population.getAnimals().size();

                      //  mainModel.setAverageBreedChance(averageBreedChance);
                     //   mainModel.getAverageBreedChances().add(averageBreedChance);


                    }
                }
            }
        }


    }
}
