package sk.onko.world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Breeder {

    public int plagueLevel = 0;

    public List<Animal> breed(List<Animal> animals) {

        plagueLevel = 0;

        List<Animal> newAnimals = new ArrayList<Animal>();

        if (animals.size() >= 400 && animals.size() < 500) {

            plagueLevel = 1;

            System.out.println("- - - Plague level 1 - - -");
        } else if (animals.size() >= 500 && animals.size() < 600) {
            plagueLevel = 2;
            System.out.println("- - - Plague level 2 - - -");
        } else if (animals.size() >= 600) {
            plagueLevel = 3;
            System.out.println("- - - Plague level 3 - - -");
        }

        for (Animal animal : animals) {

            switch (plagueLevel) {
                case (1):
                    animal.setBreedChance(animal.getBreedChance() - 5);
                    break;
                case (2):
                    animal.setBreedChance(animal.getBreedChance() - 15);
                    break;
                case (3):
                    animal.setBreedChance(animal.getBreedChance() - 30);
                    break;
                default:
            }


            if (animal.getBreedChance() >= 100) {


                int numberOfBirthedAnimals = animal.getBreedChance() / 100;

                for (int i = 0; i < numberOfBirthedAnimals; i++) {
                    //Creates a copy of birthing animal
                    newAnimals.add(new Animal(animal));
                }

                if (Math.random() * 100 <= animal.getBreedChance() % 100) {
                    newAnimals.add(new Animal(animal));
                }

            } else if (Math.random() * 100 <= animal.getBreedChance() % 100) {
                newAnimals.add(new Animal(animal));
            }

        }

        return newAnimals;
    }


}
