package sk.onko.evosimulator.controller;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.model.ModelUpdater;
import sk.onko.evosimulator.view.MainView;
import sk.onko.evosimulator.world.Breeder;
import sk.onko.evosimulator.model.Environment;
import sk.onko.evosimulator.world.Mutator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class MainController {

    private MainModel mainModel;
    private ModelUpdater modelUpdater = new ModelUpdater();

    public MainView mainView;

    protected List<Animal> beings = new ArrayList<Animal>();
    protected Mutator mutator = new Mutator();
    protected Breeder breeder = new Breeder();

    List<Integer> averageBreedChances = new ArrayList<Integer>();

    List<Color> allAverageColors = new ArrayList<Color>();
    List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    public MainController(MainModel mainModel, MainView mainView) {

        this.mainModel = mainModel;
        this.mainView = mainView;

        startTimeCycle();

    }

    private void startTimeCycle() {
        int cyclesElapsed = 0;

        while (cyclesElapsed <= 100000) {


            if (mainModel.getAnimals().size() >= 1000 || mainModel.getAnimals().size() <= 0) {
                System.out.println(" - - - Number of beings : " + mainModel.getAnimals().size() + " - TOO HIGH/LOW. SIMULATION ENDING.");
                System.exit(0);

            } else {
                System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");
            }

            //TODO Outsource model updates to ModelUpdater (or its interface for bonus points)

            //TODO this changes mainModel fields, not modelUpdaters - make it more clear
            modelUpdater.resetAverageValues(mainModel);

            //Random mutations
            mainModel.setAnimals(mutator.mutate(mainModel.getAnimals(), mainModel.getEnvironment()));
            //Breeding
            mainModel.setAnimals(breeder.breed(mainModel.getAnimals(),mainModel.getEnvironment()));

            //TODO this changes mainModel fields, not modelUpdaters - make it more clear
            modelUpdater.calculateAverageValues(mainModel);

            //model update
            mainModel.setAverageBreedChance(mainModel.getAverageBreedChance() / mainModel.getAnimals().size());
            mainModel.getAverageBreedChances().add(mainModel.getAverageBreedChance());

            //new style
            {
                int averageAnimalR = mainModel.getAverageAnimalR();
                int averageAnimalG = mainModel.getAverageAnimalG();
                int averageAnimalB = mainModel.getAverageAnimalB();

                if (mainModel.getColorList().size() < 60) {
                    mainModel.getColorList().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
                }

                if (mainModel.getColorList().size() > 60) {
                    mainModel.getColorList().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
                    mainModel.getColorList().remove(0);
                }
            }

            mainView.updateView(mainModel);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            cyclesElapsed++;
            mainModel.setCyclesElapsed(cyclesElapsed);

        }
    }



}