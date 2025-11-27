# Java Interview Questions for QA

A comprehensive collection of **20 essential Java coding interview questions** for QA professionals. Each question includes multiple solution approaches with detailed explanations.

## Directory Structure

```
Java_Interview_Questions/
├── 01-PalindromeCheck.java
├── 02-TwoSum.java
├── 03-ReverseString.java
├── 04-ArrayDeduplication.java
├── 05-FizzBuzz.java
├── 06-FindMaximum.java
├── 07-Fibonacci.java
├── 08-AnagramCheck.java
├── 09-ArrayRotation.java
├── 10-FlattenArray.java
├── 11-StringCompression.java
├── 12-BinarySearch.java
├── 13-LRUCache.java
├── 14-MergeSortedArrays.java
├── 15-RemoveDuplicatesSorted.java
├── 16-ValidParentheses.java
├── 17-GroupAnagrams.java
├── 18-LongestSubstring.java
├── 19-RotateMatrix.java
├── 20-CommonElements.java
└── README.md
```

## Question Index

### 1. **Palindrome Check** (01-PalindromeCheck.java)
- **Difficulty:** Easy
- **Topics:** String Manipulation, Two Pointers
- **Key Concepts:**
  - String cleaning and validation
  - Two-pointer approach
  - Space-efficient checking
- **Time Complexity:** O(n)
- **Space Complexity:** O(n) or O(1)

### 2. **Two Sum** (02-TwoSum.java)
- **Difficulty:** Easy
- **Topics:** Hash Maps, Array
- **Key Concepts:**
  - Hash map for O(1) lookups
  - Complement searching
  - Brute force vs optimized
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 3. **Reverse String** (03-ReverseString.java)
- **Difficulty:** Easy
- **Topics:** String, Recursion
- **Key Concepts:**
  - Multiple approaches (StringBuilder, array swap, recursion)
  - String reversal techniques
- **Time Complexity:** O(n)
- **Space Complexity:** O(1) to O(n)

### 4. **Array Deduplication** (04-ArrayDeduplication.java)
- **Difficulty:** Easy
- **Topics:** Hash Set, Array
- **Key Concepts:**
  - Set for uniqueness
  - Preserving order
  - Generic implementation
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 5. **FizzBuzz** (05-FizzBuzz.java)
- **Difficulty:** Easy
- **Topics:** Logic, Modulo Operation
- **Key Concepts:**
  - Conditional logic
  - Modulo arithmetic
  - Extensible design
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 6. **Find Maximum** (06-FindMaximum.java)
- **Difficulty:** Easy
- **Topics:** Array, Stream
- **Key Concepts:**
  - Linear scan
  - Stream API usage
  - Finding min and max together
  - Kth largest element
- **Time Complexity:** O(n)
- **Space Complexity:** O(1) or O(k)

### 7. **Fibonacci** (07-Fibonacci.java)
- **Difficulty:** Easy
- **Topics:** Recursion, Dynamic Programming
- **Key Concepts:**
  - Recursive approach
  - Iterative optimization
  - Memoization
  - BigInteger for large numbers
- **Time Complexity:** O(n) iterative, O(2^n) naive recursive
- **Space Complexity:** O(1) to O(n)

### 8. **Anagram Check** (08-AnagramCheck.java)
- **Difficulty:** Easy
- **Topics:** String, HashMap
- **Key Concepts:**
  - Character frequency counting
  - Sorted comparison
  - Array-based frequency
- **Time Complexity:** O(n log n) or O(n)
- **Space Complexity:** O(1) to O(n)

### 9. **Array Rotation** (09-ArrayRotation.java)
- **Difficulty:** Medium
- **Topics:** Array, In-place Operations
- **Key Concepts:**
  - Extra space solution
  - Reverse algorithm
  - Collections.rotate
- **Time Complexity:** O(n)
- **Space Complexity:** O(1) or O(n)

### 10. **Flatten Nested Array** (10-FlattenArray.java)
- **Difficulty:** Medium
- **Topics:** Recursion, Stream API
- **Key Concepts:**
  - Recursive flattening
  - Depth-limited flattening
  - Stream flatMap
- **Time Complexity:** O(n)
- **Space Complexity:** O(d) where d is depth

