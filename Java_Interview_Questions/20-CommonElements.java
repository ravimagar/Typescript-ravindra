/**
 * Question 20: Common Elements in Arrays
 * Problem: Find common elements that appear in all arrays
 * 
 * Example:
 * Input: [[1, 2, 3], [2, 3, 4], [2, 3, 5]]
 * Output: [2, 3]
 */

import java.util.*;

public class CommonElements {
    
    // Using Set intersection
    public static List<Integer> findCommonElements(int[][] arrays) {
        if (arrays.length == 0) return new ArrayList<>();
        if (arrays.length == 1) return new ArrayList<>(arrayToList(arrays[0]));
        
        Set<Integer> common = new HashSet<>(arrayToList(arrays[0]));
        
        for (int i = 1; i < arrays.length; i++) {
            Set<Integer> current = new HashSet<>(arrayToList(arrays[i]));
            common.retainAll(current);
        }
        
        List<Integer> result = new ArrayList<>(common);
        Collections.sort(result);
        return result;
    }
    
    // Find common in two arrays
    public static List<Integer> findCommonInTwo(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>(arrayToList(arr1));
        Set<Integer> common = new HashSet<>();
        
        for (int num : arr2) {
            if (set1.contains(num)) {
                common.add(num);
            }
        }
        
        List<Integer> result = new ArrayList<>(common);
        Collections.sort(result);
        return result;
    }
    
    // Find common preserving duplicates
    public static List<Integer> findCommonWithDuplicates(int[][] arrays) {
        if (arrays.length == 0) return new ArrayList<>();
        
        Map<Integer, Integer> countMap = new HashMap<>();
        
        // Count in first array
        for (int num : arrays[0]) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        
        // Find minimum count in all arrays
        for (int i = 1; i < arrays.length; i++) {
            Map<Integer, Integer> currentCount = new HashMap<>();
            for (int num : arrays[i]) {
                currentCount.put(num, currentCount.getOrDefault(num, 0) + 1);
            }
            
            List<Integer> keysToRemove = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (!currentCount.containsKey(entry.getKey())) {
                    keysToRemove.add(entry.getKey());
                } else {
                    int minCount = Math.min(entry.getValue(), currentCount.get(entry.getKey()));
                    countMap.put(entry.getKey(), minCount);
                }
            }
            
            for (int key : keysToRemove) {
                countMap.remove(key);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(entry.getKey());
            }
        }
        
        Collections.sort(result);
        return result;
    }
    
    // Using HashMap for frequency
    public static List<Integer> findCommonFrequency(int[][] arrays) {
        if (arrays.length == 0) return new ArrayList<>();
        
        Map<Integer, Integer> frequency = new HashMap<>();
        
        for (int num : arrays[0]) {
            frequency.put(num, 1);
        }
        
        for (int i = 1; i < arrays.length; i++) {
            Set<Integer> currentSet = new HashSet<>(arrayToList(arrays[i]));
            List<Integer> keysToKeep = new ArrayList<>();
            
            for (Integer key : frequency.keySet()) {
                if (currentSet.contains(key)) {
                    keysToKeep.add(key);
                }
            }
            
            frequency.clear();
            for (int key : keysToKeep) {
                frequency.put(key, 1);
            }
        }
        
        List<Integer> result = new ArrayList<>(frequency.keySet());
        Collections.sort(result);
        return result;
    }
    
    // Helper method
    private static List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[][] arrays1 = {{1, 2, 3}, {2, 3, 4}, {2, 3, 5}};
        System.out.println(findCommonElements(arrays1)); // [2, 3]
        
        int[][] arrays2 = {{1, 2}, {1, 2}};
        System.out.println(findCommonElements(arrays2)); // [1, 2]
        
        int[][] arrays3 = {{1, 2, 3, 4}, {2, 4, 6, 8}, {2, 4}};
        System.out.println(findCommonElements(arrays3)); // [2, 4]
        
        System.out.println(findCommonInTwo(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6, 8})); 
        // [2, 4]
        
        int[][] arrays4 = {{1, 2, 2, 3}, {2, 2, 3, 4}, {2, 2, 3, 5}};
        System.out.println(findCommonWithDuplicates(arrays4)); // [2, 2, 3]
        
        System.out.println(findCommonFrequency(arrays1)); // [2, 3]
    }
}
