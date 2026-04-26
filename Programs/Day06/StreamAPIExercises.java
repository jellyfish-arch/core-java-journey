import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamAPIExercises {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // 1. Filter: Names starting with 'C' or 'D'
        List<String> filtered = names.stream()
            .filter(name -> name.startsWith("C") || name.startsWith("D"))
            .collect(Collectors.toList());
        System.out.println("Filtered names: " + filtered);

        // 2. Map: Convert names to uppercase
        List<String> upperNames = names.stream()
            .map(String::toUpperCase)
            .collect(Collectors.toList());
        System.out.println("Uppercase names: " + upperNames);

        // 3. Count: Number of names with length > 3
        long count = names.stream()
            .filter(name -> name.length() > 3)
            .count();
        System.out.println("Count of names with length > 3: " + count);

        // 4. Reduce: Concatenate all names
        String concatenated = names.stream()
            .reduce("", (partialString, element) -> partialString + element + " ");
        System.out.println("Concatenated names: " + concatenated.trim());
        
        // 5. Sorted: Sort names descending
        List<String> sortedNames = names.stream()
            .sorted((a, b) -> b.compareTo(a))
            .collect(Collectors.toList());
        System.out.println("Names sorted descending: " + sortedNames);
    }
}
