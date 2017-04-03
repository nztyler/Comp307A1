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

    public void report(String indent) {
        if (probability == 0) {
            System.out.format("%sUnknown\n", indent);
        } else {
            System.out.format("%sClass %s, prob=$4.2f\n",
                    indent, getClass(), probability);
        }
    }
}
