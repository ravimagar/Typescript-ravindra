/**
 * Question 7: Fibonacci Sequence
 * Problem: Generate the nth Fibonacci number
 * 
 * Example:
 * Input: 6
 * Output: 8 (sequence: 0, 1, 1, 2, 3, 5, 8)
 */

import java.util.*;

public class Fibonacci {
    
    // Recursive approach (inefficient for large n)
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    // Iterative approach (efficient)
    public static long fibonacciIterative(int n) {
        if (n <= 1) return n;
        
        long prev = 0, curr = 1;
        for (int i = 2; i <= n; i++) {
            long next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    // Memoization approach
    public static long fibonacciMemo(int n) {
        long[] memo = new long[n + 1];
        return fibonacci(n, memo);
    }
    
    private static long fibonacci(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = fibonacci(n - 1, memo) + fibonacci(n - 2, memo);
        return memo[n];
    }
    
    // Generate Fibonacci sequence
    public static List<Long> generateFibonacci(int count) {
        List<Long> sequence = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            sequence.add(fibonacciIterative(i));
        }
        return sequence;
    }
    
    // Using BigInteger for very large numbers
    public static java.math.BigInteger fibonacciBigInteger(int n) {
        if (n <= 1) {
            return java.math.BigInteger.valueOf(n);
        }
        
        java.math.BigInteger prev = java.math.BigInteger.ZERO;
        java.math.BigInteger curr = java.math.BigInteger.ONE;
        
        for (int i = 2; i <= n; i++) {
            java.math.BigInteger next = prev.add(curr);
            prev = curr;
            curr = next;
        }
        return curr;
    }
    
    public static void main(String[] args) {
        System.out.println(fibonacciIterative(6)); // 8
        System.out.println(fibonacciIterative(10)); // 55
        System.out.println(generateFibonacci(7)); // [0, 1, 1, 2, 3, 5, 8]
        System.out.println(fibonacciMemo(15)); // 610
        System.out.println(fibonacciBigInteger(100)); // Large Fibonacci number
    }
}
