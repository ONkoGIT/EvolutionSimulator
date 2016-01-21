package sk.onko.evosimulator.view.gui;

import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.MainModel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class GraphPanel extends JPanel implements UpdateableView {

    java.util.List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    public GraphPanel() {
        setSize(1500, 600);
        setLayout(null);
        setBackground(new Color(255, 255, 255));
        setVisible(true);

        for (int i = 0; i < 50; i++) {
            graphMarks.add(new GraphMark());

            graphMarks.get(i).setBounds(i * 25, (270 - graphMarks.get(i).getY()), 15, 15);
            add(graphMarks.get(i));
        }

    }

    public void updateView(MainModel model) {

        int sizeOfAllAverageColors = model.getAllAverageColors().size();
        java.util.List<Color> allAverageColors = model.getAllAverageColors();

        int positionOfGraphMarker = 0;

        for (GraphMark graphMark : graphMarks) {
            graphMark.setBackground(allAverageColors.get((positionOfGraphMarker * (sizeOfAllAverageColors / graphMarks.size()))));
            graphMark.setYfromBottom(model.getAverageBreedChances().get((positionOfGraphMarker * (model.getAverageBreedChances().size() / graphMarks.size()))));


            positionOfGraphMarker++;
        }
        this.repaint();

    }

}
