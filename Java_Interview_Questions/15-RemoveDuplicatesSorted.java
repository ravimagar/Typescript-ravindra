/**
 * Question 15: Remove Duplicates from Sorted Array
 * Problem: Remove duplicates from sorted array in-place, return new length
 * 
 * Example:
 * Input: [1, 1, 2, 2, 2, 3]
 * Output: 3 (array becomes [1, 2, 3, _, _, _])
 */

import java.util.*;

public class RemoveDuplicatesSorted {
    
    // Two-pointer approach
    public static int removeDuplicates(int[] nums) {
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
    
    // Remove duplicates, keep at most k occurrences
    public static int removeDuplicatesKeepK(int[] nums, int k) {
        if (nums.length <= k) return nums.length;
        
        int i = k;
        for (int j = k; j < nums.length; j++) {
            if (nums[j] != nums[i - k]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
    // Remove duplicates and get unique elements
    public static List<Integer> getUnique(int[] nums) {
        Set<Integer> unique = new LinkedHashSet<>();
        for (int num : nums) {
            unique.add(num);
        }
        return new ArrayList<>(unique);
    }
    
    // Remove duplicates with duplicate count
    public static int removeDuplicatesCount(int[] nums) {
        int count = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        
        for (int num : nums) {
            if (!freq.containsKey(num)) {
                nums[count++] = num;
            }
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        return count;
    }
    
    public static void main(String[] args) {
        int[] testArr1 = {1, 1, 2, 2, 2, 3};
        int len1 = removeDuplicates(testArr1);
        System.out.println("Length: " + len1); // 3
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(testArr1, len1))); 
        // [1, 2, 3]
        
        int[] testArr2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len2 = removeDuplicates(testArr2);
        System.out.println("Length: " + len2); // 4
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(testArr2, len2))); 
        // [0, 1, 2, 3]
        
        // Keep at most 2 occurrences
        int[] testArr3 = {1, 1, 1, 2, 2, 3};
        int len3 = removeDuplicatesKeepK(testArr3, 2);
        System.out.println("Keep 2, Length: " + len3); // 5
        System.out.println("Array: " + Arrays.toString(Arrays.copyOf(testArr3, len3))); 
        // [1, 1, 2, 2, 3]
        
        // Get unique elements
        System.out.println("Unique: " + getUnique(new int[]{1, 1, 2, 2, 2, 3})); 
        // [1, 2, 3]
    }
}
