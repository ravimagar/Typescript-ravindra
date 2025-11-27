/**
 * Question 9: Array Rotation
 * Problem: Rotate an array to the right by k steps
 * 
 * Example:
 * Input: [1, 2, 3, 4, 5], k = 2
 * Output: [4, 5, 1, 2, 3]
 */

import java.util.*;

public class ArrayRotation {
    
    // Using extra space
    public static int[] rotateArray(int[] arr, int k) {
        if (arr.length == 0) return arr;
        
        k = k % arr.length;
        int[] result = new int[arr.length];
        
        // Copy last k elements to front
        for (int i = 0; i < k; i++) {
            result[i] = arr[arr.length - k + i];
        }
        
        // Copy remaining elements
        for (int i = k; i < arr.length; i++) {
            result[i] = arr[i - k];
        }
        
        return result;
    }
    
    // In-place rotation using reverse
    public static void rotateArrayInPlace(int[] arr, int k) {
        if (arr.length == 0) return;
        
        k = k % arr.length;
        
        // Reverse entire array
        reverse(arr, 0, arr.length - 1);
        
        // Reverse first k elements
        reverse(arr, 0, k - 1);
        
        // Reverse remaining elements
        reverse(arr, k, arr.length - 1);
    }
    
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    
    // Using Collections.rotate
    public static List<Integer> rotateArrayList(List<Integer> list, int k) {
        if (list.isEmpty()) return list;
        
        k = k % list.size();
        Collections.rotate(list, k);
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(rotateArray(new int[]{1, 2, 3, 4, 5}, 2))); 
        // [4, 5, 1, 2, 3]
        
        int[] arr = {1, 2, 3, 4, 5};
        rotateArrayInPlace(arr, 2);
        System.out.println(Arrays.toString(arr)); // [4, 5, 1, 2, 3]
        
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateArrayList(list, 2)); // [4, 5, 1, 2, 3]
    }
}
