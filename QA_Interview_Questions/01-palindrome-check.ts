/**
 * Question 1: Palindrome Check
 * Problem: Write a function to check if a string is a palindrome (ignoring spaces and case)
 * 
 * Example:
 * Input: "A man a plan a canal Panama"
 * Output: true
 */

function isPalindrome(str: string): boolean {
  const cleaned = str.toLowerCase().replace(/[^a-z0-9]/g, '');
  const reversed = cleaned.split('').reverse().join('');
  return cleaned === reversed;
}

// Test cases
console.log(isPalindrome("A man a plan a canal Panama")); // true
console.log(isPalindrome("hello")); // false
console.log(isPalindrome("racecar")); // true
console.log(isPalindrome("12321")); // true
