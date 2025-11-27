/**
 * Question 5: FizzBuzz
 * Problem: Write a function that prints numbers 1 to n, but:
 * - For multiples of 3, print "Fizz"
 * - For multiples of 5, print "Buzz"
 * - For multiples of both, print "FizzBuzz"
 */

function fizzBuzz(n: number): string[] {
  const result: string[] = [];
  
  for (let i = 1; i <= n; i++) {
    if (i % 15 === 0) {
      result.push("FizzBuzz");
    } else if (i % 3 === 0) {
      result.push("Fizz");
    } else if (i % 5 === 0) {
      result.push("Buzz");
    } else {
      result.push(i.toString());
    }
  }
  
  return result;
}

// Test cases
console.log(fizzBuzz(15));
// ['1', '2', 'Fizz', '4', 'Buzz', 'Fizz', '7', '8', 'Fizz', 'Buzz', '11', 'Fizz', '13', '14', 'FizzBuzz']

console.log(fizzBuzz(5));
// ['1', '2', 'Fizz', '4', 'Buzz']
