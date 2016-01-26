package sk.onko.evosimulator.factories;

import javax.swing.*;

/**
 * Created by Ondrej on 21.1.2016.
 */
public class FrameFactory {

    public JFrame getMainFrame(){
        JFrame mainFrame = new JFrame();
        mainFrame.setLocation(200, 200);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 500);
        mainFrame.setResizable(false);
        mainFrame.setTitle("VIEW - Evolution simulation");
       // mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
        return mainFrame;

    }

    public JFrame getTrendGraphFrame(){
        JFrame trendGraphFrame = new JFrame();
        trendGraphFrame.setLocation(200, 100);
        trendGraphFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        trendGraphFrame.setSize(1500, 600);
        trendGraphFrame.setResizable(false);
        trendGraphFrame.setTitle("VIEW - Color evolution trend ");
       // trendGraphFrame.add(trendGraphPanel);
        trendGraphFrame.setVisible(true);
        return trendGraphFrame;
    }


    public JFrame getAllAnimalColorsFrame(){
        JFrame allAnimalColorsFrame = new JFrame();
        allAnimalColorsFrame.setLocation(200, 100);
        allAnimalColorsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        allAnimalColorsFrame.setSize(1500, 100);
        allAnimalColorsFrame.setResizable(false);
        allAnimalColorsFrame.setTitle("VIEW - Color view of every animal");
       // allAnimalColorsFrame.add(allAnimalColorsPanel);
        allAnimalColorsFrame.setVisible(true);
        return  allAnimalColorsFrame;
    }

    public JFrame getAllAverageColorsFrame(){
        JFrame allAverageColorsFrame = new JFrame();
        allAverageColorsFrame.setLocation(200, 100);
        allAverageColorsFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        allAverageColorsFrame.setSize(1500, 100);
        allAverageColorsFrame.setResizable(false);
        allAverageColorsFrame.setTitle("VIEW - Color evolution trend ");
        //allAverageColorsFrame.add(allAverageColorsPanel);
        allAverageColorsFrame.setVisible(true);
        return  allAverageColorsFrame;
    }

    public JFrame getMapFrame(){
        JFrame mapFrame = new JFrame();
        mapFrame.setLocation(200, 100);
        mapFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mapFrame.setSize(1200, 1200);
        mapFrame.setResizable(false);
        mapFrame.setTitle("Map");
        //allAverageColorsFrame.add(allAverageColorsPanel);
        mapFrame.setVisible(true);
        return  mapFrame;
    }


}
