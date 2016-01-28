package sk.onko.evosimulator.controller;

import sk.onko.evosimulator.model.*;
import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.view.MainView;
import sk.onko.evosimulator.view.gui.UpdateableView;
import sk.onko.evosimulator.world.Breeder;
import sk.onko.evosimulator.world.Mutator;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class MainController {

    private MainModel mainModel;
    private ModelUpdater modelUpdater = new ModelUpdater();

    public UpdateableView mainView;

    protected List<Animal> beings = new ArrayList<Animal>();
    protected Mutator mutator = new Mutator();
    protected Breeder breeder = new Breeder();

    List<Integer> averageBreedChances = new ArrayList<Integer>();

    List<Color> allAverageColors = new ArrayList<Color>();
    List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    public MainController(MainModel mainModel, MainView mainView) {

        this.mainModel = mainModel;
        this.mainView = mainView;

    }

    public void startTimeCycle() {

        long beginningOfCycleTime = System.currentTimeMillis();
        int cyclesElapsed = 0;

        while (cyclesElapsed <= 10000000) {

            int worldPopulation = 0;
            //TUTO map
            for (int x = 0; x < mainModel.getMapWidth(); x++) {
                for (int y = 0; y < mainModel.getMapHeight(); y++) {
                    WorldRegion currentRegion = mainModel.getWorldRegionMap().get(new Coordinates(x, y));

                    int regionPopulation = 0;
                    for (AnimalSpecies animalSpecies : currentRegion.getAnimalSpeciesList()) {

                        regionPopulation += animalSpecies.getAnimals().size();

                        List<Animal> animalList = animalSpecies.getAnimals();

                        //Random mutations

                        List<Animal> mutatedAnimalList = mutator.mutate(animalList, currentRegion);
                        animalSpecies.setAnimals(mutatedAnimalList);

                        //Breeding
                        animalSpecies.setAnimals(breeder.breed(animalSpecies.getAnimals(), currentRegion));

                    }

                    currentRegion.setInhabitantNumber(regionPopulation);

                    int regionPlantNumber = 0;
                    for (PlantSpecies plantSpecies : currentRegion.getPlantSpeciesList()) {
                        regionPlantNumber = plantSpecies.getPlants().size();
                    }

                    currentRegion.setPlantNumber(regionPlantNumber);


                    worldPopulation += regionPopulation;
                }


            }

            if (worldPopulation >= 40000 || worldPopulation <= 0) {
                System.out.println(" - - - Number of beings : " + worldPopulation + " - TOO HIGH/LOW. SIMULATION ENDING.");
                System.exit(0);

            } else {
                System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");
                System.out.println(" - - - World population is " + worldPopulation + " - - -");
            }

            //TODO this changes mainModel fields, not modelUpdaters - make it more clear
            //  modelUpdater.resetAverageValues(mainModel);

            //TODO this changes mainModel fields, not modelUpdaters - make it more clear
            modelUpdater.calculateAverageValuesNEW(mainModel);

            //model update
            //   mainModel.setAverageBreedChance(mainModel.getAverageBreedChance() / mainModel.getAnimals().size());
            //  mainModel.getAverageBreedChances().add(mainModel.getAverageBreedChance());

            mainView.updateView(mainModel);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cyclesElapsed++;
            mainModel.setCyclesElapsed(cyclesElapsed);

            if (cyclesElapsed == 1000) {
                long endOfCycleTime = System.currentTimeMillis();
                System.out.println("1000 cycles elapsed, took " + (beginningOfCycleTime - endOfCycleTime) + " milliseconds");
            }

        }
    }

}
