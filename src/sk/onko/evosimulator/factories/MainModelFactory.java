package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.*;

import java.util.*;
import java.util.List;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class MainModelFactory {
    private WorldRegionFactory regionFactory = new WorldRegionFactory();
    private SpeciesFactory speciesFactory = new SpeciesFactory();
    private int mapWidth = 3;
    private int mapHeight = 3;

    public MainModel getBasicMainModel() {

        MainModel mainModel = new MainModel();

        mainModel.setMapWidth(mapWidth);
        mainModel.setMapHeight(mapHeight);

        //TODO evaluate collection type
        Map<Coordinates, WorldRegion> worldRegionMap = new HashMap<Coordinates, WorldRegion>();

        for (int x = 0; x <= (mapWidth - 1); x++) {
            for (int y = 0; y <= (mapHeight - 1); y++) {

                WorldRegion currentRegion = regionFactory.getRandomRegion();

                //Generating animals
                List<AnimalSpecies> animalSpeciesList = new ArrayList<AnimalSpecies>();

                for (int populationNumber = 0; populationNumber < 1; populationNumber++) {
                    AnimalSpecies animalSpecies = new AnimalSpecies();

                    List<Animal> animalList = new ArrayList<>();

                    animalSpecies.setSpeciesName("Defaultoid");


                    for (int i = 0; i < 20; i++) {
                        Animal animal = new Animal();
                        animal.setR(80);
                        animal.setG(200);
                        animal.setB(50);

                        animalList.add(animal);

                    }
                    System.out.println("Animals created : " + animalList.size());


                    animalSpecies.setAnimals(animalList);
                    animalSpeciesList.add(animalSpecies);

                }
                currentRegion.setAnimalSpeciesList(animalSpeciesList);

                //Generating plants
                List<PlantSpecies> plantSpeciesList = new ArrayList<PlantSpecies>();

                for (int plantSpeciesNumber = 0; plantSpeciesNumber < 1; plantSpeciesNumber++) {
                    PlantSpecies plantSpecies = new PlantSpecies();

                    List<Plant> plantList = new ArrayList<>();

                    for (int i = 0; i < 20; i++) {
                        Plant plant = new Plant();

                        plantList.add(plant);
                    }

                    plantSpecies.setPlants(plantList);
                    plantSpeciesList.add(plantSpecies);

                }

                currentRegion.setPlantSpeciesList(plantSpeciesList);

                worldRegionMap.put(new Coordinates(x, y), currentRegion);

            }
        }

        mainModel.setWorldRegionMap(worldRegionMap);

        return mainModel;
    }
}
