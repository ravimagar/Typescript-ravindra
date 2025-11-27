/**
 * Question 13: Implement LRU Cache
 * Problem: Implement a Least Recently Used (LRU) Cache
 * 
 * Operations:
 * - get(key): Return value if key exists, else -1
 * - put(key, value): Update or insert, evict LRU if full
 */

import java.util.*;

public class LRUCache {
    
    private int maxSize;
    private Map<Integer, Integer> cache;
    
    public LRUCache(int capacity) {
        this.maxSize = capacity;
        // LinkedHashMap maintains insertion order
        this.cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > maxSize;
            }
        };
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        cache.put(key, value);
    }
    
    @Override
    public String toString() {
        return cache.toString();
    }
}

// Manual implementation with Doubly Linked List
class LRUCacheManual {
    
    private class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private int maxSize;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;
    
    public LRUCacheManual(int capacity) {
        this.maxSize = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        
        Node node = cache.get(key);
        removeNode(node);
        addToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            
            if (cache.size() > maxSize) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
        }
    }
    
    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class LRUCacheTest {
    public static void main(String[] args) {
        // Test LinkedHashMap based implementation
        LRUCache lru = new LRUCache(2);
        
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // 1
        
        lru.put(3, 3); // Evict 2
        System.out.println(lru.get(2)); // -1
        
        lru.put(4, 4); // Evict 1
        System.out.println(lru.get(1)); // -1
        System.out.println(lru.get(3)); // 3
        System.out.println(lru.get(4)); // 4
        
        System.out.println("\n--- Manual Implementation ---");
        
        LRUCacheManual lruManual = new LRUCacheManual(2);
        
        lruManual.put(1, 1);
        lruManual.put(2, 2);
        System.out.println(lruManual.get(1)); // 1
        
        lruManual.put(3, 3); // Evict 2
        System.out.println(lruManual.get(2)); // -1
        
        lruManual.put(4, 4); // Evict 1
        System.out.println(lruManual.get(1)); // -1
        System.out.println(lruManual.get(3)); // 3
        System.out.println(lruManual.get(4)); // 4
    }
}
