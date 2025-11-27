/**
 * Question 3: Reverse String
 * Problem: Reverse a string without using built-in reverse methods
 * 
 * Example:
 * Input: "hello"
 * Output: "olleh"
 */

public class ReverseString {
    
    public static String reverseString(String str) {
        String result = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            result += str.charAt(i);
        }
        return result;
    }
    
    // Using StringBuilder (more efficient)
    public static String reverseStringBuilder(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Using character array
    public static String reverseStringArray(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
    
    // Using recursion
    public static String reverseStringRecursive(String str) {
        if (str.isEmpty()) {
            return str;
        }
        return reverseStringRecursive(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        System.out.println(reverseString("hello")); // "olleh"
        System.out.println(reverseStringBuilder("TypeScript")); // "tpircSepyT"
        System.out.println(reverseStringArray("123")); // "321"
        System.out.println(reverseStringRecursive("abc")); // "cba"
    }
}
