import java.util.List;
import java.util.ArrayList;
/**
 * Created by nztyler on 30/03/17.
 */
public class Instance {

    private String className;
    private List<String> attributes;

    public Instance(List<String> attributes) {
        className = attributes.remove(0); //need to check index in bounds?
        this.attributes = attributes;
    }

    public String getClassName() {
        return className;
    }

    public List<String> getAttributes() {
        return attributes;
    }

    @Override
    public String toString() {
        StringBuilder description = new StringBuilder();
        for (int i = 0; i < attributes.size(); i++) {
            description.append(attributes.get(i));
            if (i < attributes.size() - 1) {
                description.append(", ");
            }
        }
        return description.toString();
    }
}
