/**
 * Question 5: FizzBuzz
 * Problem: Print numbers 1 to n, but:
 * - For multiples of 3, print "Fizz"
 * - For multiples of 5, print "Buzz"
 * - For multiples of both, print "FizzBuzz"
 */

import java.util.*;

public class FizzBuzz {
    
    public static List<String> fizzBuzz(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        
        return result;
    }
    
    // Using modulo check with string builder
    public static List<String> fizzBuzzOptimized(int n) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            
            if (sb.length() == 0) {
                sb.append(i);
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }
    
    // Extensible version with custom rules
    public static List<String> fizzBuzzCustom(int n, Map<Integer, String> rules) {
        List<String> result = new ArrayList<>();
        
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            
            for (Map.Entry<Integer, String> rule : rules.entrySet()) {
                if (i % rule.getKey() == 0) {
                    sb.append(rule.getValue());
                }
            }
            
            if (sb.length() == 0) {
                sb.append(i);
            }
            
            result.add(sb.toString());
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(fizzBuzz(15));
        // [1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz]
        
        System.out.println(fizzBuzzOptimized(5));
        // [1, 2, Fizz, 4, Buzz]
        
        // Custom rules
        Map<Integer, String> customRules = new LinkedHashMap<>();
        customRules.put(3, "Fizz");
        customRules.put(5, "Buzz");
        System.out.println(fizzBuzzCustom(5, customRules));
    }
}