### 11. **String Compression** (11-StringCompression.java)
- **Difficulty:** Medium
- **Topics:** String, Regex
- **Key Concepts:**
  - Run-length encoding
  - Regex pattern matching
  - Compression vs decompression
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 12. **Binary Search** (12-BinarySearch.java)
- **Difficulty:** Medium
- **Topics:** Search, Divide and Conquer
- **Key Concepts:**
  - Iterative and recursive approaches
  - Finding first/last occurrence
  - Insertion position
  - Avoiding overflow in mid calculation
- **Time Complexity:** O(log n)
- **Space Complexity:** O(1) iterative, O(log n) recursive

### 13. **LRU Cache** (13-LRUCache.java)
- **Difficulty:** Hard
- **Topics:** Data Structures, Cache
- **Key Concepts:**
  - LinkedHashMap with custom ordering
  - Doubly Linked List + HashMap
  - LRU eviction policy
- **Time Complexity:** O(1) for get and put
- **Space Complexity:** O(capacity)

### 14. **Merge Sorted Arrays** (14-MergeSortedArrays.java)
- **Difficulty:** Easy
- **Topics:** Array, Two Pointers
- **Key Concepts:**
  - Two-pointer merge
  - In-place merging
  - Stream operations
- **Time Complexity:** O(m + n)
- **Space Complexity:** O(1) or O(m + n)

### 15. **Remove Duplicates from Sorted Array** (15-RemoveDuplicatesSorted.java)
- **Difficulty:** Easy
- **Topics:** Array, Two Pointers
- **Key Concepts:**
  - Two-pointer technique
  - Keeping k occurrences
  - In-place modification
- **Time Complexity:** O(n)
- **Space Complexity:** O(1)

### 16. **Valid Parentheses** (16-ValidParentheses.java)
- **Difficulty:** Easy
- **Topics:** Stack, String
- **Key Concepts:**
  - Stack-based validation
  - Matching pairs
  - Minimum removals
  - Minimum additions
- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

### 17. **Group Anagrams** (17-GroupAnagrams.java)
- **Difficulty:** Medium
- **Topics:** HashMap, String
- **Key Concepts:**
  - Sorted key approach
  - Character count key
  - Grouping and sorting
- **Time Complexity:** O(n * k log k) where k is max word length
- **Space Complexity:** O(n * k)

### 18. **Longest Substring Without Repeating** (18-LongestSubstring.java)
- **Difficulty:** Medium
- **Topics:** Sliding Window, HashMap
- **Key Concepts:**
  - Sliding window technique
  - Character tracking
  - HashSet vs HashMap
- **Time Complexity:** O(n)
- **Space Complexity:** O(min(m, n)) where m is charset size

### 19. **Rotate Matrix** (19-RotateMatrix.java)
- **Difficulty:** Medium
- **Topics:** Matrix, In-place Operations
- **Key Concepts:**
  - Transpose and reverse
  - Layer-by-layer rotation
  - Clockwise and counter-clockwise
- **Time Complexity:** O(n²)
- **Space Complexity:** O(1) for in-place

### 20. **Common Elements** (20-CommonElements.java)
- **Difficulty:** Medium
- **Topics:** Set, HashMap
- **Key Concepts:**
  - Set intersection
  - Frequency maps
  - Handling duplicates
- **Time Complexity:** O(n * m) where n arrays, m elements
- **Space Complexity:** O(m)

## How to Run

### Compile and Run Individual Files

```bash
# Compile a single file
javac 01-PalindromeCheck.java

# Run the program
java PalindromeCheck

# Or compile and run in one command
javac 01-PalindromeCheck.java && java PalindromeCheck
```

### Compile All Files

```bash
# Compile all Java files in the directory
javac *.java

# Run specific program
java PalindromeCheck
java TwoSum
# ... etc
```

## Key Interview Tips

### 1. **Understand the Problem**
- Ask clarifying questions
- Identify edge cases (empty arrays, null values, etc.)
- Understand constraints (memory, time limits)

### 2. **Approach Selection**
- Start with brute force (show you understand)
- Optimize incrementally
- Explain trade-offs (time vs space)

