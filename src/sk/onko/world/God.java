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

    JLabel generationNumberLabel = new JLabel();
    JLabel plagueLabel = new JLabel();
    JLabel populationLabel = new JLabel();


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
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
        animalzGenMinus30.setText("G-30");
        p.add(animalzGenMinus30);
        animalzGenMinus30.setVisible(true);

        animalzGenMinus60.setBounds(50, 150, 80, 80);
        animalzGenMinus60.setText("G-60");
        p.add(animalzGenMinus60);
        animalzGenMinus60.setVisible(true);

        generationNumberLabel.setText("Generation");
        generationNumberLabel.setBounds(300, 400, 200, 30);
        p.add(generationNumberLabel);


        plagueLabel.setText("Environment is friendly.");
        plagueLabel.setBounds(50, 50, 250, 30);
        p.add(plagueLabel);
        plagueLabel.setVisible(true);

        populationLabel.setText("Population :");
        populationLabel.setBounds(300, 430, 250, 30);
        p.add(populationLabel);
        populationLabel.setVisible(true);

        p.setVisible(true);
        f.setVisible(true);

        f2.setLocation(200, 100);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f2.setSize(1500, 100);
        f2.setResizable(false);
        f2.setTitle("Color view of every animal");

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

            populationLabel.setText("Population : " + beings.size());

            switch (breeder.plagueLevel) {

                case 1:
                    plagueLabel.setText("<html><font color=red>Plague level 1 in the world </font></html>");
                    break;
                case 2:
                    plagueLabel.setText("<html><font color=red>Plague level 2 in the world </font></html>");
                    break;
                case 3:
                    plagueLabel.setText("<html><font color=red>Plague level 3 in the world </font></html>");
                    break;
                default:
                    plagueLabel.setText("Environment is friendly.");

            }


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

            if (colorList.size() >= 60) {
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
            generationNumberLabel.setText("Generation " + cyclesElapsed);

        }
    }

    private void letThereBeBeings() {
        for (int i = 0; i < 100; i++) {
            beings.add(new Animal());
        }

        System.out.println(beings.size());
    }


}
