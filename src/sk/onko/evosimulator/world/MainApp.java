package sk.onko.evosimulator.world;


import sk.onko.evosimulator.controller.MainController;
import sk.onko.evosimulator.model.MainModel;
import sk.onko.evosimulator.view.MainView;

/**
 * Created by Ondrej on 12.1.2016.
 */
public class MainApp {

    public static void main(String[]args){

        new MainController(new MainModel(),new MainView());

    }



}
