package sk.onko.evosimulator.model;

import java.util.Collection;

/**
 * Created by ondrej.janosik on 26/01/2016.
 */
public class Coordinates implements Comparable<Coordinates> {

    private int x;
    private int y;


    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (x != that.x) return false;
        return y == that.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


    @Override
    public int compareTo(Coordinates o) {

        if (getX() > o.getX()) return 1;
        else if (getY() > o.getY()) return 1;

        if (getX() < o.getX()) return -1;
        else if (getY() < o.getY()) return -1;

        else return 0;
    }
}
