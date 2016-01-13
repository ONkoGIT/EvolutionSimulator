package sk.onko.world;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class God {

    protected List<Animal> beings = new ArrayList<Animal>();
    protected Mutator mutator = new Mutator();
    protected Breeder breeder = new Breeder();
    protected Environment environment = new Environment();

    int averageAnimalR=0;
    int averageAnimalG=0;
    int averageAnimalB=0;

    JFrame f = new JFrame();
    JPanel p = new JPanel();
    JButton animalz = new JButton();


   public God() {

       makeSomeGUI();
       letThereBeBeings();
       startTimeCycle();



    }

    private void makeSomeGUI() {


        f.setLocation(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setResizable(false);
        f.setTitle("Traffic simulation");

         p.setSize(500,500);
          p.setLayout(null);
        p.setBackground(new Color(environment.getR(),environment.getG(),environment.getB()));
        f.add(p);

          animalz.setBounds(150,150,200,200);
           p.add(animalz);
         animalz.setVisible(true);

          p.setVisible(true);

        f.setVisible(true);
    }

    private void startTimeCycle() {
        int cyclesElapsed = 0;
        while(cyclesElapsed <= 100000){

            System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");

            beings = mutator.mutate(beings, environment);
            beings = breeder.breed(beings);

            //getting average colors of animals
            for (Animal animal : beings){
                averageAnimalR += animal.getR();
                averageAnimalG += animal.getG();
                averageAnimalB += animal.getB();
            }
            averageAnimalR/=beings.size();
            averageAnimalG/=beings.size();
            averageAnimalB/=beings.size();

            animalz.setBackground(new Color(averageAnimalR,averageAnimalG,averageAnimalB));






            System.out.println(" - - - Number of beings : " + beings.size() + " - - -");
            if (beings.size()>=1000 || beings.size()<=0){
                System.out.println(" - - - Number of beings : " + beings.size() + " - TOO HIGH/LOW. SIMULATION ENDING.");
                cyclesElapsed=999999999;

            }

            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }


            cyclesElapsed++;

        }
    }

    private void letThereBeBeings() {
        for(int i=0; i<100 ; i++){
            beings.add(new Animal());
        }

        System.out.println(beings.size());
    }




}
