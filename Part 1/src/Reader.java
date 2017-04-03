import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by nztyler on 28/03/17.
 */
public class Reader {
    private List<Iris> irisCollection;

    public Reader(String fileName) {
        irisCollection = new ArrayList<Iris>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line = br.readLine();

            while (line != null) {
                String[] splitted = line.split("\\s+"); //whitespace regex
                if (splitted.length == 5) {
                    double sepalLength = Double.parseDouble(splitted[0]);
                    double sepalWidth = Double.parseDouble(splitted[1]);
                    double petalLength = Double.parseDouble(splitted[2]);
                    double petalWidth = Double.parseDouble(splitted[3]);
                    String className = splitted[4];
                    Iris iris = new Iris(sepalLength, sepalWidth, petalLength, petalWidth, className);
                    irisCollection.add(iris);
                }
                line = br.readLine();
            }
            br.close();

        } catch (IOException | IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    public List<Iris> getCollection() {
        return irisCollection;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        for (Iris iris : irisCollection) {
            string.append(iris.toString());
            string.append("\n");
        }

        return string.toString();
    }
}
