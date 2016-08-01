package sk.onko.evosimulator.controller;

/**
 * Created by Ondrej on 26.2.2016.
 */

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.AnimalSpecies;
import sk.onko.evosimulator.model.WorldRegion;
import sk.onko.evosimulator.utils.EvoLogger;

import java.awt.*;
import java.util.*;
import java.util.List;

public class SpeciesClassifier {

    private int deviation = 0;


    public void testDuplicates() {

        Set<String> colorSet = new TreeSet<String>();

        for (int r = 25; r < 255; r += 50) {
            for (int g = 25; g < 255; g += 50) {
                for (int b = 25; b < 255; b += 50) {

                    if (colorSet.contains(RGBtoString(new Color(r, g, b)))) {
                        System.out.println("Duplicate - " + RGBtoString(new Color(r, g, b)));

                    } else {
                        colorSet.add(RGBtoString(new Color(r, g, b)));
                    }
                }
            }
        }
        System.out.println("Color set size: " + colorSet.size());
    }

    public String RGBtoString(Color color) {

        int R = color.getRed();
        int G = color.getGreen();
        int B = color.getBlue();

        //Cast the levels of colors to number 0 - 4
        R = (int) R/51;
        G = (int) G/51;
        B = (int) B/51;

        switch (R) {
            case 0:
                switch (G) {
                    case 0:
                        switch (B) {
                            case 0:
                                return "Black";
                            case 1:
                                return "Stratos";
                            case 2:
                                return "Navy";
                            case 3:
                                return "Darkblue";
                            case 4:
                                return "Blue";

                        }
                        break;

                    case 1:
                        switch (B) {
                            case 0:
                                return "Crusoe";
                            case 1:
                                return "Sherpa";
                            case 2:
                                return "Orient";
                            case 3:
                                return "Cobalt";
                            case 4:
                                return "Scienceblue";

                        }
                        break;

                    case 2:
                        switch (B) {
                            case 0:
                                return "Forestgreen";
                            case 1:
                                return "Jewel";
                            case 2:
                                return "Elm";
                            case 3:
                                return "Easternblue";
                            case 4:
                                return "Denim";

                        }
                        break;

                    case 3:
                        switch (B) {
                            case 0:
                                return "Lapalma";
                            case 1:
                                return "Meadowgreen";
                            case 2:
                                return "Mountaingreen";
                            case 3:
                                return "Java";
                            case 4:
                                return "Curiousblue";

                        }
                        break;

                    case 4:
                        switch (B) {
                            case 0:
                                return "Malachite";
                            case 1:
                                return "Bluemalachite";
                            case 2:
                                return "Tealmalachite";
                            case 3:
                                return "Javic";
                            case 4:
                                return "Turquoiseblue";

                        }
                        break;
                }
                break;

            case 1:
                switch (G) {
                    case 0:
                        switch (B) {
                            case 0:
                                return "Cocoa";
                            case 1:
                                return "Wineberry";
                            case 2:
                                return "Persianindigo";
                            case 3:
                                return "Honeyflower";
                            case 4:
                                return "Purpleheart";

                        }
                        break;

                    case 1:
                        switch (B) {
                            case 0:
                                return "Thatch";
                            case 1:
                                return "Tundora";
                            case 2:
                                return "Eastbay";
                            case 3:
                                return "Blueviolet";
                            case 4:
                                return "Royalblueish";

                        }
                        break;

                    case 2:
                        switch (B) {
                            case 0:
                                return "Vidaloca";
                            case 1:
                                return "Hippiegreen";
                            case 2:
                                return "Fadedjade";
                            case 3:
                                return "Steelblue";
                            case 4:
                                return "Royalblue";

                        }
                        break;

                    case 3:
                        switch (B) {
                            case 0:
                                return "Christi";
                            case 1:
                                return "Apple";
                            case 2:
                                return "Oceangreen";
                            case 3:
                                return "Fountainblue";
                            case 4:
                                return "Pictonblue";

                        }
                        break;

                    case 4:
                        switch (B) {
                            case 0:
                                return "Lima";
                            case 1:
                                return "Pastelgreen";
                            case 2:
                                return "Pastelteal";
                            case 3:
                                return "Turquoise";
                            case 4:
                                return "Electricblue";

                        }
                        break;
                }
                break;

            case 2:
                switch (G) {
                    case 0:
                        switch (B) {
                            case 0:
                                return "Falured";
                            case 1:
                                return "Disco";
                            case 2:
                                return "Discopurple";
                            case 3:
                                return "Seance";
                            case 4:
                                return "Electricvioletish";

                        }
                        break;

                    case 1:
                        switch (B) {
                            case 0:
                                return "Russet";
                            case 1:
                                return "Romancoffee";
                            case 2:
                                return "Canonpink";
                            case 3:
                                return "Studio";
                            case 4:
                                return "Mediumpurple";

                        }
                        break;

                    case 2:
                        switch (B) {
                            case 0:
                                return "Trendygreen";
                            case 1:
                                return "Shadow";
                            case 2:
                                return "Gray";
                            case 3:
                                return "Blueyonder";
                            case 4:
                                return "Mediumpurplish";

                        }
                        break;

                    case 3:
                        switch (B) {
                            case 0:
                                return "Warmlima";
                            case 1:
                                return "Chelseacucumber";
                            case 2:
                                return "Bayleaf";
                            case 3:
                                return "Gulfstream";
                            case 4:
                                return "Seagull";

                        }
                        break;

                    case 4:
                        switch (B) {
                            case 0:
                                return "Greenlima";
                            case 1:
                                return "Conifer";
                            case 2:
                                return "Pastelgreenish";
                            case 3:
                                return "Riptide";
                            case 4:
                                return "Electricriptide";

                        }
                        break;
                }
                break;

            case 3:
                switch (G) {
                    case 0:
                        switch (B) {
                            case 0:
                                return "Thunderbird";
                            case 1:
                                return "Maroonflush";
                            case 2:
                                return "Darkviolet";
                            case 3:
                                return "Eggplant";
                            case 4:
                                return "Electricviolet";

                        }
                        break;

                    case 1:
                        switch (B) {
                            case 0:
                                return "Fieryorange";
                            case 1:
                                return "Chestnut";
                            case 2:
                                return "Cadillac";
                            case 3:
                                return "Fuchsiapink";
                            case 4:
                                return "Purplish";

                        }
                        break;

                    case 2:
                        switch (B) {
                            case 0:
                                return "Mandalay";
                            case 1:
                                return "Driftwood";
                            case 2:
                                return "Brandyrose";
                            case 3:
                                return "Bouquet";
                            case 4:
                                return "Lavender";

                        }
                        break;

                    case 3:
                        switch (B) {
                            case 0:
                                return "Lucky";
                            case 1:
                                return "Olivegreen";
                            case 2:
                                return "Mongoose";
                            case 3:
                                return "Silverchalice";
                            case 4:
                                return "Coldpurple";

                        }
                        break;

                    case 4:
                        switch (B) {
                            case 0:
                                return "Inchworm";
                            case 1:
                                return "Conifergreen";
                            case 2:
                                return "Yellowgreen";
                            case 3:
                                return "Celadon";
                            case 4:
                                return "Powderblue";

                        }
                        break;
                }
                break;

            case 4:
                switch (G) {
                    case 0:
                        switch (B) {
                            case 0:
                                return "Alizcrimson";
                            case 1:
                                return "Amaranth";
                            case 2:
                                return "Redviolet";
                            case 3:
                                return "Violetred";
                            case 4:
                                return "Shockingpink";

                        }
                        break;

                    case 1:
                        switch (B) {
                            case 0:
                                return "Cinnabar";
                            case 1:
                                return "Mandy";
                            case 2:
                                return "Pinkmandy";
                            case 3:
                                return "Cerise";
                            case 4:
                                return "Orchid";

                        }
                        break;

                    case 2:
                        switch (B) {
                            case 0:
                                return "Zest";
                            case 1:
                                return "Burntsienna";
                            case 2:
                                return "Deepblush";
                            case 3:
                                return "Carissma";
                            case 4:
                                return "Lavendermagenta";

                        }
                        break;

                    case 3:
                        switch (B) {
                            case 0:
                                return "Goldtips";
                            case 1:
                                return "Anzac";
                            case 2:
                                return "Goldsand";
                            case 3:
                                return "Rosefog";
                            case 4:
                                return "Lightorchid";

                        }
                        break;

                    case 4:
                        switch (B) {
                            case 0:
                                return "Barberry";
                            case 1:
                                return "Confetti";
                            case 2:
                                return "Wildrice";
                            case 3:
                                return "Hampton";
                            case 4:
                                return "White";

                        }
                        break;
                }
                break;
        }

        return "error";

    }

