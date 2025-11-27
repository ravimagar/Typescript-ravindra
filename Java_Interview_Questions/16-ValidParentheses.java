/**
 * Question 16: Valid Parentheses
 * Problem: Check if a string has valid matching brackets
 * 
 * Example:
 * Input: "({[]})"
 * Output: true
 */

import java.util.*;

public class ValidParentheses {
    
    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // With additional bracket types
    public static boolean isValidParenthesesExtended(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put('>', '<');
        Set<Character> openBrackets = new HashSet<>(Arrays.asList('(', '{', '[', '<'));
        
        for (char c : str.toCharArray()) {
            if (openBrackets.contains(c)) {
                stack.push(c);
            } else if (pairs.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != pairs.get(c)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    // Minimum parentheses to remove
    public static String minRemoveToMakeValid(String str) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> removeIndices = new HashSet<>();
        char[] chars = str.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(i);
            } else if (chars[i] == ')') {
                if (stack.isEmpty()) {
                    removeIndices.add(i);
                } else {
                    stack.pop();
                }
            }
        }
        
        // Remaining unmatched opening parentheses
        while (!stack.isEmpty()) {
            removeIndices.add(stack.pop());
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (!removeIndices.contains(i)) {
                result.append(chars[i]);
            }
        }
        
        return result.toString();
    }
    
    // Count minimum brackets to add
    public static int minAddToMakeValid(String str) {
        int openCount = 0;
        int closeCount = 0;
        
        for (char c : str.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                if (openCount > 0) {
                    openCount--;
                } else {
                    closeCount++;
                }
            }
        }
        
        return openCount + closeCount;
    }
    
    public static void main(String[] args) {
        System.out.println(isValidParentheses("({[]})")); // true
        System.out.println(isValidParentheses("({[}])")); // false
        System.out.println(isValidParentheses("(())")); // true
        System.out.println(isValidParentheses("()[]")); // true
        System.out.println(isValidParentheses("([)]")); // false
        
        System.out.println("\nExtended:");
        System.out.println(isValidParenthesesExtended("({[<>]})")); // true
        System.out.println(isValidParenthesesExtended("({[<}])")); // false
        
        System.out.println("\nMin Remove:");
        System.out.println(minRemoveToMakeValid("lee(c)de)de")); // "lee(c)dede"
        System.out.println(minRemoveToMakeValid("a)b(c)d")); // "ab(c)d"
        
        System.out.println("\nMin Add:");
        System.out.println(minAddToMakeValid("lee(c)de)de")); // 1
        System.out.println(minAddToMakeValid("a)b(c)d")); // 1
    }
}
