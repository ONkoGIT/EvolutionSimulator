package sk.onko.world;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Breeder {

    public List<Animal> breed (List<Animal> animals){

        List<Animal> newAnimals = new ArrayList<Animal>();

        boolean plagueOn = false;
        boolean megaPlagueOn = false;
        boolean absolutePlagueOn = false;

        if (animals.size()>400) {
            plagueOn=true;
            System.out.println("- - - Plague is on - - -");
        }

        if (animals.size()>500) {
            megaPlagueOn=true;
            System.out.println("- - - MEGAPlague is on - - -");
        }

        if (animals.size()>600) {
            megaPlagueOn=true;
            System.out.println("- - - ABSOLUTE PLAGUE is on - - -");
        }
        for (Animal animal : animals) {

            if (plagueOn ){
                animal.setBreedChance(animal.getBreedChance()-5);
            }

            if (megaPlagueOn ){
                animal.setBreedChance(animal.getBreedChance()-15);
            }

            if (absolutePlagueOn ){
                animal.setBreedChance(animal.getBreedChance()-50);
            }







            if (animal.getBreedChance() >= 100) {


                int numberOfBirthedAnimals = animal.getBreedChance()/100;

                for (int i=0; i<numberOfBirthedAnimals;i++){
                    //Creates a copy of birthing animal
                    newAnimals.add(new Animal(animal));
                }

                if (Math.random()*100<= animal.getBreedChance()%100){
                    newAnimals.add(new Animal(animal));
                }

            } else if (Math.random()*100<= animal.getBreedChance()%100){
                newAnimals.add(new Animal(animal));
            }

        }

        return newAnimals;
    }


}
