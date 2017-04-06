/**
 * Created by nztyler on 30/03/17.
 */
public class Main {

    public static final String GOLF = "golf.dat";
    public static final String GTEST = "golf-test.dat";
    public static final String GTRAINING = "golf-training.dat";

    public static void main(String[] args) {
        Reader reader = new Reader(GTRAINING);
        Tree tree = new Tree(reader.getInstances(), reader.getAttributes(), reader.getClasses());
        Node root = tree.buildTree();

        root.report("\t");
    }

}
