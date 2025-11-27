/**
 * Question 17: Group Anagrams
 * Problem: Group strings that are anagrams together
 * 
 * Example:
 * Input: ["eat", "tea", "ate", "bat", "tab", "cat"]
 * Output: [["eat", "tea", "ate"], ["bat", "tab"], ["cat"]]
 */

import java.util.*;

public class GroupAnagrams {
    
    // Using sorted characters as key
    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(word);
        }
        
        return new ArrayList<>(groups.values());
    }
    
    // Using character count as key
    public static List<List<String>> groupAnagramsCharCount(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String word : words) {
            int[] charCount = new int[26];
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            
            StringBuilder key = new StringBuilder();
            for (int count : charCount) {
                key.append(count).append("#");
            }
            
            String keyStr = key.toString();
            groups.putIfAbsent(keyStr, new ArrayList<>());
            groups.get(keyStr).add(word);
        }
        
        return new ArrayList<>(groups.values());
    }
    
    // Sort groups by size
    public static List<List<String>> groupAnagramsSorted(String[] words) {
        List<List<String>> result = groupAnagrams(words);
        result.sort((a, b) -> b.size() - a.size());
        return result;
    }
    
    public static void main(String[] args) {
        String[] words1 = {"eat", "tea", "ate", "bat", "tab", "cat"};
        System.out.println(groupAnagrams(words1));
        // Output: [[eat, tea, ate], [bat, tab], [cat]]
        
        String[] words2 = {""};
        System.out.println(groupAnagrams(words2));
        // Output: [[]]
        
        String[] words3 = {"a"};
        System.out.println(groupAnagrams(words3));
        // Output: [[a]]
        
        System.out.println("\nUsing Character Count:");
        System.out.println(groupAnagramsCharCount(words1));
        
        System.out.println("\nSorted by Size:");
        System.out.println(groupAnagramsSorted(words1));
    }
}
