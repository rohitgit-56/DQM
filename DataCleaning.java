//This program has 2 defects which need to be fixed
//on 26 may dfects 3792 is fixed
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
 
public class DataCleaner {
 
    public static List<String> cleanData(List<String> data, List<Function<String, String>> cleanOps) {
        List<String> cleanedData = new ArrayList<>();
        for (String item : data) {
            String cleanedItem = item;
            for (Function<String, String> op : cleanOps) {
                cleanedItem = op.apply(cleanedItem);
            }
            cleanedData.add(cleanedItem);
        }
        return cleanedData;
    }
 
    public static void main(String[] args) {
        List<Function<String, String>> cleanOps = new ArrayList<>();
        cleanOps.add(String::toLowerCase);
        cleanOps.add(str -> str.replaceAll(" ", ""));
 
        List<String> data = new ArrayList<>();
        data.add("  John Doe  ");
        data.add("Jane Doe");
        data.add("  Peter Pan");
 
        List<String> cleanedData = cleanData(data, cleanOps);
        System.out.println(cleanedData);
    }
}