package sk.onko.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ondrej on 15.1.2016.
 */
public class GraphMark extends JLabel {

   private int YfromBottom =0;

    public int getYfromBottom() {
        return YfromBottom;
    }

    public void setYfromBottom(int yfromBottom) {

        YfromBottom = yfromBottom*3;
        this.setBounds(this.getX(),getParent().getHeight()-YfromBottom,15,15);
    }

    public GraphMark() {
        this.setOpaque(true);
        this.setSize(15, 15);
        this.setVisible(true);
        this.setBackground(Color.BLUE);
    }
}
