import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Dummy head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        if (cache.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        cache.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        cache.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1);
        lru.put(2, 2);
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3); // evicts key 2
        System.out.println(lru.get(2)); // returns -1 (not found)
        lru.put(4, 4); // evicts key 1
        System.out.println(lru.get(1)); // returns -1 (not found)
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }
}
