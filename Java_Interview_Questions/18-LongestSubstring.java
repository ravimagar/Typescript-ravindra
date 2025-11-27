/**
 * Question 18: Longest Substring Without Repeating Characters
 * Problem: Find the length of longest substring without repeating characters
 * 
 * Example:
 * Input: "abcabcbb"
 * Output: 3 (substring "abc")
 */

import java.util.*;

public class LongestSubstring {
    
    // Using sliding window with HashMap
    public static int lengthOfLongestSubstring(String str) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                start = charIndex.get(c) + 1;
            }
            
            charIndex.put(c, end);
            maxLen = Math.max(maxLen, end - start + 1);
        }
        
        return maxLen;
    }
    
    // Return the longest substring itself
    public static String getLongestSubstring(String str) {
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;
        int maxStart = 0;
        int start = 0;
        
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                start = charIndex.get(c) + 1;
            }
            
            charIndex.put(c, end);
            
            int currentLen = end - start + 1;
            if (currentLen > maxLen) {
                maxLen = currentLen;
                maxStart = start;
            }
        }
        
        return str.substring(maxStart, maxStart + maxLen);
    }
    
    // Using HashSet
    public static int lengthOfLongestSubstringSet(String str) {
        Set<Character> charSet = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < str.length(); right++) {
            while (charSet.contains(str.charAt(right))) {
                charSet.remove(str.charAt(left++));
            }
            charSet.add(str.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
    
    // Find all substrings without repeating
    public static List<String> findAllLongestSubstrings(String str) {
        List<String> result = new ArrayList<>();
        Map<Character, Integer> charIndex = new HashMap<>();
        int maxLen = 0;
        int start = 0;
        
        for (int end = 0; end < str.length(); end++) {
            char c = str.charAt(end);
            
            if (charIndex.containsKey(c) && charIndex.get(c) >= start) {
                start = charIndex.get(c) + 1;
            }
            
            charIndex.put(c, end);
            
            int currentLen = end - start + 1;
            if (currentLen >= maxLen) {
                if (currentLen > maxLen) {
                    result.clear();
                    maxLen = currentLen;
                }
                result.add(str.substring(start, end + 1));
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(lengthOfLongestSubstring("au")); // 2
        System.out.println(lengthOfLongestSubstring("")); // 0
        
        System.out.println("\nSubstring:");
        System.out.println(getLongestSubstring("abcabcbb")); // "abc"
        System.out.println(getLongestSubstring("bbbbb")); // "b"
        System.out.println(getLongestSubstring("pwwkew")); // "wke"
        System.out.println(getLongestSubstring("dvdf")); // "vdf"
        
        System.out.println("\nUsing Set:");
        System.out.println(lengthOfLongestSubstringSet("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstringSet("pwwkew")); // 3
        
        System.out.println("\nAll Longest:");
        System.out.println(findAllLongestSubstrings("abcabcbb")); // [abc]
        System.out.println(findAllLongestSubstrings("dvdf")); // [vdf]
    }
}
