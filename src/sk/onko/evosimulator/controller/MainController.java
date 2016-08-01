package sk.onko.evosimulator.controller;

import sk.onko.evosimulator.model.*;
import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.utils.EvoLogger;
import sk.onko.evosimulator.utils.EvoStatistics;
import sk.onko.evosimulator.utils.SimulationSettings;
import sk.onko.evosimulator.view.MainView;
import sk.onko.evosimulator.view.gui.UpdateableView;
import sk.onko.evosimulator.world.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class MainController {

    private MainModel mainModel;
    public UpdateableView mainView;

    protected List<Animal> beings = new ArrayList<Animal>();
    protected Mutator mutator = new Mutator();
    protected BreedChanceCalculator breedChanceCalculator = new BreedChanceCalculator();
    protected Breeder breeder = new Breeder();
    protected PlantGrower plantGrower = new PlantGrower();
    protected RegionCalculator regionCalculator = new RegionCalculator();
    protected AnimalTravel animalTravel = new AnimalTravel();
    protected FitnessCalculator fitnessCalculator = new FitnessCalculator();
    protected AnimalFeeder animalFeeder = new AnimalFeeder();
    protected PlagueMaker plagueMaker = new PlagueMaker();
    protected SpeciesClassifier speciesClassifier = new SpeciesClassifier();

    public static int cyclesElapsed = 0;
    long beginningOfCycleTime = 0;

    public MainController(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
    }

    public void startTimeCycle() {
        beginningOfCycleTime = System.currentTimeMillis();

        while (cyclesElapsed <= SimulationSettings.MAX_NUM_OF_CYCLES) {
            int worldPopulation = 0;

            for (int x = 0; x < mainModel.getMapWidth(); x++) {
                for (int y = 0; y < mainModel.getMapHeight(); y++) {
                    WorldRegion currentRegion = mainModel.getWorldRegionMap().get(new Coordinates(x, y));
                    processRegion(currentRegion);
                    worldPopulation += currentRegion.getInhabitantNumber();
                }
            }

            EvoStatistics.recordWorldToHistory(mainModel);
            endSimulationIfWorldPopulationTooHigh(worldPopulation);

            mainView.updateView(mainModel);
            cyclesElapsed++;
            mainModel.setCyclesElapsed(cyclesElapsed);
            sleepFor(SimulationSettings.SLEEP_TIME_AFTER_CYCLE);
            if (EvoLogger.loggingTimePassedForCycleNumber) logTimePassedForCycleNumber(1000);
        }

        if (EvoLogger.loggingStatisticsAfterEnd) EvoLogger.logStatisticsAfterEnd();
    }

    private void processRegion(WorldRegion currentRegion){
        currentRegion = mutator.mutate(currentRegion);
        currentRegion = fitnessCalculator.calculateFitness(currentRegion);
        currentRegion = animalFeeder.feedAnimals(currentRegion);
        currentRegion = breeder.breed(currentRegion);
        currentRegion = plantGrower.growPlants(currentRegion);
        currentRegion = speciesClassifier.recalculateAnimalSpecies(currentRegion);
        currentRegion = regionCalculator.calculateStats(currentRegion);
        currentRegion = plagueMaker.managePlagues(currentRegion);
    }

    private void sleepFor(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void endSimulationIfWorldPopulationTooHigh(int worldPopulation){
        if (worldPopulation >= SimulationSettings.MAX_NUM_OF_BEINGS || worldPopulation <= 0) {
            System.out.println(" - - - Number of beings : " + worldPopulation + " - TOO HIGH/LOW. SIMULATION ENDING.");
            if (EvoLogger.loggingStatisticsAfterEnd) EvoLogger.logStatisticsAfterEnd();
            logHistoryForAnimal();
            System.exit(0);
        } else {
            if (EvoLogger.loggingCycleNumbers) System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");
            if (EvoLogger.loggingWorldPopulation) System.out.println(" - - - World population is " + worldPopulation + " - - -");
        }
    }

    private void logTimePassedForCycleNumber(int cycleNumberToLog){
        if (cyclesElapsed == cycleNumberToLog) {
            long endOfCycleTime = System.currentTimeMillis();
            System.out.println(cycleNumberToLog + " cycles elapsed, took " + (beginningOfCycleTime - endOfCycleTime) + " milliseconds");
        }
    }

    private void logHistoryForAnimal(){
        WorldRegion regionToLogAnimalHistoryFor = mainModel.getWorldRegionMap().get(new Coordinates(1,1));
        for (AnimalSpecies animalSpecies :  regionToLogAnimalHistoryFor.getAnimalSpeciesList()) {
            for (Animal animal : animalSpecies.getAnimals()) {
                if(!animal.getEvolutionHistory().isEmpty()){
                    System.out.println(EvoLogger.evolutionHistoryForAnimal(animal));
                    return;
                }
            }
        }
    }
}