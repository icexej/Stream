import java.util.*;
import java.util.stream.Collectors;

public class StreamBasics {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 5, 6, 10, 15);
        List<String> strings = Arrays.asList("Aisulu", "Java", "Stream", "API", "Action", "Kek");

        // 1. Filter a list of integers to include only even numbers.
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("1. Even: " + evens);

        // 2. Convert a list of strings to uppercase.
        List<String> upper = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("2. UpperCase: " + upper);

        // 3. Count how many strings in a list start with a specific letter.
        long countA = strings.stream()
                .filter(s -> s.startsWith("A"))
                .count();
        System.out.println("3. Count: " + countA);

        // 4. Sort a list of numbers in descending order.
        List<Integer> sortedDesc = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("4. Descending order: " + sortedDesc);

        // 5. Max и Min
        int max = numbers.stream().max(Integer::compare).orElse(0);
        int min = numbers.stream().min(Integer::compare).orElse(0);
        System.out.println("5. Max: " + max + ", Min: " + min);

        // 6. Remove duplicate elements from a list.
        List<Integer> distinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("6. Without duplicate: " + distinct);

        // 7. Concatenate a list of strings into a single comma-separated string.
        String joined = strings.stream()
                .collect(Collectors.joining(", "));
        System.out.println("7. Concatenation: " + joined);
    }
}