/**
 * Question 12: Binary Search
 * Problem: Implement binary search to find an element in a sorted array
 * 
 * Example:
 * Input: [1, 3, 5, 7, 9], target = 5
 * Output: 2 (index of 5)
 */

public class BinarySearch {
    
    // Iterative binary search
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Not found
    }
    
    // Recursive binary search
    public static int binarySearchRecursive(int[] arr, int target) {
        return binarySearchHelper(arr, target, 0, arr.length - 1);
    }
    
    private static int binarySearchHelper(int[] arr, int target, int left, int right) {
        if (left > right) return -1;
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchHelper(arr, target, mid + 1, right);
        } else {
            return binarySearchHelper(arr, target, left, mid - 1);
        }
    }
    
    // Find first occurrence
    public static int binarySearchFirst(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue in left half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // Find last occurrence
    public static int binarySearchLast(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue in right half
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    // Find insertion position
    public static int searchInsertPosition(int[] arr, int target) {
        int left = 0, right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left;
    }
    
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 5)); // 2
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 1)); // 0
        System.out.println(binarySearch(new int[]{1, 3, 5, 7, 9}, 6)); // -1
        
        System.out.println(binarySearchRecursive(new int[]{2, 4, 6, 8, 10}, 8)); // 3
        
        System.out.println(binarySearchFirst(new int[]{1, 2, 2, 2, 3, 4}, 2)); // 1
        System.out.println(binarySearchLast(new int[]{1, 2, 2, 2, 3, 4}, 2)); // 3
        
        System.out.println(searchInsertPosition(new int[]{1, 3, 5, 6}, 5)); // 2
    }
}
