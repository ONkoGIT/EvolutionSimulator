package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.WorldRegion;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class BreedChanceCalculator {

    private FightClub fightClub = new FightClub();


    public int calculateBreedChance(Animal animal, WorldRegion region) {

        // Zero or negative value means animal is dead (by hunt for example)
        if (animal.getBreedChance() <= 0) {
            return 0;
        }

        int newBreedChance = 0;

        newBreedChance += getEnvironmentBonus(animal, region);

        //TODO eating of plants

        //Will it decide to eat plants ?
        if ((Math.random() * 100) <= animal.getHerbivoreRatio()) {

            //Can it find a plant to eat ?
            if (!region.getPlantSpeciesList().isEmpty() && !region.getPlantSpeciesList().get(0).getPlants().isEmpty()) {
                region.getPlantSpeciesList().get(0).getPlants().remove(0);

                //Eats plant successfully = becomes more herbivorous
                animal.setHerbivoreRatio(animal.getHerbivoreRatio() + 1);
            } else {
                newBreedChance = newBreedChance / 2;
                System.out.println("Not enough plants in the region");
                animal.setCarnivoreRatio(animal.getCarnivoreRatio() + 1);
            }

        } else {


            //TODO : Hunting, high priority, since this is bullshit now - everyone eats the second species

            //Can it find any pray in the region ? From other species
            if (!region.getAnimalSpeciesList().isEmpty() && !region.getAnimalSpeciesList().get(1).getAnimals().isEmpty()) {
                //Can it hunt the prey successfully ?

                Animal prey = region.getAnimalSpeciesList().get(1).getAnimals().get(0);
                if (fightClub.hunt(animal, prey)) {
                    // region.getAnimalSpeciesList().get(1).getAnimals().remove(0);

                    //Instead of removing from list, set the prey's breedChance to -1
                    region.getAnimalSpeciesList().get(1).getAnimals().get(0).setBreedChance(-1);

                    //Eats animal successfully = becomes more carnivorous
                    animal.setCarnivoreRatio(animal.getCarnivoreRatio() + 1);
                    //System.out.println("Hunt successful");
                } else {
                    newBreedChance = newBreedChance / 2;
                    System.out.println("Hunt not successful");
                    animal.setHerbivoreRatio(animal.getHerbivoreRatio() + 1);

                }

            } else {

                newBreedChance = newBreedChance / 2;
                System.out.println("No prey found");


            }

        }

        //   System.out.println("Breedchance " + newBreedChance);
        return newBreedChance;

    }

    private int getEnvironmentBonus(Animal animal, WorldRegion region) {
        int environmentBonus = 0;

        //color bonus
        int deltaR = Math.abs(animal.getR() - region.getColor().getRed());
        int deltaG = Math.abs(animal.getG() - region.getColor().getGreen());
        int deltaB = Math.abs(animal.getB() - region.getColor().getBlue());

        environmentBonus += (442 - Math.sqrt(Math.pow((Math.sqrt(Math.pow(deltaR, 2) + Math.pow(deltaG, 2))), 2) + Math.pow(deltaB, 2))) / 4.41;
        // System.out.println("Environment bonus = " + (442 - Math.sqrt(Math.pow((Math.sqrt(Math.pow(255, 2) + Math.pow(255, 2))), 2) + Math.pow(255, 2))) / 4.41);
        //   environmentBonus += (550 - (Math.abs(animal.getR() - region.getColor().getRed())) - (Math.abs(animal.getG() - region.getColor().getGreen())) - (Math.abs(animal.getB() - region.getColor().getBlue()))) / 7;

        //temperature bonus TODO test, optimize, etc
        //optimal line calculated by optimalTemperature= 50 + (-0.235 * fur)
        //You know, y = a + bx

        int optimalTemperatureForFur = (50 + ((int) (-0.235 * animal.getFurLevel())));
        int temperatureBonus = Math.abs(optimalTemperatureForFur - region.getTemperature());
        temperatureBonus = Math.abs(100 - temperatureBonus);

        environmentBonus += temperatureBonus;

        return environmentBonus;
    }
}
