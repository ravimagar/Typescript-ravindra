/**
 * Question 10: Flatten Nested Array
 * Problem: Flatten a nested array of any depth into a single-level array
 * 
 * Example:
 * Input: [1, [2, [3, [4, 5]]]]
 * Output: [1, 2, 3, 4, 5]
 */

function flattenArray(arr: any[]): any[] {
  return arr.reduce((acc, val) => {
    return acc.concat(Array.isArray(val) ? flattenArray(val) : val);
  }, []);
}

// Using spread operator and recursion
function flattenArrayRecursive(arr: any[]): any[] {
  let result: any[] = [];
  
  for (const item of arr) {
    if (Array.isArray(item)) {
      result = [...result, ...flattenArrayRecursive(item)];
    } else {
      result.push(item);
    }
  }
  
  return result;
}

// Flatten to specific depth
function flattenArrayDepth(arr: any[], depth: number = Infinity): any[] {
  return arr.reduce((acc, val) => {
    if (Array.isArray(val) && depth > 0) {
      return acc.concat(flattenArrayDepth(val, depth - 1));
    }
    return acc.concat(val);
  }, []);
}

// Using built-in flat() method (ES2019)
function flattenArrayBuiltIn(arr: any[], depth: number = Infinity): any[] {
  return arr.flat(depth);
}

// Test cases
console.log(flattenArray([1, [2, [3, [4, 5]]]])); // [1, 2, 3, 4, 5]
console.log(flattenArray([1, 2, [3, 4, [5, 6]]])); // [1, 2, 3, 4, 5, 6]
console.log(flattenArrayRecursive([1, [2], [[3]], [[[4]]]])); // [1, 2, 3, 4]

console.log(flattenArrayDepth([1, [2, [3, [4]]]], 2)); // [1, 2, 3, [4]]
console.log(flattenArrayBuiltIn([1, [2, [3, [4]]]], 2)); // [1, 2, 3, [4]]
