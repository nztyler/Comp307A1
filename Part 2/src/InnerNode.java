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

    public void report(String indent){
        System.out.format("%s%s = True:\n",
                indent, getName());
        left.report(indent + "    ");
        System.out.format("%s%s = False:\n",
                indent, getName());
        right.report(indent + "    ");
    }
}
