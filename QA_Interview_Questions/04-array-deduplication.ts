/**
 * Question 4: Array Deduplication
 * Problem: Remove duplicate elements from an array while preserving order
 * 
 * Example:
 * Input: [1, 2, 2, 3, 3, 3, 4]
 * Output: [1, 2, 3, 4]
 */

function removeDuplicates<T>(arr: T[]): T[] {
  return [...new Set(arr)];
}

// Alternative: Using filter
function removeDuplicatesFilter<T>(arr: T[]): T[] {
  return arr.filter((value, index, self) => self.indexOf(value) === index);
}

// For objects/complex types
function removeDuplicatesWithKey<T>(arr: T[], key: keyof T): T[] {
  const seen = new Set<T[keyof T]>();
  return arr.filter((item) => {
    if (seen.has(item[key])) {
      return false;
    }
    seen.add(item[key]);
    return true;
  });
}

// Test cases
console.log(removeDuplicates([1, 2, 2, 3, 3, 3, 4])); // [1, 2, 3, 4]
console.log(removeDuplicates(["a", "b", "b", "c"])); // ['a', 'b', 'c']
console.log(removeDuplicatesFilter([5, 5, 10, 10, 15])); // [5, 10, 15]

interface User {
  id: number;
  name: string;
}

const users: User[] = [
  { id: 1, name: "Alice" },
  { id: 2, name: "Bob" },
  { id: 1, name: "Alice" }
];

console.log(removeDuplicatesWithKey(users, "id"));
// [{ id: 1, name: 'Alice' }, { id: 2, name: 'Bob' }]
