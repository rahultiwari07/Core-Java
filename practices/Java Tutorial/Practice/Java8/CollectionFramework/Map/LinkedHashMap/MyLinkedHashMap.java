package Java8.CollectionFramework.Map.LinkedHashMap;

import java.util.*;

public class MyLinkedHashMap<K, V> {
    private Entry<K, V>[] table;
    private Entry<K, V> head, tail;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;

    // Entry class representing key-value pairs in the hash table
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;  // Used for chaining (hash collisions)
        Entry<K, V> before, after; // Doubly linked list pointers

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // Constructor
    public MyLinkedHashMap() {
        table = new Entry[INITIAL_CAPACITY];
    }

    // Hash function to determine the index for a given key
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    // Add a key-value pair to the map
    public void put(K key, V value) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        
        // Check if the key already exists, and if so, update the value
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }

        // Insert a new entry in the hash table (chaining for collisions)
        Entry<K, V> newEntry = new Entry<>(key, value, table[index]);
        table[index] = newEntry;
        size++;

        // Maintain insertion order in a doubly linked list
        if (tail == null) {
            head = tail = newEntry;
        } else {
            tail.after = newEntry;
            newEntry.before = tail;
            tail = newEntry;
        }
    }

    // Retrieve the value associated with a given key
    public V get(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];

        // Traverse the linked list at this index to find the key
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null; // Key not found
    }

    // Remove a key-value pair from the map
    public V remove(K key) {
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> previous = null;

        // Traverse the linked list to find the key
        while (entry != null) {
            if (entry.key.equals(key)) {
                // Remove from hash table
                if (previous == null) {
                    table[index] = entry.next; // Removing the head of the chain
                } else {
                    previous.next = entry.next;
                }

                // Remove from doubly linked list (order preservation)
                if (entry.before == null) {
                    head = entry.after; // Removing head of linked list
                } else {
                    entry.before.after = entry.after;
                }
                if (entry.after == null) {
                    tail = entry.before; // Removing tail of linked list
                } else {
                    entry.after.before = entry.before;
                }

                size--;
                return entry.value;
            }
            previous = entry;
            entry = entry.next;
        }

        return null; // Key not found
    }

    // Get the size of the LinkedHashMap
    public int size() {
        return size;
    }

    // Print the entire LinkedHashMap (in insertion order)
    public void printLinkedHashMap() {
        Entry<K, V> current = head;
        while (current != null) {
            System.out.print("[" + current.key + " -> " + current.value + "] ");
            current = current.after;
        }
        System.out.println();
    }

    public static void LinkedHashMap(String[] args) {
        MyLinkedHashMap<String, Integer> linkedHashMap = new MyLinkedHashMap<>();

        // Adding elements to LinkedHashMap
        linkedHashMap.put("Apple", 10);
        linkedHashMap.put("Banana", 20);
        linkedHashMap.put("Mango", 30);
        linkedHashMap.put("Apple", 40); // Updating the value of 'Apple'

        // Printing LinkedHashMap
        linkedHashMap.printLinkedHashMap(); // Output will preserve insertion order

        // Retrieving a value
        System.out.println("Value for 'Banana': " + linkedHashMap.get("Banana"));

        // Removing an element
        linkedHashMap.remove("Mango");
        System.out.println("After removing 'Mango':");
        linkedHashMap.printLinkedHashMap();

        // Printing the size
        System.out.println("Size of LinkedHashMap: " + linkedHashMap.size());
    }
}
