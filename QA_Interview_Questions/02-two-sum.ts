/**
 * Question 2: Two Sum
 * Problem: Given an array of numbers and a target sum, find two numbers that add up to the target
 * 
 * Example:
 * Input: [2, 7, 11, 15], target = 9
 * Output: [0, 1] (indices of 2 and 7)
 */

function twoSum(nums: number[], target: number): number[] {
  const seen: Map<number, number> = new Map();
  
  for (let i = 0; i < nums.length; i++) {
    const complement = target - nums[i];
    if (seen.has(complement)) {
      return [seen.get(complement)!, i];
    }
    seen.set(nums[i], i);
  }
  
  return [];
}

// Test cases
console.log(twoSum([2, 7, 11, 15], 9)); // [0, 1]
console.log(twoSum([3, 2, 4], 6)); // [1, 2]
console.log(twoSum([3, 3], 6)); // [0, 1]
console.log(twoSum([1, 5, 3, 7], 8)); // [1, 3]
