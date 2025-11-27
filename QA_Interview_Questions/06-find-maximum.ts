/**
 * Question 6: Find Maximum in Array
 * Problem: Find the maximum element in an array without using Math.max()
 * 
 * Example:
 * Input: [3, 1, 4, 1, 5, 9, 2, 6]
 * Output: 9
 */

function findMax(arr: number[]): number | null {
  if (arr.length === 0) return null;
  
  let max = arr[0];
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] > max) {
      max = arr[i];
    }
  }
  return max;
}

// Alternative: Using reduce
function findMaxReduce(arr: number[]): number | null {
  return arr.length === 0 ? null : arr.reduce((max, current) => (current > max ? current : max));
}

// Find maximum and minimum
function findMinMax(arr: number[]): { min: number; max: number } | null {
  if (arr.length === 0) return null;
  
  let min = arr[0];
  let max = arr[0];
  
  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < min) min = arr[i];
    if (arr[i] > max) max = arr[i];
  }
  
  return { min, max };
}

// Test cases
console.log(findMax([3, 1, 4, 1, 5, 9, 2, 6])); // 9
console.log(findMax([-10, -20, -5])); // -5
console.log(findMax([42])); // 42
console.log(findMaxReduce([7, 2, 9, 1])); // 9
console.log(findMinMax([3, 1, 4, 1, 5])); // { min: 1, max: 5 }
