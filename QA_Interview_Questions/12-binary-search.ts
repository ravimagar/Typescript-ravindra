/**
 * Question 12: Binary Search
 * Problem: Implement binary search to find an element in a sorted array
 * 
 * Example:
 * Input: [1, 3, 5, 7, 9], target = 5
 * Output: 2 (index of 5)
 */

function binarySearch(arr: number[], target: number): number {
  let left = 0;
  let right = arr.length - 1;
  
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    
    if (arr[mid] === target) {
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
function binarySearchRecursive(
  arr: number[],
  target: number,
  left: number = 0,
  right: number = arr.length - 1
): number {
  if (left > right) return -1;
  
  const mid = Math.floor((left + right) / 2);
  
  if (arr[mid] === target) {
    return mid;
  } else if (arr[mid] < target) {
    return binarySearchRecursive(arr, target, mid + 1, right);
  } else {
    return binarySearchRecursive(arr, target, left, mid - 1);
  }
}

// Find first occurrence
function binarySearchFirst(arr: number[], target: number): number {
  let left = 0;
  let right = arr.length - 1;
  let result = -1;
  
  while (left <= right) {
    const mid = Math.floor((left + right) / 2);
    
    if (arr[mid] === target) {
      result = mid;
      right = mid - 1; // Continue searching in the left half
    } else if (arr[mid] < target) {
      left = mid + 1;
    } else {
      right = mid - 1;
    }
  }
  
  return result;
}

// Test cases
console.log(binarySearch([1, 3, 5, 7, 9], 5)); // 2
console.log(binarySearch([1, 3, 5, 7, 9], 1)); // 0
console.log(binarySearch([1, 3, 5, 7, 9], 9)); // 4
console.log(binarySearch([1, 3, 5, 7, 9], 6)); // -1

console.log(binarySearchRecursive([2, 4, 6, 8, 10], 8)); // 3
console.log(binarySearchFirst([1, 2, 2, 2, 3, 4], 2)); // 1
