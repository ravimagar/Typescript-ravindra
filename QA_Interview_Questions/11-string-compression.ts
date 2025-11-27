/**
 * Question 11: String Compression
 * Problem: Compress a string by replacing consecutive characters with character and count
 * 
 * Example:
 * Input: "aabbcccc"
 * Output: "a2b2c4"
 */

function compressString(str: string): string {
  if (str.length <= 1) return str;
  
  let compressed = '';
  let count = 1;
  
  for (let i = 0; i < str.length; i++) {
    if (i + 1 < str.length && str[i] === str[i + 1]) {
      count++;
    } else {
      compressed += str[i] + count;
      count = 1;
    }
  }
  
  return compressed.length < str.length ? compressed : str;
}

// Alternative: Using regex
function compressStringRegex(str: string): string {
  const compressed = str.replace(/(.)\1*/g, (match) => match[0] + match.length);
  return compressed.length < str.length ? compressed : str;
}

// Decompress a compressed string
function decompressString(str: string): string {
  let decompressed = '';
  let i = 0;
  
  while (i < str.length) {
    const char = str[i];
    let num = '';
    
    i++;
    while (i < str.length && !isNaN(parseInt(str[i]))) {
      num += str[i];
      i++;
    }
    
    decompressed += char.repeat(parseInt(num));
  }
  
  return decompressed;
}

// Test cases
console.log(compressString("aabbcccc")); // "a2b2c4"
console.log(compressString("abcdef")); // "abcdef" (no compression benefit)
console.log(compressString("aaaa")); // "a4"
console.log(compressStringRegex("aabbcccc")); // "a2b2c4"

console.log(decompressString("a2b2c4")); // "aabbcccc"
console.log(decompressString("a4b1c2")); // "aaabc"
