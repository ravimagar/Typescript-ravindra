/**
 * Question 20: Common Elements in Arrays
 * Problem: Find common elements that appear in all arrays
 * 
 * Example:
 * Input: [[1, 2, 3], [2, 3, 4], [2, 3, 5]]
 * Output: [2, 3]
 */

function findCommonElements(arrays: number[][]): number[] {
  if (arrays.length === 0) return [];
  if (arrays.length === 1) return arrays[0];
  
  // Use the first array as reference
  const common = new Set(arrays[0]);
  
  // Intersect with remaining arrays
  for (let i = 1; i < arrays.length; i++) {
    const current = new Set(arrays[i]);
    const intersection = new Set<number>();
    
    for (const num of common) {
      if (current.has(num)) {
        intersection.add(num);
      }
    }
    
    common.clear();
    intersection.forEach(num => common.add(num));
  }
  
  return [...common].sort((a, b) => a - b);
}

// Find common elements in two arrays
function findCommonInTwo(arr1: number[], arr2: number[]): number[] {
  const set1 = new Set(arr1);
  return [...new Set(arr2.filter(num => set1.has(num)))].sort((a, b) => a - b);
}

// Find common elements preserving duplicates
function findCommonElementsWithDuplicates(arrays: number[][]): number[] {
  if (arrays.length === 0) return [];
  
  // Count occurrences in first array
  const countMap = new Map<number, number>();
  for (const num of arrays[0]) {
    countMap.set(num, (countMap.get(num) || 0) + 1);
  }
  
  // Find minimum count in all arrays
  for (let i = 1; i < arrays.length; i++) {
    const currentCount = new Map<number, number>();
    for (const num of arrays[i]) {
      currentCount.set(num, (currentCount.get(num) || 0) + 1);
    }
    
    for (const [num, count] of countMap) {
      if (!currentCount.has(num)) {
        countMap.delete(num);
      } else {
        countMap.set(num, Math.min(count, currentCount.get(num)!));
      }
    }
  }
  
  // Build result with duplicates
  const result: number[] = [];
  for (const [num, count] of countMap) {
    for (let i = 0; i < count; i++) {
      result.push(num);
    }
  }
  
  return result.sort((a, b) => a - b);
}

// Test cases
console.log(findCommonElements([[1, 2, 3], [2, 3, 4], [2, 3, 5]])); // [2, 3]
console.log(findCommonElements([[1, 2], [1, 2]])); // [1, 2]
console.log(findCommonElements([[1, 2, 3, 4], [2, 4, 6, 8], [2, 4]])); // [2, 4]
console.log(findCommonElements([])); // []

console.log(findCommonInTwo([1, 2, 3, 4], [2, 4, 6, 8])); // [2, 4]

console.log(findCommonElementsWithDuplicates([[1, 2, 2, 3], [2, 2, 3, 4], [2, 2, 3, 5]])); // [2, 2, 3]
