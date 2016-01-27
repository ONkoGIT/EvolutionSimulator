package sk.onko.evosimulator.model;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Animal {
    //RGB values of animals color (0-255)
    private int R;
    private int G;
    private int B;

    private int breedChance = 50;
    private int breedChanceWithoutPlague = 50;
    private int furLevel = 130;

    //TODO change default herbivore
    private int carnivoreRatio = 0;
    private int herbivoreRatio = 100;

    public Animal() {
        this.setR(150);
        this.setG(150);
        this.setB(0);
    }

    //For copying animals , when breeding
    public Animal(Animal animal) {
        this.R = animal.getR();
        this.G = animal.getG();
        this.B = animal.getB();
        this.breedChance = animal.getBreedChance();
        this.breedChanceWithoutPlague = animal.getBreedChanceWithoutPlague();
        this.furLevel = animal.getFurLevel();
        this.herbivoreRatio=animal.getHerbivoreRatio();
        this.carnivoreRatio=animal.getCarnivoreRatio();
    }


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

    public int getFurLevel() {
        return furLevel;
    }

    public void setFurLevel(int furLevel) {
        this.furLevel = furLevel;
    }

    public int getCarnivoreRatio() {
        return carnivoreRatio;
    }

    public void setCarnivoreRatio(int carnivoreRatio) {
        if (carnivoreRatio >= 100) {
            this.carnivoreRatio = 100;
        } else
            this.carnivoreRatio = carnivoreRatio;

        this.herbivoreRatio = 100 - carnivoreRatio;

    }

    public int getHerbivoreRatio() {
        return herbivoreRatio;
    }

    public void setHerbivoreRatio(int herbivoreRatio) {
        if (herbivoreRatio >= 100) {
            this.herbivoreRatio = 100;
        } else
            this.herbivoreRatio = herbivoreRatio;

        this.carnivoreRatio = 100 - herbivoreRatio;
    }

    //TODO - validation function for setters
}
