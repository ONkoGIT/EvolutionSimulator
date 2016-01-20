package sk.onko.evosimulator.model;

import java.awt.*;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class Environment {

    //Affects breeding chances
    private int plagueLevel;

    //RGB values of environment color (0-255)
    private int R;
    private int G;
    private int B;

    private Color color;

    public int getR() {
        return R;
    }

    public void setR(int r) {
        R = r;
        setColor(new Color(getR(),getG(),getB()));
    }

    public int getG() {
        return G;
    }

    public void setG(int g) {
        G = g;
        setColor(new Color(getR(),getG(),getB()));
    }

    public int getB() {
        return B;
    }

    public void setB(int b) {
        B = b;
        setColor(new Color(getR(),getG(),getB()));
    }

    public int getPlagueLevel() {
        return plagueLevel;
    }

    public void setPlagueLevel(int plagueLevel) {
        this.plagueLevel = plagueLevel;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
