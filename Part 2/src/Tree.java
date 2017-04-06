import java.util.ArrayList;
import java.util.List;

/**
 * Created by nztyler on 30/03/17.
 */
public class Tree {

    private List<Instance> inst;
    private List<String> attr;
    private List<String> classes;

    public Tree(List<Instance> inst, List<String> attr, List<String> classes) {
        this.inst = inst;
        this.attr = attr;
        this.classes = classes;
    }

    /**
     *
     * @return The root node in the tree
     */
    public Node buildTree() {
        return buildTree(new ArrayList<Instance>(inst), new ArrayList<String>(attr));
    }

    public Node buildTree(List<Instance> instances, List<String> attributes) {
        if (instances.isEmpty()) {
            int counter = 0;
            for (int i = 0; i < inst.size(); i++) {
                if (inst.get(i).getClassName().equals(classes.get(0))) {
                    counter ++;
                }
            }
            if (counter > inst.size() / 2) {
                return new LeafNode(classes.get(0), counter / inst.size());
            } else {
                return new LeafNode(classes.get(1), counter / inst.size());
            }
        }
        if (isPure(instances)) {
            return new LeafNode(instances.get(0).getClassName(), 1);
        }
        if (attributes.isEmpty()) {
            int counter = 0;
            for (int i = 0; i < instances.size(); i++) {
                if (instances.get(i).getClassName().equals(classes.get(0))) {
                    counter++;
                }
            }
            if (counter > (instances.size() / 2)) {
                return new LeafNode(classes.get(0), counter / instances.size());
            } else {
                return new LeafNode(classes.get(1),counter / instances.size());
            }
        } else { // find the best attribute
            int bestAttributeIndex = -1;
            double bestImpurity = Double.MAX_VALUE;

            List<Instance> bestInstTrue = null;
            List<Instance> bestInstFalse = null;

            for (int i = 0; i < attributes.size(); i++) {
                InstanceTuple tuple = new InstanceTuple(instances, i);
                List<Instance> trueIns = tuple.getTrueInstances();
                List<Instance> falseIns = tuple.getFalseInstances();

                // compute purity for each set
                double pTrue = trueIns.size() / (double) attributes.size();
                int trueCount = 0;
                for (Instance ins : trueIns) {
                    if (ins.getClassName().equals(classes.get(0))) {
                        trueCount++;
                    }
                }
                System.out.println(trueCount + "/" + trueIns.size() + "*(" + trueIns.size() + "-"
                        + trueCount + ")/" + trueIns.size());
                double trueImp = (trueCount / trueIns.size()) * ((trueIns.size() - trueCount) / trueIns.size());
                double pFalse = falseIns.size() / (double) attributes.size();
                trueCount = 0;
                for (Instance ins : trueIns) {
                    if (ins.getClassName().equals(classes.get(0))) {
                        trueCount++;
                    }
                }
                double falseImp = (trueCount / falseIns.size()) * ((falseIns.size() - trueCount) / falseIns.size());
                double weightedImp = (pTrue * trueImp) + (pFalse * falseImp);

                if (bestImpurity > weightedImp) {
                    bestAttributeIndex = i;
                    bestInstTrue = trueIns;
                    bestInstFalse = falseIns;
                }
            }
            List<String> attrRemaining = new ArrayList<String>(attributes);
            attrRemaining.remove(bestAttributeIndex);
            Node left = buildTree(bestInstTrue, attrRemaining);
            Node right = buildTree(bestInstFalse, attrRemaining);
            return new InnerNode(attributes.get(bestAttributeIndex), left, right);
        }
    }

    /**
     * Instances are pure if all the instances are in the same class
     * @return true if instances are pure
     */
    public boolean isPure(List<Instance> checkList) {
        if (checkList.isEmpty()) {
            return false;
        }
        String name = checkList.get(0).getClassName();
        for (Instance ins : checkList) {
            if (!ins.getClassName().equals(name)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Small inner class to help split up the instances that are true and false
     */
    private class InstanceTuple {

        private List<Instance> trueInstances;
        private List<Instance> falseInstances;

        public InstanceTuple(List<Instance> instances, int attributeIndex) {
            trueInstances = new ArrayList<Instance>();
            falseInstances = new ArrayList<Instance>();
            for (Instance ins : instances) {
                if (ins.getAttributes().get(attributeIndex).equals("true")) {
                    trueInstances.add(ins);
                } else {
                    falseInstances.add(ins);
                }
            }
        }

        public List<Instance> getTrueInstances() { return trueInstances; }

        public List<Instance> getFalseInstances() {
            return falseInstances;
        }
    }
}
