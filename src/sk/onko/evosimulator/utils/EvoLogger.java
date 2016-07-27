package sk.onko.evosimulator.utils;

/**
 * Created by Ondrej on 22.7.2016.
 */
public class EvoLogger {
    public static boolean loggingSpeciesChanges = false;
    public static boolean loggingCycleNumbers = false;
    public static boolean loggingWorldPopulation = false;
    public static boolean loggingPlagueLevels = false;
    public static boolean loggingTimePassedForCycleNumber = false;
    public static boolean loggingStatisticsAfterEnd = true;

    public static void logStatisticsAfterEnd(){
        System.out.println("Number of mutations: " + EvoStatistics.numOfMutations);
        System.out.println("Number of animals eaten: " + EvoStatistics.numOfAnimalsEaten);
        System.out.println("Number of plants eaten: " + EvoStatistics.numOfPlantsEaten);
    }
}
