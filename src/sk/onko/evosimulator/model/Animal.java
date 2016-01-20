package sk.onko.evosimulator.model;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Animal {
    private int breedChance = 50;
    private int breedChanceWithoutPlague=50;

    public Animal() {
        this.setR(150);
        this.setG(150);
        this.setB(0);
    }

    //For copying
    public Animal(Animal animal) {
        this.R = animal.getR();
        this.G = animal.getG();
        this.B = animal.getB();
        this.breedChance = animal.getBreedChance();
        this.breedChanceWithoutPlague = animal.getBreedChanceWithoutPlague();
    }

    //RGB values of animals color (0-255)
    private int R;
    private int G;
    private int B;

    public int getR() {
        return R;
    }

    public void setR(int r) {
        if (r < 0) {
            R = 0;
        } else if (r > 255) {
            R = 255;
        } else
            R = r;
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        if (g < 0) {
            G = 0;
        } else if (g > 255) {
            G = 255;
        } else
            G = g;
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        if (b < 0) {
            B = 0;
        } else if (b > 255) {
            B = 255;
        } else
            B = b;
    }

    public int getBreedChance() {
        return breedChance;
    }

    public void setBreedChance(int breedChance) {
        this.breedChance = breedChance;
    }

    public int getBreedChanceWithoutPlague() {
        return breedChanceWithoutPlague;
    }

    public void setBreedChanceWithoutPlague(int breedChanceWithoutPlague) {
        this.breedChanceWithoutPlague = breedChanceWithoutPlague;
    }

}
