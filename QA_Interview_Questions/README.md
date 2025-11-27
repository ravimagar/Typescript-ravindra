# TypeScript Interview Questions for QA

This directory contains a comprehensive collection of TypeScript coding interview questions and their solutions. Each question is in a separate `.ts` file for easy reference and testing.

## Question Index

| # | Question | File | Difficulty | Topic |
|---|----------|------|------------|-------|
| 1 | Palindrome Check | `01-palindrome-check.ts` | Easy | String |
| 2 | Two Sum | `02-two-sum.ts` | Easy | Array, Hash Map |
| 3 | Reverse String | `03-reverse-string.ts` | Easy | String |
| 4 | Array Deduplication | `04-array-deduplication.ts` | Easy | Array, Set |
| 5 | FizzBuzz | `05-fizzbuzz.ts` | Easy | Logic |
| 6 | Find Maximum in Array | `06-find-maximum.ts` | Easy | Array |
| 7 | Fibonacci Sequence | `07-fibonacci.ts` | Medium | Recursion, Dynamic Programming |
| 8 | Anagram Check | `08-anagram-check.ts` | Easy | String |
| 9 | Array Rotation | `09-array-rotation.ts` | Medium | Array |
| 10 | Flatten Nested Array | `10-flatten-array.ts` | Medium | Array, Recursion |
| 11 | String Compression | `11-string-compression.ts` | Medium | String |
| 12 | Binary Search | `12-binary-search.ts` | Medium | Search, Sorting |
| 13 | LRU Cache | `13-lru-cache.ts` | Medium | Data Structure, Cache |
| 14 | Merge Sorted Arrays | `14-merge-sorted-arrays.ts` | Medium | Array, Sorting |
| 15 | Remove Duplicates from Sorted Array | `15-remove-duplicates-sorted.ts` | Easy | Array, Two Pointer |
| 16 | Valid Parentheses | `16-valid-parentheses.ts` | Easy | Stack, String |
| 17 | Group Anagrams | `17-group-anagrams.ts` | Medium | String, Hash Map |
| 18 | Longest Substring Without Repeating Characters | `18-longest-substring.ts` | Medium | String, Sliding Window |
| 19 | Rotate Matrix | `19-rotate-matrix.ts` | Medium | Array, Matrix |
| 20 | Common Elements in Arrays | `20-common-elements.ts` | Medium | Array, Set |

## How to Use

Each file contains:
- **Problem Description**: Clear explanation of what needs to be solved
- **Example**: Sample input/output
- **Solution(s)**: One or more implementations with different approaches
- **Test Cases**: Multiple test cases to verify the solution

### Running the Files

To run a specific question file with TypeScript:

```bash
npx ts-node 01-palindrome-check.ts
```

Or compile and run with Node.js:

```bash
npx tsc 01-palindrome-check.ts
node 01-palindrome-check.js
```

## Topics Covered

### Fundamentals
- Strings & String Manipulation
- Arrays & Array Operations
- Hash Maps & Sets
- Stacks

### Algorithms
- Searching (Binary Search)
- Sorting
- Two Pointers
- Sliding Window
- Recursion
- Dynamic Programming

### Data Structures
- Arrays
- Hash Maps
- Sets
- Stacks
- LRU Cache

### Problem-Solving Patterns
- Brute Force
- Optimization with Hash Maps
- Two Pointer Technique
- Sliding Window
- In-place Modifications
- Recursion & Memoization

## Difficulty Levels

- **Easy**: Problems that test basic understanding and implementation skills
- **Medium**: Problems requiring optimization and algorithm knowledge
- **Hard**: Complex problems requiring advanced data structures and algorithms

## Tips for Interviews

1. **Understand the Problem**: Read the problem carefully and clarify any ambiguities
2. **Test Cases**: Always consider edge cases:
   - Empty inputs
   - Single elements
   - Duplicates
   - Negative numbers
   - Very large numbers

3. **Optimization**: Consider time and space complexity
4. **Code Quality**: Write clean, readable code with meaningful variable names
5. **Explanations**: Be ready to explain your approach and why you chose it

## Complexity Reference

### Time Complexity
- O(1) - Constant
- O(log n) - Logarithmic (Binary Search)
- O(n) - Linear
- O(n log n) - Linearithmic (Efficient Sorting)
- O(n²) - Quadratic (Nested Loops)
- O(n³) - Cubic
- O(2ⁿ) - Exponential
- O(n!) - Factorial

### Space Complexity
- O(1) - Constant space
- O(n) - Linear space
- O(n²) - Quadratic space

## Additional Resources

- Practice on LeetCode, HackerRank, or CodeSignal
- Review TypeScript documentation
- Study data structures and algorithms fundamentals
- Practice live coding regularly

---

**Last Updated**: November 25, 2025
