/**
 * Created by nztyler on 30/03/17.
 */
public class Main {

    public static final String GOLF = "golf.dat";
    public static final String GTEST = "golf-test.dat";
    public static final String GTRAINING = "golf-training.dat";

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Incorrect parameters");
        } else {
            Reader reader = new Reader(args[0]);
            Tree tree = new Tree(reader.getInstances(), reader.getAttributes(), reader.getClasses());
            Node root = tree.buildTree();

            root.report("\t");

        }
    }

}
