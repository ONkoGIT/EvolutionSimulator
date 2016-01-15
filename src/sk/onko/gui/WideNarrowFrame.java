package sk.onko.gui;

import javax.swing.*;

/**
 * Created by ondrej.janosik on 15/01/2016.
 */
public class WideNarrowFrame extends JFrame {

    public JPanel p = new JPanel();

    public WideNarrowFrame(){

        this.setSize(1500,100);

        p.setSize(this.getSize());
        this.add(p);
    }

}
