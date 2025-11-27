/**
 * Question 17: Group Anagrams
 * Problem: Group strings that are anagrams together
 * 
 * Example:
 * Input: ["eat", "tea", "ate", "bat", "tab", "cat"]
 * Output: [["eat", "tea", "ate"], ["bat", "tab"], ["cat"]]
 */

function groupAnagrams(words: string[]): string[][] {
  const groups: Map<string, string[]> = new Map();
  
  for (const word of words) {
    // Sort characters to create a key
    const key = word.split('').sort().join('');
    
    if (!groups.has(key)) {
      groups.set(key, []);
    }
    
    groups.get(key)!.push(word);
  }
  
  return [...groups.values()];
}

// Alternative: Using character count as key
function groupAnagramsCharCount(words: string[]): string[][] {
  const groups: Map<string, string[]> = new Map();
  
  for (const word of words) {
    // Create a key based on character counts
    const charCount = new Array(26).fill(0);
    
    for (const char of word) {
      charCount[char.charCodeAt(0) - 'a'.charCodeAt(0)]++;
    }
    
    const key = charCount.join(',');
    
    if (!groups.has(key)) {
      groups.set(key, []);
    }
    
    groups.get(key)!.push(word);
  }
  
  return [...groups.values()];
}

// Test cases
console.log(groupAnagrams(["eat", "tea", "ate", "bat", "tab", "cat"]));
// Output: [["eat", "tea", "ate"], ["bat", "tab"], ["cat"]]

console.log(groupAnagrams([""]));
// Output: [[""]]

console.log(groupAnagrams(["a"]));
// Output: [["a"]]

console.log(groupAnagramsCharCount(["eat", "tea", "ate", "bat", "tab", "cat"]));
// Output: [["eat", "tea", "ate"], ["bat", "tab"], ["cat"]]
