package Classifier;

import java.util.List;
import java.util.ArrayList;
/**
 * Created by nztyler on 28/03/17.
 */
public class Iris{
    private double sepalLength;
    private double sepalWidth;
    private double petalLength;
    private double petalWidth;
    private String className;

    private List<Iris> neighbours;

    public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String className) {
        this.sepalLength = sepalLength;
        this.sepalWidth = sepalWidth;
        this.petalLength = petalLength;
        this.petalWidth = petalWidth;
        this.className = className;

        this.neighbours = new ArrayList<Iris>();
    }

    public Iris(Iris iris) {
        this.sepalLength = iris.getSepalLength();
        this.sepalWidth = iris.getSepalWidth();
        this.petalLength = iris.getPetalLength();
        this.petalWidth = iris.getPetalWidth();
        this.className = iris.getClassName();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("Iris: Sepal length ");
        string.append(sepalLength);
        string.append(", Sepal width ");
        string.append(sepalWidth);
        string.append(", Petal length ");
        string.append(petalLength);
        string.append(", Petal width ");
        string.append(petalWidth);
        string.append(", Class name ");
        string.append(className);

        return string.toString();
    }

    // =============================================== //
    // ============= Setters and Getters ============= //
    // =============================================== //

    public double getSepalLength() {
        return sepalLength;
    }


    public void setSepalLength(double sepalLength) {
        this.sepalLength = sepalLength;
    }


    public double getSepalWidth() {
        return sepalWidth;
    }


    public void setSepalWidth(double sepalWidth) {
        this.sepalWidth = sepalWidth;
    }


    public double getPetalLength() {
        return petalLength;
    }


    public void setPetalLength(double petalLength) {
        this.petalLength = petalLength;
    }


    public double getPetalWidth() {
        return petalWidth;
    }


    public void setPetalWidth(double petalWidth) {
        this.petalWidth = petalWidth;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Iris> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(List<Iris> neighbours) {
        this.neighbours = neighbours;
    }
}