### 3. **Code Quality**
- Use meaningful variable names
- Add comments for complex logic
- Handle edge cases explicitly
- Follow Java conventions

### 4. **Testing**
- Test with normal cases
- Test with edge cases (empty, single element)
- Test with boundary values
- Discuss time and space complexity

### 5. **Common Patterns**
- **Two Pointers:** For sorted arrays/strings
- **Hash Map/Set:** For O(1) lookups
- **Sliding Window:** For substring/subarray problems
- **Stack:** For matching/nested problems
- **BFS/DFS:** For tree/graph traversal
- **Dynamic Programming:** For optimization problems

## Data Structures Quick Reference

### Arrays
- **When to use:** Fixed size collections, indexed access
- **Time:** O(1) access, O(n) search, O(n) insert/delete

### HashMap
- **When to use:** Key-value pairs, fast lookups
- **Time:** O(1) average, O(n) worst case

### HashSet
- **When to use:** Uniqueness, no duplicates
- **Time:** O(1) average operations

### LinkedList
- **When to use:** Frequent insert/delete at ends
- **Time:** O(1) at ends, O(n) elsewhere

### Stack
- **When to use:** LIFO operations, matching pairs
- **Time:** O(1) push/pop

### Queue
- **When to use:** FIFO operations, BFS
- **Time:** O(1) enqueue/dequeue

## Complexity Analysis Cheat Sheet

### Common Time Complexities
- **O(1):** Constant - array access, hash lookup
- **O(log n):** Logarithmic - binary search
- **O(n):** Linear - single loop
- **O(n log n):** Linearithmic - sorting
- **O(n²):** Quadratic - nested loops
- **O(2^n):** Exponential - recursive without memoization
- **O(n!):** Factorial - permutations

### Optimization Strategies
1. **Use Hash Maps** for O(1) lookups instead of O(n) searches
2. **Two Pointers** instead of nested loops
3. **Memoization** for overlapping subproblems
4. **Greedy Approach** when possible
5. **Sorting** to enable algorithms like two-pointers or binary search

## Additional Resources

### Important Java Classes for Interviews
- `java.util.HashMap` - Key-value storage
- `java.util.HashSet` - Unique elements
- `java.util.Stack` - LIFO data structure
- `java.util.Queue` - FIFO data structure
- `java.util.TreeMap` - Sorted map
- `java.util.TreeSet` - Sorted set
- `java.util.PriorityQueue` - Heap implementation
- `java.util.LinkedHashMap` - Insertion order map
- `java.util.stream` - Stream API for functional programming

### Common String Methods
- `.length()`, `.charAt()`, `.substring()`
- `.toCharArray()`, `.equals()`, `.compareTo()`
- `.split()`, `.contains()`, `.indexOf()`
- `.replace()`, `.trim()`, `.toLowerCase()`, `.toUpperCase()`

### Array Operations
- `Arrays.sort()`, `Arrays.binarySearch()`, `Arrays.equals()`
- `Arrays.fill()`, `Arrays.copyOf()`, `Arrays.stream()`

## Practice Strategy

1. **Week 1-2:** Do problems 1-5 (Easy)
2. **Week 3-4:** Do problems 6-10 (Easy-Medium)
3. **Week 5-6:** Do problems 11-15 (Medium)
4. **Week 7-8:** Do problems 16-20 (Medium-Hard)
5. **Ongoing:** Time yourself, explain out loud, discuss trade-offs

## Common Mistakes to Avoid

1. **Off-by-one errors** in loops and array indexing
2. **Null pointer exceptions** - always check for null
3. **Integer overflow** - be careful with calculations
4. **Not considering edge cases** - empty arrays, single elements
5. **Inefficient nested loops** - look for hash-based alternatives
6. **Not optimizing** - always ask "Can we do better?"
7. **Poor variable naming** - use clear, descriptive names
8. **Not explaining your thinking** - communicate constantly

## Contributing

Feel free to add more solutions, optimization techniques, or test cases!

## License

Open source - use freely for learning and interview preparation.

---

**Good Luck with Your Interviews! Remember:** The goal is not just to write code that works, but to demonstrate problem-solving skills, optimization thinking, and communication abilities.
