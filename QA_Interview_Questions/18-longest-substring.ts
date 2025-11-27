/**
 * Question 18: Longest Substring Without Repeating Characters
 * Problem: Find the length of the longest substring without repeating characters
 * 
 * Example:
 * Input: "abcabcbb"
 * Output: 3 (substring "abc")
 */

function lengthOfLongestSubstring(str: string): number {
  const charIndex: Map<string, number> = new Map();
  let maxLen = 0;
  let start = 0;
  
  for (let end = 0; end < str.length; end++) {
    const char = str[end];
    
    if (charIndex.has(char) && charIndex.get(char)! >= start) {
      // Move start to the right of the last occurrence
      start = charIndex.get(char)! + 1;
    }
    
    charIndex.set(char, end);
    maxLen = Math.max(maxLen, end - start + 1);
  }
  
  return maxLen;
}

// Return the longest substring itself
function getLongestSubstring(str: string): string {
  const charIndex: Map<string, number> = new Map();
  let maxLen = 0;
  let maxStart = 0;
  let start = 0;
  
  for (let end = 0; end < str.length; end++) {
    const char = str[end];
    
    if (charIndex.has(char) && charIndex.get(char)! >= start) {
      start = charIndex.get(char)! + 1;
    }
    
    charIndex.set(char, end);
    
    const currentLen = end - start + 1;
    if (currentLen > maxLen) {
      maxLen = currentLen;
      maxStart = start;
    }
  }
  
  return str.substring(maxStart, maxStart + maxLen);
}

// Test cases
console.log(lengthOfLongestSubstring("abcabcbb")); // 3
console.log(lengthOfLongestSubstring("bbbbb")); // 1
console.log(lengthOfLongestSubstring("pwwkew")); // 3
console.log(lengthOfLongestSubstring("au")); // 2
console.log(lengthOfLongestSubstring("")); // 0

console.log(getLongestSubstring("abcabcbb")); // "abc"
console.log(getLongestSubstring("bbbbb")); // "b"
console.log(getLongestSubstring("pwwkew")); // "wke"
console.log(getLongestSubstring("dvdf")); // "vdf"
