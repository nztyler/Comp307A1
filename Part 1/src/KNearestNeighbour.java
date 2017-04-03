import java.util.List;
import java.util.ArrayList;

/**
 * Created by nztyler on 28/03/17.
 */
public class KNearestNeighbour {

    private List<Iris> trainingSet;
    private List<Iris> testSet;
    private int k;

    private double sepalLengthRange;
    private double sepalWidthRange;
    private double petalLengthRange;
    private double petalWidthRange;

    public KNearestNeighbour(List<Iris> trainingSet, List<Iris> testSet, int k) {
        this.trainingSet = trainingSet;
        this.testSet = testSet;
        this.k = k;

        // Set the ranges

        double maxSL = 0;
        double minSL = Double.MAX_VALUE;
        double maxSW = 0;
        double minSW = Double.MAX_VALUE;
        double maxPL = 0;
        double minPL = Double.MAX_VALUE;
        double maxPW = 0;
        double minPW = Double.MAX_VALUE;

        for (Iris iris : trainingSet) {
            maxSL = Math.max(maxSL, iris.getSepalLength());
            minSL = Math.min(minSL, iris.getSepalLength());
            maxSW = Math.max(maxSW, iris.getSepalWidth());
            minSW = Math.min(minSW, iris.getSepalWidth());
            maxPL = Math.max(maxPL, iris.getPetalLength());
            minPL = Math.min(minPL, iris.getPetalLength());
            maxPW = Math.max(maxPW, iris.getPetalWidth());
            minPW = Math.min(minPW, iris.getPetalWidth());
        }

        sepalLengthRange = maxSL - minSL;
        sepalWidthRange = maxSW - minSW;
        petalLengthRange = maxPL - minPL;
        petalWidthRange = maxPW - minPL;
    }

    public void classify() {
        /*
        find the closest K amount of neighbour from the training set
        start a count based on the type of the closest Iris'
        assign the predicted type to the Iris
        check if it is correct
        print the result
        */
        int correctCounter = 0;

        for (Iris testIris : testSet) {
            List<Iris> closest = new ArrayList<Iris>();
            for (Iris trainingIris : trainingSet) {
                for (int i = 0; i <= closest.size(); i++) {
                    // if this distance to the one before
                    if (i == closest.size()) { // past the last used item in the list -> add it next
                        closest.add(trainingIris);
                        i = closest.size() + 1;
                    } else {
                        if (distanceTo(closest.get(i), testIris) > distanceTo(trainingIris, testIris)) {
                            closest.add(i, trainingIris);
                            i = closest.size() + 1; //break out of the loop
                        }
                    }
                }
            }
            testIris.setNeighbours(closest);

            int setosaCount = 0;
            int versicolorCount = 0;
            int virginicaCount = 0;
            for (int i = 0; i < k; i++) {
                switch(testIris.getNeighbours().get(i).getClassName()) {
                    case "Iris-setosa":
                        setosaCount++; break;
                    case "Iris-versicolor":
                        versicolorCount++; break;
                    case "Iris-virginica":
                        virginicaCount++; break;
                    default:
                        break;
                }
            }
            if (setosaCount >= versicolorCount && setosaCount >= virginicaCount) {
                if (testIris.getClassName().equalsIgnoreCase("Iris-setosa")) {
                    correctCounter++;
                }
            } else if (versicolorCount >= setosaCount && versicolorCount >= virginicaCount) {
                if (testIris.getClassName().equalsIgnoreCase("Iris-versicolor")) {
                    correctCounter++;
                }
            } else if (virginicaCount >= setosaCount && virginicaCount >= versicolorCount) {
                if (testIris.getClassName().equalsIgnoreCase("Iris-virginica")) {
                    correctCounter++;
                }
            }
        }
        System.out.println("Correct count is " + correctCounter + " out of 75");
        System.out.println("That is an accuracy of " + (double)correctCounter/testSet.size()*100 + "%");

    }

    public double distanceTo(Iris origin, Iris other) {
        double SL = Math.pow(Math.abs(origin.getSepalLength() - other.getSepalLength()), 2) / sepalLengthRange;
        double SW = Math.pow(Math.abs(origin.getSepalWidth() - other.getSepalWidth()), 2) / sepalWidthRange;
        double PL = Math.pow(Math.abs(origin.getPetalLength() - other.getPetalLength()), 2) / petalLengthRange;
        double PW = Math.pow(Math.abs(origin.getPetalWidth() - other.getPetalWidth()), 2) / petalWidthRange;

        return Math.sqrt(SL + SW + PL + PW);
    }
}
