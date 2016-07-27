package sk.onko.evosimulator.tests;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import sk.onko.evosimulator.factories.AnimalFactory;
import sk.onko.evosimulator.model.Animal;
import sk.onko.evosimulator.world.FitnessCalculator;

import static org.junit.Assert.*;

/**
 * Created by Ondrej on 23.7.2016.
 */
public class FitnessCalculatorTest {

    private Animal testElephant;
    private Animal testBear;
    private FitnessCalculator fitnessCalculator;

    @Before
    public void setUp() throws Exception {
        testElephant = AnimalFactory.getElephant();
        testBear = AnimalFactory.getGrizzlyBear();
        fitnessCalculator = new FitnessCalculator();
    }

    @Test
    public void calculateTemperatureBonusTest(){
        int elephantTemperatureBonus = fitnessCalculator.calculateTemperatureBonus(testElephant, 35);
        int bearTemperatureBonus = fitnessCalculator.calculateTemperatureBonus(testBear, 35);
        org.junit.Assert.assertTrue((elephantTemperatureBonus > bearTemperatureBonus));
    }

    @After
    public void tearDown() throws Exception {

    }
}