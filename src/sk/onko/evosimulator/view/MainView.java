package sk.onko.evosimulator.view;

import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.view.gui.*;

import javax.swing.*;
import java.util.*;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainView implements UpdateableView {

    java.util.List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    //TODO move creation of frames somewhere else
    JFrame f = new JFrame();
    JFrame f2 = new JFrame();
    JFrame f3 = new JFrame();
    JFrame f4 = new JFrame();

    //TODO Somehow use interfaces for these components
    MainPanel mainPanel = new MainPanel();
    GraphPanel graphPanel = new GraphPanel();
    AllAnimalColorsPanel allAnimalColorsPanel = new AllAnimalColorsPanel();
    AverageColorsPanel averageColorsPanel = new AverageColorsPanel();

    public MainView() {
        createView();
    }

    private void createView() {
        f.setLocation(200, 200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setResizable(false);
        f.setTitle("VIEW - Evolution simulation");
        f.add(mainPanel);
        f.setVisible(true);

        f2.setLocation(200, 100);
        f2.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f2.setSize(1500, 100);
        f2.setResizable(false);
        f2.setTitle("VIEW - Color view of every animal");
        f2.add(allAnimalColorsPanel);
        f2.setVisible(true);

        f3.setLocation(200, 100);
        f3.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f3.setSize(1500, 100);
        f3.setResizable(false);
        f3.setTitle("VIEW - Color evolution trend ");
        f3.add(averageColorsPanel);
        f3.setVisible(true);

        f4.setLocation(200, 100);
        f4.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f4.setSize(1500, 600);
        f4.setResizable(false);
        f4.setTitle("VIEW - Color evolution trend ");
        f4.add(graphPanel);
        f4.setVisible(true);

    }

    @Override
    public void updateView(MainModel model) {

        mainPanel.updateView(model);

        allAnimalColorsPanel.updateView(model);

        averageColorsPanel.updateView(model);

        int cyclesElapsed = model.getCyclesElapsed();

        if (cyclesElapsed % 50 == 0) {
              graphPanel.updateView(model);
        }

    }

}
