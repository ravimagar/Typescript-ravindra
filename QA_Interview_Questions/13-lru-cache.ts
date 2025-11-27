/**
 * Question 13: Implement LRU Cache
 * Problem: Implement a Least Recently Used (LRU) Cache
 * 
 * Operations:
 * - get(key): Return value if key exists, else -1
 * - put(key, value): Update or insert key-value pair, evict LRU item if full
 */

class LRUCache {
  private maxSize: number;
  private cache: Map<number, number>;
  
  constructor(capacity: number) {
    this.maxSize = capacity;
    this.cache = new Map();
  }
  
  get(key: number): number {
    if (!this.cache.has(key)) {
      return -1;
    }
    
    // Move to end (most recently used)
    const value = this.cache.get(key)!;
    this.cache.delete(key);
    this.cache.set(key, value);
    
    return value;
  }
  
  put(key: number, value: number): void {
    // If key exists, remove it (will be re-added at end)
    if (this.cache.has(key)) {
      this.cache.delete(key);
    }
    
    // Add or update key-value pair at the end
    this.cache.set(key, value);
    
    // If cache exceeds max size, remove least recently used (first item)
    if (this.cache.size > this.maxSize) {
      const firstKey = this.cache.keys().next().value as number;
      this.cache.delete(firstKey);
    }
  }
}

// Test cases
const lruCache = new LRUCache(2);

lruCache.put(1, 1); // cache: {1=1}
lruCache.put(2, 2); // cache: {1=1, 2=2}
console.log(lruCache.get(1)); // 1

lruCache.put(3, 3); // cache: {1=1, 3=3}, evict 2
console.log(lruCache.get(2)); // -1

lruCache.put(4, 4); // cache: {3=3, 4=4}, evict 1
console.log(lruCache.get(1)); // -1
console.log(lruCache.get(3)); // 3
console.log(lruCache.get(4)); // 4
