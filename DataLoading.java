import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
public class DataLoader {
 
    public static void main(String[] args) {
        String filePath = "data.txt"; // Replace with your file path
        List<String> data = loadDataFromFile(filePath);
 
        if (data != null) {
            for (String line : data) {
                System.out.println(line);
            }
        }
    }
 
    public static List<String> loadDataFromFile(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
            return null;
        }
        return data;
    }
}