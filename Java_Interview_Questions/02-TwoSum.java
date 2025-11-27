/**
 * Question 2: Two Sum
 * Problem: Given an array of numbers and a target sum, find two indices that add up to the target
 * 
 * Example:
 * Input: [2, 7, 11, 15], target = 9
 * Output: [0, 1] (indices of 2 and 7)
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }
            seen.put(nums[i], i);
        }
        
        return new int[]{-1, -1};
    }
    
    // Brute force approach (O(n²) time)
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }
    
    // Two pointer approach (requires sorted array)
    public static int[] twoSumSorted(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6))); // [1, 2]
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6))); // [0, 1]
    }
}