    public WorldRegion recalculateAnimalSpecies(WorldRegion worldRegion) {

        for (AnimalSpecies animalSpecies : worldRegion.getAnimalSpeciesList()) {
            for (Animal animal : animalSpecies.getAnimals()) {
                reevaluateAnimalSpecies(animal);

                if (worldRegion.getAnimalSpeciesMap().containsKey(animal.getSpeciesCode())) {
                    worldRegion.getAnimalSpeciesMap().get(animal.getSpeciesCode()).getAnimals().add(animal);
                } else {

                    AnimalSpecies newAnimalSpecies = new AnimalSpecies();
                    List<Animal> newAnimalList = new ArrayList<Animal>();
                    newAnimalList.add(animal);
                    newAnimalSpecies.setAnimals(newAnimalList);

                    worldRegion.getAnimalSpeciesMap().put(animal.getSpeciesCode(), newAnimalSpecies);
                }
            }
        }

        return worldRegion;
    }

    private void reevaluateAnimalSpecies(Animal animal) {

        String speciesCode = calculateSpeciesCode(animal);

        if (animal.getSpeciesCode().equals(speciesCode)) {
            if(EvoLogger.loggingSpeciesChanges) System.out.println("Species are same");

            animal.setGenerationsInNewSpecies(0);
        } else if (animal.getGenerationsInNewSpecies() < 5) {
            animal.setGenerationsInNewSpecies(animal.getGenerationsInNewSpecies() + 1);
        } else {
            if(EvoLogger.loggingSpeciesChanges) System.out.println("Species change from " + animal.getSpeciesCode() + " to : " + speciesCode);

            animal.getEvolutionHistory().put(MainController.cyclesElapsed, speciesCode);
            animal.setSpeciesCode(speciesCode);
            animal.setGenerationsInNewSpecies(0);
        }
    }

    private String calculateSpeciesCode(Animal animal) {
        String speciesCode = "";

        int R = animal.getR();
        int G = animal.getG();
        int B = animal.getB();
        int Size = animal.getSize();
        int Claws = animal.getClaws();

        R = assignRank(R);
        G = assignRank(G);
        B = assignRank(B);
        Size = assignRank(Size);
        Claws = assignRank(Claws);

        speciesCode = speciesCode + R + G + B + Size + Claws;
        //    System.out.println(speciesCode);
        return speciesCode;
    }

    private int assignRank(int value) {
        if (value>255 || value<0) throw new IllegalArgumentException("Ranked attribute must be in 0-255 range");
        else return (int) value/51;
    }
}
