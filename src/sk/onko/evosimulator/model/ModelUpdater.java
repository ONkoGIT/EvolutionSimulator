package sk.onko.evosimulator.model;

import java.awt.*;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class ModelUpdater {

    public void resetAverageValues(MainModel mainModel){
        mainModel.setAverageBreedChance(0);
        mainModel.setAverageAnimalR(0);
        mainModel.setAverageAnimalG(0);
        mainModel.setAverageAnimalB(0);
    }

    //TODO remove one region code
    public void calculateAverageValues(MainModel mainModel){

        if(mainModel.getAnimals().size()<=0){
            System.out.println(" - - - Number of beings : " + mainModel.getAnimals().size() + " - . SIMULATION ENDING.");
            System.exit(0);
        }

        {

            int averageAnimalR = 0;
            int averageAnimalG = 0;
            int averageAnimalB = 0;
            int averageBreedChance = 0;

            for (Animal animal : mainModel.getAnimals()) {

                averageAnimalR += animal.getR();
                averageAnimalG += animal.getG();
                averageAnimalB += animal.getB();

                averageBreedChance += animal.getBreedChanceWithoutPlague();

            }

            averageAnimalR/=mainModel.getAnimals().size();
            averageAnimalG/=mainModel.getAnimals().size();
            averageAnimalB/=mainModel.getAnimals().size();

            mainModel.setAverageAnimalR(averageAnimalR);
            mainModel.setAverageAnimalG(averageAnimalG);
            mainModel.setAverageAnimalB(averageAnimalB);

            mainModel.getAllAverageColors().add(new Color(averageAnimalR,averageAnimalG,averageAnimalB));

            averageBreedChance = averageBreedChance / mainModel.getAnimals().size();
            mainModel.setAverageBreedChance(averageBreedChance);
            mainModel.getAverageBreedChances().add(averageBreedChance);
        }
    }

    public void calculateAverageValuesNEW(MainModel mainModel){




        if(mainModel.getAnimals().size()<=0){
            System.out.println(" - - - Number of beings : " + mainModel.getAnimals().size() + " - . SIMULATION ENDING.");
            System.exit(0);
        }

        {

            int averageAnimalR = 0;
            int averageAnimalG = 0;
            int averageAnimalB = 0;
            int averageBreedChance = 0;

            for (Animal animal : mainModel.getAnimals()) {

                averageAnimalR += animal.getR();
                averageAnimalG += animal.getG();
                averageAnimalB += animal.getB();

                averageBreedChance += animal.getBreedChanceWithoutPlague();

            }

            averageAnimalR/=mainModel.getAnimals().size();
            averageAnimalG/=mainModel.getAnimals().size();
            averageAnimalB/=mainModel.getAnimals().size();

            mainModel.setAverageAnimalR(averageAnimalR);
            mainModel.setAverageAnimalG(averageAnimalG);
            mainModel.setAverageAnimalB(averageAnimalB);

            mainModel.getAllAverageColors().add(new Color(averageAnimalR,averageAnimalG,averageAnimalB));

            averageBreedChance = averageBreedChance / mainModel.getAnimals().size();
            mainModel.setAverageBreedChance(averageBreedChance);
            mainModel.getAverageBreedChances().add(averageBreedChance);
        }
    }
}
