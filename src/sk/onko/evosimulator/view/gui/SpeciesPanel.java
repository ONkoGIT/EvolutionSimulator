package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;

/**
 * Created by Ondrej on 6.2.2016.
 */

//TODO: Add to RegionPanel
public class SpeciesPanel extends JPanel implements UpdateableView{

    private JLabel nameAndNumberLabel = new JLabel("Species name");
    private JLabel averageColorLabel = new JLabel("Color:");
    private JLabel averageColorSquareLabel = new JLabel();
    private JLabel statsLabel = new JLabel();


    public SpeciesPanel() {
        this.setBorder( BorderFactory.createEtchedBorder(EtchedBorder.RAISED));

        this.setOpaque(true);
        this.setBackground(Color.DARK_GRAY);
        this.setLayout(null);



        nameAndNumberLabel.setForeground(Color.WHITE);
        nameAndNumberLabel.setBounds(10,0,200,20);
        this.add(nameAndNumberLabel);


        //nameAndNumberLabel.setBounds();
        averageColorLabel.setForeground(Color.WHITE);
        averageColorSquareLabel.setForeground(Color.WHITE);

        statsLabel.setForeground(Color.WHITE);
        statsLabel.setBounds(10, 20,200,20);
        this.add(statsLabel);

        averageColorSquareLabel.setOpaque(true);
        averageColorSquareLabel.setBounds(150,10,30,30);
        this.add(averageColorSquareLabel);

        this.setVisible(true);


    }

    public JLabel getNameAndNumberLabel() {
        return nameAndNumberLabel;
    }

    public void setNameAndNumberLabel(JLabel nameAndNumberLabel) {
        this.nameAndNumberLabel = nameAndNumberLabel;
    }

    public JLabel getAverageColorLabel() {
        return averageColorLabel;
    }

    public void setAverageColorLabel(JLabel averageColorLabel) {
        this.averageColorLabel = averageColorLabel;
    }

    public JLabel getAverageColorSquareLabel() {
        return averageColorSquareLabel;
    }

    public void setAverageColorSquareLabel(JLabel averageColorSquareLabel) {
        this.averageColorSquareLabel = averageColorSquareLabel;
    }

    public JLabel getStatsLabel() {
        return statsLabel;
    }

    public void setStatsLabel(JLabel statsLabel) {
        this.statsLabel = statsLabel;
    }

    @Override
    public void updateView(MainModel model) {



    }
}
