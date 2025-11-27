/**
 * Question 8: Anagram Check
 * Problem: Check if two strings are anagrams
 * 
 * Example:
 * Input: "listen", "silent"
 * Output: true
 */

import java.util.*;

public class AnagramCheck {
    
    // Using sorted characters
    public static boolean areAnagrams(String str1, String str2) {
        String s1 = str1.toLowerCase().replaceAll("\\s", "");
        String s2 = str2.toLowerCase().replaceAll("\\s", "");
        
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        return Arrays.equals(arr1, arr2);
    }
    
    // Using HashMap character count
    public static boolean areAnagramsMap(String str1, String str2) {
        String s1 = str1.toLowerCase().replaceAll("\\s", "");
        String s2 = str2.toLowerCase().replaceAll("\\s", "");
        
        if (s1.length() != s2.length()) return false;
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in first string
        for (char c : s1.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Decrement count for second string
        for (char c : s2.toCharArray()) {
            if (!charCount.containsKey(c)) {
                return false;
            }
            charCount.put(c, charCount.get(c) - 1);
            if (charCount.get(c) < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    // Using character frequency array
    public static boolean areAnagramsArray(String str1, String str2) {
        String s1 = str1.toLowerCase().replaceAll("\\s", "");
        String s2 = str2.toLowerCase().replaceAll("\\s", "");
        
        if (s1.length() != s2.length()) return false;
        
        int[] charCount = new int[26];
        
        for (char c : s1.toCharArray()) {
            charCount[c - 'a']++;
        }
        
        for (char c : s2.toCharArray()) {
            charCount[c - 'a']--;
            if (charCount[c - 'a'] < 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(areAnagrams("listen", "silent")); // true
        System.out.println(areAnagrams("hello", "world")); // false
        System.out.println(areAnagrams("The Eyes", "They See")); // true
        System.out.println(areAnagramsMap("anagram", "nagaram")); // true
        System.out.println(areAnagramsArray("abc", "def")); // false
    }
}
