package sk.onko.evosimulator.world;

import sk.onko.evosimulator.model.Animal;

/**
 * Created by Ondrej on 6.2.2016.
 */
public class FightClub {

    //TODO comparison between animals
    public static boolean hunt(Animal hunter, Animal prey) {

        int hunterScore = 122 + prey.getClaws();
        int preyScore = (int) (Math.random() * 255) + prey.getClaws();

        if (hunterScore > preyScore) {
            return true;
        } else
            return false;


    }
}
