package main;

import Classifier.Reader;
import Classifier.Iris;
import Classifier.KNearestNeighbour;
import java.util.List;
/**
 * Created by nztyler on 28/03/17.
 * Hey bro, happy birthday! I hope youve had a good one and it hasnt been
 * entirely stress from uni. If my classes and are stressful already then I cant
 * imagine how an archie feels.... anyway hope its been good :) catch ya later bro
 *
 */
public class Main {

    // So I don't screw up later in the code writing the name of the file by hand
    public static final String TEST = "iris-test.txt";
    public static final String TRAINING = "iris-training.txt";
    public static final String DATA = "iris.data";
    public static final String NAMES = "iris.names";

    private static int k = 3;

    public static void main(String[] args) {

        Reader readTestSet = new Reader(TEST);
        Reader readTrainingSet = new Reader(TRAINING);

        List<Iris> testSet = readTestSet.getCollection();
        List<Iris> trainingSet = readTrainingSet.getCollection();

        KNearestNeighbour kNN = new KNearestNeighbour(testSet, trainingSet, k);
        kNN.classify();

        if (args.length == 2) {
            // do the thing
        }
    }
}