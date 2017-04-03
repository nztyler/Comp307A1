import java.util.List;
import java.util.Scanner;

/**
 * Created by nztyler on 28/03/17.
 */
public class Main {

    // So I don't screw up later in the code writing the name of the file by hand
    public static final String TEST = "iris-test.txt";
    public static final String TRAINING = "iris-training.txt";
    public static final String DATA = "iris.data";
    public static final String NAMES = "iris.names";

    public static void main(String[] args) {

        // Reader readTestSet = new Reader(TEST);
        // Reader readTrainingSet = new Reader(TRAINING);

        if (args.length != 2) {
            System.out.println("Incorrect parameters");
        } else {
            Reader readTestSet = new Reader(args[0]);
            Reader readTrainingSet = new Reader(args[1]);
            List<Iris> testSet = readTestSet.getCollection();
            List<Iris> trainingSet = readTrainingSet.getCollection();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter a value for K...");
            int k = Integer.parseInt(scanner.next());
            System.out.println(k + " is K");
            KNearestNeighbour kNN = new KNearestNeighbour(testSet, trainingSet, k);
            kNN.classify();
        }
    }
}