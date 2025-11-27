/**
 * Question 15: Remove Duplicates from Sorted Array
 * Problem: Remove duplicates from a sorted array in-place and return the new length
 * 
 * Example:
 * Input: [1, 1, 2, 2, 2, 3]
 * Output: 3 (array becomes [1, 2, 3, _, _, _])
 */

function removeDuplicatesSorted(arr: number[]): number {
  if (arr.length === 0) return 0;
  
  let i = 0;
  
  for (let j = 1; j < arr.length; j++) {
    if (arr[j] !== arr[i]) {
      i++;
      arr[i] = arr[j];
    }
  }
  
  return i + 1;
}

// Remove duplicates but keep at most k occurrences
function removeDuplicatesKeepK(arr: number[], k: number): number {
  if (arr.length <= k) return arr.length;
  
  let i = k;
  
  for (let j = k; j < arr.length; j++) {
    if (arr[j] !== arr[i - k]) {
      arr[i] = arr[j];
      i++;
    }
  }
  
  return i;
}

// Test cases
const testArr1 = [1, 1, 2, 2, 2, 3];
const len1 = removeDuplicatesSorted(testArr1);
console.log(len1); // 3
console.log(testArr1.slice(0, len1)); // [1, 2, 3]

const testArr2 = [0, 0, 1, 1, 1, 1, 2, 3, 3];
const len2 = removeDuplicatesSorted(testArr2);
console.log(len2); // 4
console.log(testArr2.slice(0, len2)); // [0, 1, 2, 3]

// Keep at most 2 occurrences
const testArr3 = [1, 1, 1, 2, 2, 3];
const len3 = removeDuplicatesKeepK(testArr3, 2);
console.log(len3); // 5
console.log(testArr3.slice(0, len3)); // [1, 1, 2, 2, 3]
