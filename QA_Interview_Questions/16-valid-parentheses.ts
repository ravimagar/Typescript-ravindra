/**
 * Question 16: Valid Parentheses
 * Problem: Check if a string has valid parentheses/brackets
 * 
 * Example:
 * Input: "({[]})"
 * Output: true
 */

function isValidParentheses(str: string): boolean {
  const stack: string[] = [];
  const pairs: { [key: string]: string } = {
    ')': '(',
    '}': '{',
    ']': '['
  };
  
  for (const char of str) {
    if (char === '(' || char === '{' || char === '[') {
      stack.push(char);
    } else if (char === ')' || char === '}' || char === ']') {
      if (stack.length === 0 || stack.pop() !== pairs[char]) {
        return false;
      }
    }
  }
  
  return stack.length === 0;
}

// Extended version: handle multiple types of characters
function isValidParenthesesExtended(str: string): boolean {
  const stack: string[] = [];
  const pairs: { [key: string]: string } = {
    ')': '(',
    '}': '{',
    ']': '[',
    '>': '<'
  };
  const openBrackets = new Set(['(', '{', '[', '<']);
  
  for (const char of str) {
    if (openBrackets.has(char)) {
      stack.push(char);
    } else if (char in pairs) {
      if (stack.length === 0 || stack.pop() !== pairs[char]) {
        return false;
      }
    }
  }
  
  return stack.length === 0;
}

// Return minimum number of parentheses to remove for valid string
function minRemoveToMakeValid(str: string): string {
  const stack: number[] = [];
  const remove = new Set<number>();
  
  for (let i = 0; i < str.length; i++) {
    if (str[i] === '(') {
      stack.push(i);
    } else if (str[i] === ')') {
      if (stack.length === 0) {
        remove.add(i);
      } else {
        stack.pop();
      }
    }
  }
  
  // Remaining unmatched opening parentheses
  for (const idx of stack) {
    remove.add(idx);
  }
  
  return [...str].filter((_, i) => !remove.has(i)).join('');
}

// Test cases
console.log(isValidParentheses("({[]})")); // true
console.log(isValidParentheses("({[}])")); // false
console.log(isValidParentheses("(())")); // true
console.log(isValidParentheses("()[]")); // true
console.log(isValidParentheses("([)]")); // false

console.log(isValidParenthesesExtended("({[<>]})")); // true
console.log(isValidParenthesesExtended("({[<}])")); // false

console.log(minRemoveToMakeValid("lee(c)de)de")); // "lee(c)dede"
console.log(minRemoveToMakeValid("a)b(c)d")); // "ab(c)d"
