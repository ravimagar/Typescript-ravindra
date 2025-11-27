/**
 * Question 10: Flatten Nested Array
 * Problem: Flatten a nested array into a single-level array
 * 
 * Example:
 * Input: [1, [2, [3, [4, 5]]]]
 * Output: [1, 2, 3, 4, 5]
 */

import java.util.*;

public class FlattenArray {
    
    // Using recursion with ArrayList
    public static List<Integer> flattenArray(List<?> arr) {
        List<Integer> result = new ArrayList<>();
        flatten(arr, result);
        return result;
    }
    
    private static void flatten(List<?> arr, List<Integer> result) {
        for (Object item : arr) {
            if (item instanceof List) {
                flatten((List<?>) item, result);
            } else if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
    }
    
    // Flatten to specific depth
    public static List<Integer> flattenArrayDepth(List<?> arr, int depth) {
        List<Integer> result = new ArrayList<>();
        flattenDepth(arr, depth, result);
        return result;
    }
    
    private static void flattenDepth(List<?> arr, int depth, List<Integer> result) {
        for (Object item : arr) {
            if (item instanceof List && depth > 0) {
                flattenDepth((List<?>) item, depth - 1, result);
            } else if (item instanceof Integer) {
                result.add((Integer) item);
            }
        }
    }
    
    // Using streams
    public static List<Integer> flattenArrayStream(List<?> arr) {
        return arr.stream()
            .flatMap(item -> {
                if (item instanceof List) {
                    return flattenArrayStream((List<?>) item).stream();
                } else if (item instanceof Integer) {
                    return Stream.of((Integer) item);
                }
                return Stream.empty();
            })
            .collect(java.util.stream.Collectors.toList());
    }
    
    public static void main(String[] args) {
        // Test case 1: Nested list
        List<?> nested1 = Arrays.asList(1, Arrays.asList(2, Arrays.asList(3, Arrays.asList(4, 5))));
        System.out.println(flattenArray(nested1)); // [1, 2, 3, 4, 5]
        
        // Test case 2: Different nesting
        List<?> nested2 = Arrays.asList(1, 2, Arrays.asList(3, 4, Arrays.asList(5, 6)));
        System.out.println(flattenArray(nested2)); // [1, 2, 3, 4, 5, 6]
        
        // Test case 3: Depth limited
        List<?> nested3 = Arrays.asList(1, Arrays.asList(2, Arrays.asList(3, Arrays.asList(4))));
        System.out.println(flattenArrayDepth(nested3, 2)); // [1, 2, 3, [4]]
        
        // Test case 4: Using streams
        System.out.println(flattenArrayStream(nested1)); // [1, 2, 3, 4, 5]
    }
}
