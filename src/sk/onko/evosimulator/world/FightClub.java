package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;

/**
 * Created by Ondrej on 6.2.2016.
 */
public class FightClub {
    FitnessCalculator fitnessCalculator = new FitnessCalculator();

    //TODO comparison between animals
    //TODO bonuses for colors, fur etc apply only once and at appropriate places
    public static boolean hunt(Animal hunter, Animal prey) {
        int hunterScore = 0;
        int preyScore = 0;

        hunterScore = 122 + prey.getClaws();
        preyScore = (int) (Math.random() * 255) + prey.getClaws();

        return hunterScore > preyScore;
    }
}
