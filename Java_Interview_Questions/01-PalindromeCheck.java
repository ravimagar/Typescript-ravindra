/**
 * Question 1: Palindrome Check
 * Problem: Check if a string is a palindrome (ignoring spaces and case)
 * 
 * Example:
 * Input: "A man a plan a canal Panama"
 * Output: true
 */

class PalindromeCheck {
    
    public static boolean isPalindrome(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(cleaned).reverse().toString();
        return cleaned.equals(reversed);
    }
    
    // Two-pointer approach (more efficient)
    public static boolean isPalindromeOptimized(String str) {
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Check palindrome without extra space
    public static boolean isPalindromeNoExtraSpace(String str) {
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            
            if (Character.toLowerCase(str.charAt(left)) != 
                Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(isPalindrome("A man a plan a canal Panama")); // true
        System.out.println(isPalindrome("hello")); // false
        System.out.println(isPalindrome("racecar")); // true
        System.out.println(isPalindromeOptimized("12321")); // true
        System.out.println(isPalindromeNoExtraSpace("0P")); // false
    }
}
