/**
 * Question 3: Reverse String
 * Problem: Write a function to reverse a string in-place (without using built-in reverse)
 * 
 * Example:
 * Input: "hello"
 * Output: "olleh"
 */

function reverseString(s: string): string {
  let result = '';
  for (let i = s.length - 1; i >= 0; i--) {
    result += s[i];
  }
  return result;
}

// Alternative: Using spread operator
function reverseStringAlternative(s: string): string {
  return [...s].reverse().join('');
}

// Alternative: Using recursion
function reverseStringRecursive(s: string): string {
  if (s.length === 0) return '';
  return reverseStringRecursive(s.slice(1)) + s[0];
}

// Test cases
console.log(reverseString("hello")); // "olleh"
console.log(reverseString("TypeScript")); // "tpircSepyT"
console.log(reverseString("123")); // "321"
console.log(reverseStringAlternative("world")); // "dlrow"
console.log(reverseStringRecursive("abc")); // "cba"
