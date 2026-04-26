class HashNode<K, V> {
    K key;
    V value;
    HashNode<K, V> next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class CustomHashMap<K, V> {
    private HashNode<K, V>[] bucketArray;
    private int numBuckets;
    private int size;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        bucketArray = new HashNode[10];
        numBuckets = 10;
        size = 0;
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index < 0 ? index * -1 : index;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex];

        // Check if key is already present
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key into the chain
        size++;
        head = bucketArray[bucketIndex];
        HashNode<K, V> newNode = new HashNode<>(key, value);
        newNode.next = head;
        bucketArray[bucketIndex] = newNode;
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray[bucketIndex];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }
            prev = head;
            head = head.next;
        }

        if (head == null) return null;

        size--;
        if (prev != null) {
            prev.next = head.next;
        } else {
            bucketArray[bucketIndex] = head.next;
        }

        return head.value;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);

        System.out.println("Value for 'Two': " + map.get("Two"));
        System.out.println("Removed 'One', value was: " + map.remove("One"));
        System.out.println("Size after removal: " + map.getSize());
        System.out.println("Value for 'One': " + map.get("One"));
    }
}
