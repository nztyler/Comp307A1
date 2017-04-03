/**
 * Created by nztyler on 3/04/17.
 */
public class InnerNode extends Node{

    private Node left;
    private Node right;

    public InnerNode(String name, Node left, Node right) {
        super(name);
        this.left = left;
        this.right = right;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }
}
