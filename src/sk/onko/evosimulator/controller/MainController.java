package sk.onko.evosimulator.controller;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.MainModel;
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

      //  letThereBeBeings();
        startTimeCycle();

    }


    private void startTimeCycle() {
        int cyclesElapsed = 0;

        while (cyclesElapsed <= 100000) {


            //Changes in model instead of here
            //Change to mainModel.setZeroToAverageValues()
            mainModel.setAverageBreedChance(0);
            mainModel.setAverageAnimalR(0);
            mainModel.setAverageAnimalG(0);
            mainModel.setAverageAnimalB(0);

            System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");

            //New
            mainModel.setAnimals(mutator.mutate(mainModel.getAnimals(), mainModel.getEnvironment()));
            mainModel.setAnimals(breeder.breed(mainModel.getAnimals()));

            //new { getting average values

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

                //needed ?
                averageBreedChance = averageBreedChance / mainModel.getAnimals().size();
                mainModel.setAverageBreedChance(averageBreedChance);
                mainModel.getAverageBreedChances().add(averageBreedChance);
            }

            System.out.println(" - - - Number of beings : " +mainModel.getAnimals().size() + " - - -");


            if (mainModel.getAnimals().size() >= 1000 || mainModel.getAnimals().size() <= 0) {
                System.out.println(" - - - Number of beings : " + beings.size() + " - TOO HIGH/LOW. SIMULATION ENDING.");
                cyclesElapsed = 999999999;

            }

            //model update
            mainModel.setAverageBreedChance(mainModel.getAverageBreedChance() / mainModel.getAnimals().size());
            mainModel.getAverageBreedChances().add(mainModel.getAverageBreedChance());


            //model update
            mainModel.setAverageAnimalR(mainModel.getAverageAnimalR() / mainModel.getAnimals().size());
            mainModel.setAverageAnimalG(mainModel.getAverageAnimalG() / mainModel.getAnimals().size());
            mainModel.setAverageAnimalB(mainModel.getAverageAnimalB() / mainModel.getAnimals().size());


            //model update
            Color newAverageAnimalColor = new Color(mainModel.getAverageAnimalR(), mainModel.getAverageAnimalG(), mainModel.getAverageAnimalB());
            mainModel.getAllAverageColors().add(newAverageAnimalColor);


            //new style
            {
                int averageAnimalR = mainModel.getAverageAnimalR();
                int averageAnimalG = mainModel.getAverageAnimalG();
                int averageAnimalB = mainModel.getAverageAnimalB();

                if (mainModel.getColorList().size() < 60) {
                    mainModel.getColorList().add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
                }

                if (mainModel.getColorList().size() >= 60) {
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



           // if (cyclesElapsed % 50 == 0) {
           //     updateGraph();
          //  }
            mainModel.setCyclesElapsed(cyclesElapsed);


        }
    }


    //Moved to view
    private void updateGraph() {
        int positionOfGraphMarker = 0;

        for (GraphMark graphMark : graphMarks) {
            graphMark.setBackground(allAverageColors.get((positionOfGraphMarker * (allAverageColors.size() / 50))));
            graphMark.setYfromBottom(averageBreedChances.get((positionOfGraphMarker * (averageBreedChances.size() / 50))));


            positionOfGraphMarker++;
        }

        System.out.println("Graph updated");
    }

    private void letThereBeBeings() {
        for (int i = 0; i < 100; i++) {
            beings.add(new Animal());
        }

        System.out.println(beings.size());
    }


}
