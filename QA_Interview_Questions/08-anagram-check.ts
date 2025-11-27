/**
 * Question 8: Anagram Check
 * Problem: Check if two strings are anagrams (contain the same characters)
 * 
 * Example:
 * Input: "listen", "silent"
 * Output: true
 */

function areAnagrams(str1: string, str2: string): boolean {
  const normalize = (s: string) => s.toLowerCase().replace(/\s/g, '');
  const sorted = (s: string) => s.split('').sort().join('');
  
  return sorted(normalize(str1)) === sorted(normalize(str2));
}

// Alternative: Using character count map
function areAnagramsMap(str1: string, str2: string): boolean {
  const normalize = (s: string) => s.toLowerCase().replace(/\s/g, '');
  str1 = normalize(str1);
  str2 = normalize(str2);
  
  if (str1.length !== str2.length) return false;
  
  const charCount: Map<string, number> = new Map();
  
  for (const char of str1) {
    charCount.set(char, (charCount.get(char) || 0) + 1);
  }
  
  for (const char of str2) {
    const count = charCount.get(char) || 0;
    if (count === 0) return false;
    charCount.set(char, count - 1);
  }
  
  return true;
}

// Test cases
console.log(areAnagrams("listen", "silent")); // true
console.log(areAnagrams("hello", "world")); // false
console.log(areAnagrams("The Eyes", "They See")); // true
console.log(areAnagramsMap("anagram", "nagaram")); // true
console.log(areAnagramsMap("abc", "def")); // false
