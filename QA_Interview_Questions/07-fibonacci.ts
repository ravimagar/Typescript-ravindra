/**
 * Question 7: Fibonacci Sequence
 * Problem: Generate the nth Fibonacci number
 * 
 * Example:
 * Input: 6
 * Output: 8 (sequence: 0, 1, 1, 2, 3, 5, 8)
 */

// Recursive approach (less efficient)
function fibonacciRecursive(n: number): number {
  if (n <= 1) return n;
  return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
}

// Iterative approach (efficient)
function fibonacciIterative(n: number): number {
  if (n <= 1) return n;
  
  let prev = 0;
  let curr = 1;
  
  for (let i = 2; i <= n; i++) {
    const next = prev + curr;
    prev = curr;
    curr = next;
  }
  
  return curr;
}

// Memoization approach
function fibonacciMemo(): (n: number) => number {
  const memo: Map<number, number> = new Map();
  
  return function fib(n: number): number {
    if (memo.has(n)) return memo.get(n)!;
    if (n <= 1) return n;
    
    const result = fib(n - 1) + fib(n - 2);
    memo.set(n, result);
    return result;
  };
}

// Generate Fibonacci sequence
function generateFibonacci(count: number): number[] {
  const sequence: number[] = [];
  for (let i = 0; i < count; i++) {
    sequence.push(fibonacciIterative(i));
  }
  return sequence;
}

// Test cases
console.log(fibonacciIterative(6)); // 8
console.log(fibonacciIterative(10)); // 55
console.log(generateFibonacci(7)); // [0, 1, 1, 2, 3, 5, 8]

const memoFib = fibonacciMemo();
console.log(memoFib(10)); // 55
console.log(memoFib(15)); // 610
