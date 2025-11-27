/**
 * Question 9: Array Rotation
 * Problem: Rotate an array to the right by k steps
 * 
 * Example:
 * Input: [1, 2, 3, 4, 5], k = 2
 * Output: [4, 5, 1, 2, 3]
 */

function rotateArray<T>(arr: T[], k: number): T[] {
  if (arr.length === 0) return arr;
  
  // Normalize k to be within array length
  k = k % arr.length;
  
  // Take last k elements and concatenate with the rest
  return [...arr.slice(-k), ...arr.slice(0, arr.length - k)];
}

// Alternative: In-place rotation using reverse
function rotateArrayInPlace<T>(arr: T[], k: number): T[] {
  if (arr.length === 0) return arr;
  
  k = k % arr.length;
  
  // Helper function to reverse array segment
  const reverse = (array: T[], start: number, end: number) => {
    while (start < end) {
      [array[start], array[end]] = [array[end], array[start]];
      start++;
      end--;
    }
  };
  
  // Reverse the entire array
  reverse(arr, 0, arr.length - 1);
  
  // Reverse the first k elements
  reverse(arr, 0, k - 1);
  
  // Reverse the remaining elements
  reverse(arr, k, arr.length - 1);
  
  return arr;
}

// Test cases
console.log(rotateArray([1, 2, 3, 4, 5], 2)); // [4, 5, 1, 2, 3]
console.log(rotateArray([1, 2, 3, 4, 5], 0)); // [1, 2, 3, 4, 5]
console.log(rotateArray([1, 2, 3, 4, 5], 5)); // [1, 2, 3, 4, 5]
console.log(rotateArray([1, 2, 3, 4, 5], 7)); // [4, 5, 1, 2, 3]

const arr = [1, 2, 3, 4, 5];
console.log(rotateArrayInPlace(arr, 2)); // [4, 5, 1, 2, 3]
