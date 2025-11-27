/**
 * Question 6: Find Maximum in Array
 * Problem: Find the maximum element without using built-in methods
 * 
 * Example:
 * Input: [3, 1, 4, 1, 5, 9, 2, 6]
 * Output: 9
 */

import java.util.*;

public class FindMaximum {
    
    public static int findMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    
    // Using streams
    public static int findMaxStream(int[] arr) {
        return Arrays.stream(arr).max().orElseThrow(() -> 
            new IllegalArgumentException("Array is empty"));
    }
    
    // Find min and max together
    public static class MinMax {
        public int min;
        public int max;
        
        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }
        
        @Override
        public String toString() {
            return "Min: " + min + ", Max: " + max;
        }
    }
    
    public static MinMax findMinMax(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array is empty");
        }
        
        int min = arr[0];
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) min = arr[i];
            if (arr[i] > max) max = arr[i];
        }
        
        return new MinMax(min, max);
    }
    
    // Find kth largest element
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    public static void main(String[] args) {
        System.out.println(findMax(new int[]{3, 1, 4, 1, 5, 9, 2, 6})); // 9
        System.out.println(findMax(new int[]{-10, -20, -5})); // -5
        System.out.println(findMaxStream(new int[]{7, 2, 9, 1})); // 9
        System.out.println(findMinMax(new int[]{3, 1, 4, 1, 5})); // Min: 1, Max: 5
        System.out.println(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)); // 5
    }
}
