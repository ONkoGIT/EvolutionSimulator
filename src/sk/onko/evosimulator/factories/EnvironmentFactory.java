package sk.onko.evosimulator.factories;

import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.model.Environment;

import java.util.ArrayList;

/**
 * Created by ondrej.janosik on 20/01/2016.
 */
public class EnvironmentFactory {


    public static Environment getBasicEnvironment(){
        Environment environment = new Environment();
        environment.setR(100);
        environment.setG(200);
        environment.setB(255);
        return environment;


    }
}
