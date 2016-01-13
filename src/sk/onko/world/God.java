package sk.onko.world;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
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

    int averageAnimalR = 0;
    int averageAnimalG = 0;
    int averageAnimalB = 0;

    int averageAnimalRGenMinus30 = 0;
    int averageAnimalGGenMinus30 = 0;
    int averageAnimalBGenMinus30 = 0;

    List<Color> colorList = new ArrayList<Color>();


    JFrame f = new JFrame();
    JFrame f2 = new JFrame();

    JPanel p = new JPanel();
    JPanel p2 = new JPanel();

    JButton animalzCurrent = new JButton();
    JButton animalzGenMinus30 = new JButton();
    JButton animalzGenMinus60 = new JButton();


    public God() {

        makeSomeGUI();
        letThereBeBeings();
        startTimeCycle();


    }

    private void makeSomeGUI() {


        f.setLocation(200, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setResizable(false);
        f.setTitle("Evolution simulation");

        p.setSize(500, 500);
        p.setLayout(null);
        p.setBackground(new Color(environment.getR(), environment.getG(), environment.getB()));
        f.add(p);

        animalzCurrent.setBounds(250, 150, 200, 200);
        animalzCurrent.setText("Average color of animals");
        p.add(animalzCurrent);
        animalzCurrent.setVisible(true);

        animalzGenMinus30.setBounds(140, 150, 100, 100);
        animalzGenMinus30.setText("T-30");
        p.add(animalzGenMinus30);
        animalzGenMinus30.setVisible(true);

        animalzGenMinus60.setBounds(50, 150, 80, 80);
        animalzGenMinus60.setText("T-60");
        p.add(animalzGenMinus60);
        animalzGenMinus60.setVisible(true);


        p.setVisible(true);
        f.setVisible(true);

        f2.setLocation(200, 200);
        f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f2.setSize(1500, 100);
        f2.setResizable(false);
        f2.setTitle("Evolution simulation");

        p2.setSize(1500, 100);
        p2.setLayout(null);
        f2.add(p2);

        p2.setBackground(new Color(0, 0, 0));
        p2.setVisible(true);
        f2.setVisible(true);

    }

    private void startTimeCycle() {
        int cyclesElapsed = 0;

        while (cyclesElapsed <= 100000) {

            System.out.println(" - - - Starting time cycle number " + cyclesElapsed + " - - -");

            beings = mutator.mutate(beings, environment);
            beings = breeder.breed(beings);

            int position = 0;
            p2.removeAll();

            //getting average colors of animals
            for (Animal animal : beings) {

                averageAnimalR += animal.getR();
                averageAnimalG += animal.getG();
                averageAnimalB += animal.getB();


                // JButton animalColorLabel = new JButton();
                JLabel animalColorLabel = new JLabel();
                animalColorLabel.setOpaque(true);

                int x_pos = ((1000 / beings.size()) * position);
                animalColorLabel.setBounds(x_pos, 0, (1500 / beings.size()), 100);

                int redColor = animal.getR();
                int greenColor = animal.getG();
                int blueColor = animal.getB();

                animalColorLabel.setBackground(new Color(redColor, greenColor, blueColor));

                p2.add(animalColorLabel);
                animalColorLabel.setVisible(true);
                position++;

            }

            p2.repaint();


            System.out.println(" - - - Number of beings : " + beings.size() + " - - -");
            if (beings.size() >= 1000 || beings.size() <= 0) {
                System.out.println(" - - - Number of beings : " + beings.size() + " - TOO HIGH/LOW. SIMULATION ENDING.");
                cyclesElapsed = 999999999;

            }

            averageAnimalR /= beings.size();
            averageAnimalG /= beings.size();
            averageAnimalB /= beings.size();

            if (colorList.size() < 60) {
                colorList.add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
                animalzGenMinus30.setBackground(colorList.get(0));
                animalzGenMinus60.setBackground(colorList.get(0));
            }

            if (colorList.size()>=60){
                colorList.add(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
                animalzGenMinus30.setBackground(colorList.get(30));
                animalzGenMinus60.setBackground(colorList.get(0));
                colorList.remove(0);
            }

            try {
                animalzCurrent.setBackground(new Color(averageAnimalR, averageAnimalG, averageAnimalB));
            } catch (IllegalArgumentException e) {

                System.out.println("Error trying to set color to :" + averageAnimalR + " " + averageAnimalG + " " + averageAnimalB);
                System.out.println("Size of beings list is  :" + beings.size());
                e.printStackTrace();

            }


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            cyclesElapsed++;

        }
    }

    private void letThereBeBeings() {
        for (int i = 0; i < 100; i++) {
            beings.add(new Animal());
        }

        System.out.println(beings.size());
    }


}
