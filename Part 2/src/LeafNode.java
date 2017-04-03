/**
 * Created by nztyler on 3/04/17.
 */
public class LeafNode extends Node{

    private double probability;

    public LeafNode(String name, double probability) {
        super(name);
        this.probability = probability;
    }

    public double getProbability() {
        return probability;
    }
}
