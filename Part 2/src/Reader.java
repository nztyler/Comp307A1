import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nztyler on 30/03/17.
 */
public class Reader {

    private List<String> classes;
    private List<String> attributes;

    private List<Instance> instances;

    public Reader(String fileName) {
        classes = new ArrayList<String>();
        attributes = new ArrayList<String>();
        instances = new ArrayList<Instance>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String className = br.readLine();
            classes = Arrays.asList(className.split("\\s+")); //whitespace regex
            String attributeNames = br.readLine();
            attributes = Arrays.asList(attributeNames.split("\\s+"));

            String instanceData = br.readLine();
            while (instanceData != null) {
                Instance val = new Instance(new ArrayList<String>(Arrays.asList(instanceData.split("\\s+"))));
                instances.add(val);
                instanceData = br.readLine();
            }
            br.close();
        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        for (Instance inst : instances) {
            System.out.println(inst.toString());
        }
    }

    public List<String> getClasses() {
        return classes;
    }

    public List<String> getAttributes() { return attributes; }

    public List<Instance> getInstances() {
        return instances;
    }

    @Override
    public String toString() { return null; }
}
