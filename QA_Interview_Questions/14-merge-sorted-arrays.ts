/**
 * Question 14: Merge Sorted Arrays
 * Problem: Merge two sorted arrays into one sorted array
 * 
 * Example:
 * Input: [1, 3, 5], [2, 4, 6]
 * Output: [1, 2, 3, 4, 5, 6]
 */

function mergeSortedArrays(arr1: number[], arr2: number[]): number[] {
  const result: number[] = [];
  let i = 0;
  let j = 0;
  
  while (i < arr1.length && j < arr2.length) {
    if (arr1[i] <= arr2[j]) {
      result.push(arr1[i]);
      i++;
    } else {
      result.push(arr2[j]);
      j++;
    }
  }
  
  // Add remaining elements
  while (i < arr1.length) {
    result.push(arr1[i]);
    i++;
  }
  
  while (j < arr2.length) {
    result.push(arr2[j]);
    j++;
  }
  
  return result;
}

// Using spread operator (simpler but not optimal for space)
function mergeSortedArraysSimple(arr1: number[], arr2: number[]): number[] {
  return [...arr1, ...arr2].sort((a, b) => a - b);
}

// Merge in-place into first array (if space is available)
function mergeSortedArraysInPlace(
  arr1: number[],
  m: number,
  arr2: number[],
  n: number
): void {
  let i = m - 1;
  let j = n - 1;
  let k = m + n - 1;
  
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
  
  while (j >= 0) {
    arr1[k] = arr2[j];
    j--;
    k--;
  }
}

// Test cases
console.log(mergeSortedArrays([1, 3, 5], [2, 4, 6])); // [1, 2, 3, 4, 5, 6]
console.log(mergeSortedArrays([1, 2, 3], [4, 5, 6])); // [1, 2, 3, 4, 5, 6]
console.log(mergeSortedArrays([], [1, 2, 3])); // [1, 2, 3]
console.log(mergeSortedArraysSimple([1, 3, 5], [2, 4, 6])); // [1, 2, 3, 4, 5, 6]

const arr1 = [1, 3, 5, 0, 0, 0];
const arr2 = [2, 4, 6];
mergeSortedArraysInPlace(arr1, 3, arr2, 3);
console.log(arr1); // [1, 2, 3, 4, 5, 6]
