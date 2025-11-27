/**
 * Question 4: Array Deduplication
 * Problem: Remove duplicate elements from an array while preserving order
 * 
 * Example:
 * Input: [1, 2, 2, 3, 3, 3, 4]
 * Output: [1, 2, 3, 4]
 */

import java.util.*;

public class ArrayDeduplication {
    
    // Using HashSet
    public static int[] removeDuplicates(int[] arr) {
        Set<Integer> seen = new LinkedHashSet<>();
        for (int num : arr) {
            seen.add(num);
        }
        return seen.stream().mapToInt(Integer::intValue).toArray();
    }
    
    // Using HashSet for objects
    public static <T> List<T> removeDuplicatesGeneric(List<T> list) {
        Set<T> seen = new LinkedHashSet<>(list);
        return new ArrayList<>(seen);
    }
    
    // For sorted array - two pointer approach
    public static int removeDuplicatesSorted(int[] nums) {
        if (nums.length == 0) return 0;
        
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    
    // Remove duplicates with custom key
    public static <T> List<T> removeDuplicatesWithKey(List<T> list, 
                                                       java.util.function.Function<T, ?> keyExtractor) {
        Map<Object, T> seen = new LinkedHashMap<>();
        for (T item : list) {
            seen.putIfAbsent(keyExtractor.apply(item), item);
        }
        return new ArrayList<>(seen.values());
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeDuplicates(new int[]{1, 2, 2, 3, 3, 3, 4}))); 
        // [1, 2, 3, 4]
        
        List<String> list = Arrays.asList("a", "b", "b", "c");
        System.out.println(removeDuplicatesGeneric(list)); 
        // [a, b, c]
        
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int len = removeDuplicatesSorted(arr);
        System.out.println(len); // 5
    }
}
