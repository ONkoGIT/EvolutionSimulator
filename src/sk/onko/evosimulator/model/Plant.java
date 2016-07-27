package sk.onko.evosimulator.model;

/**
 * Created by Ondrej on 23.1.2016.
 */
public class Plant {

    //Nutrients of plant. Animals must have their digestive
    //system nubers as close to these as possible
    private int Roozyne;
    private int Gloozane;
    private int Bloozene;

    public Plant() {

    }

    //TODO clone constructor
    public Plant(Plant plant) {

    }

    public int getBloozene() {
        return Bloozene;
    }

    public void setBloozene(int bloozene) {
        Bloozene = bloozene;
    }

    public int getRoozyne() {
        return Roozyne;
    }

    public void setRoozyne(int roozyne) {
        Roozyne = roozyne;
    }

    public int getGloozane() {
        return Gloozane;
    }

    public void setGloozane(int gloozane) {
        Gloozane = gloozane;
    }
}
