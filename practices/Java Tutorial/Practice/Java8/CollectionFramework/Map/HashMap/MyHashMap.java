package Java8.CollectionFramework.Map.HashMap;

import java.util.Objects;

public class MyHashMap<K, V> {

    // Default initial capacity and load factor
    private static final int INITIAL_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    // The array to store hash table entries
    private Entry<K, V>[] table;
    private int size = 0;

    // Threshold for resizing the table
    private int threshold;

    // Constructor
    public MyHashMap() {
        this.table = new Entry[INITIAL_CAPACITY];
        this.threshold = (int) (INITIAL_CAPACITY * LOAD_FACTOR);
    }

    // Entry class to store key-value pairs
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    // Hash function to compute index for the key
    private int hash(K key) {
        return (key == null) ? 0 : Math.abs(key.hashCode() % table.length);
    }

    // Put key-value pair into the HashMap
    public void put(K key, V value) {
        int index = hash(key);

        // Check if the key already exists and update value
        Entry<K, V> entry = table[index];
        while (entry != null) {
            if (Objects.equals(entry.getKey(), key)) {
                entry.setValue(value);
                return;
            }
            entry = entry.next;
        }

        // Insert the new entry at the beginning of the chain (linked list)
        Entry<K, V> newEntry = new Entry<>(key, value, table[index]);
        table[index] = newEntry;
        size++;

        // Check if we need to resize
        if (size > threshold) {
            resize();
        }
    }

    // Get the value for a given key
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        // Traverse the chain (linked list) to find the key
        while (entry != null) {
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
            entry = entry.next;
        }

        return null; // Key not found
    }

    // Remove a key-value pair from the HashMap
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> previous = null;

        // Traverse the chain to find the entry to remove
        while (entry != null) {
            if (Objects.equals(entry.getKey(), key)) {
                if (previous == null) {
                    // Remove the head of the chain
                    table[index] = entry.next;
                } else {
                    // Bypass the current entry
                    previous.next = entry.next;
                }
                size--;
                return entry.getValue();
            }
            previous = entry;
            entry = entry.next;
        }

        return null; // Key not found
    }

    // Resize the hash table when the load factor threshold is exceeded
    private void resize() {
        int newCapacity = table.length * 2;
        Entry<K, V>[] newTable = new Entry[newCapacity];
        threshold = (int) (newCapacity * LOAD_FACTOR);

        // Rehash all existing entries
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            while (entry != null) {
                Entry<K, V> next = entry.next;
                int index = (entry.getKey() == null) ? 0 : Math.abs(entry.getKey().hashCode() % newCapacity);

                // Insert entry into the new table
                entry.next = newTable[index];
                newTable[index] = entry;

                entry = next;
            }
        }

        table = newTable; // Replace the old table with the new one
    }

    // Get the number of key-value pairs in the HashMap
    public int size() {
        return size;
    }

    // Check if the HashMap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print the entire HashMap (for debugging purposes)
    public void printMap() {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            if (entry != null) {
                System.out.print("Bucket " + i + ": ");
                while (entry != null) {
                    System.out.print("[" + entry.getKey() + " -> " + entry.getValue() + "] ");
                    entry = entry.next;
                }
                System.out.println();
            }
        }
    }

    public static void HashMap(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Alice", 23);
        map.put("Bob", 34);
        map.put("Charlie", 45);
        map.put("David", 56);
        map.put("Eve", 67);

        // Print the map
        map.printMap();

        // Get value for a key
        System.out.println("Value for 'Bob': " + map.get("Bob"));

        // Remove a key-value pair
        System.out.println("Removed value for 'Charlie': " + map.remove("Charlie"));

        // Print the map again after removal
        map.printMap();
    }
}

