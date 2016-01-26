package sk.onko.evosimulator.view;

import sk.onko.evosimulator.factories.FrameFactory;
import sk.onko.evosimulator.gui.GraphMark;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.view.gui.*;

import javax.swing.*;
import java.util.*;

/**
 * Created by ondrej.janosik on 19/01/2016.
 */
public class MainView implements UpdateableView {

    FrameFactory frameFactory = new FrameFactory();
    List<GraphMark> graphMarks = new ArrayList<GraphMark>();

    JFrame mainFrame;
    JFrame allAnimalColorsFrame;
    JFrame allAverageColorsFrame;
    JFrame trendGraphFrame;
    JFrame mapFrame;

    //TODO Somehow use interfaces for these components
    MainPanel mainPanel = new MainPanel();
    GraphPanel trendGraphPanel = new GraphPanel();
    AllAnimalColorsPanel allAnimalColorsPanel = new AllAnimalColorsPanel();
    AverageColorsPanel allAverageColorsPanel = new AverageColorsPanel();
    MapPanel mapPanel;

    public MainView(MainModel model) {
        createView(model);
    }

    private void createView(MainModel model) {

        mainFrame = frameFactory.getMainFrame();
        mainFrame.add(mainPanel);

        trendGraphFrame = frameFactory.getTrendGraphFrame();
        trendGraphFrame.add(trendGraphPanel);

        allAnimalColorsFrame = frameFactory.getAllAnimalColorsFrame();
        allAnimalColorsFrame.add(allAnimalColorsPanel);

        allAverageColorsFrame = frameFactory.getAllAverageColorsFrame();
        allAverageColorsFrame.add(allAverageColorsPanel);

        mapFrame= frameFactory.getMapFrame();
        mapPanel = new MapPanel(model);
        mapFrame.add(mapPanel);

    }

    @Override
    public void updateView(MainModel model) {

        mainPanel.updateView(model);

        allAnimalColorsPanel.updateView(model);

        allAverageColorsPanel.updateView(model);

        mapPanel.updateView(model);

        int cyclesElapsed = model.getCyclesElapsed();

        if (cyclesElapsed % 50 == 0) {
              trendGraphPanel.updateView(model);
        }

    }

}
