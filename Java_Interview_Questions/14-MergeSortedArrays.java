/**
 * Question 14: Merge Sorted Arrays
 * Problem: Merge two sorted arrays into one sorted array
 * 
 * Example:
 * Input: [1, 3, 5], [2, 4, 6]
 * Output: [1, 2, 3, 4, 5, 6]
 */

import java.util.*;

public class MergeSortedArrays {
    
    // Two-pointer merge
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;
        
        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }
        
        // Copy remaining elements
        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }
        
        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }
        
        return result;
    }
    
    // Using streams
    public static int[] mergeSortedArraysStream(int[] arr1, int[] arr2) {
        return Arrays.stream(
            java.util.stream.Stream.concat(
                Arrays.stream(arr1).boxed(),
                Arrays.stream(arr2).boxed()
            ).mapToInt(Integer::intValue).toArray()
        ).sorted().toArray();
    }
    
    // Merge in-place into first array
    public static void mergeSortedArraysInPlace(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
            } else {
                arr1[k] = arr2[j];
                j--;
            }
            k--;
        }
        
        // If arr2 has remaining elements, copy them
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
    }
    
    // Merge lists
    public static List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i) <= list2.get(j)) {
                result.add(list1.get(i++));
            } else {
                result.add(list2.get(j++));
            }
        }
        
        while (i < list1.size()) {
            result.add(list1.get(i++));
        }
        
        while (j < list2.size()) {
            result.add(list2.get(j++));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeSortedArrays(
            new int[]{1, 3, 5}, new int[]{2, 4, 6}))); 
        // [1, 2, 3, 4, 5, 6]
        
        System.out.println(Arrays.toString(mergeSortedArrays(
            new int[]{1, 2, 3}, new int[]{4, 5, 6}))); 
        // [1, 2, 3, 4, 5, 6]
        
        System.out.println(Arrays.toString(mergeSortedArrays(
            new int[]{}, new int[]{1, 2, 3}))); 
        // [1, 2, 3]
        
        int[] arr1 = {1, 3, 5, 0, 0, 0};
        mergeSortedArraysInPlace(arr1, 3, new int[]{2, 4, 6}, 3);
        System.out.println(Arrays.toString(arr1)); // [1, 2, 3, 4, 5, 6]
        
        List<Integer> list1 = Arrays.asList(1, 3, 5);
        List<Integer> list2 = Arrays.asList(2, 4, 6);
        System.out.println(mergeSortedLists(list1, list2)); // [1, 2, 3, 4, 5, 6]
    }
}
