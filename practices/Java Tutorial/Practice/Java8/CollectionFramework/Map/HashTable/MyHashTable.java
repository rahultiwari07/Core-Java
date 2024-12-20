package Java8.CollectionFramework.Map.HashTable;

public class MyHashTable<K, V> {
    
    private Entry<K, V>[] table;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 16;
    
    // Constructor
    public MyHashTable() {
        table = new Entry[INITIAL_CAPACITY];
    }
    
    // Entry class to store key-value pairs
    static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;
        
        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    
    // Hash function to compute index
    private int hash(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }
    
    // Put method to add key-value pair
    public synchronized void put(K key, V value) {
        if (key == null || value == null) {
            throw new NullPointerException("Null keys and values are not allowed in HashTable");
        }
        
        int index = hash(key);
        Entry<K, V> entry = table[index];
        
        // Check if the key already exists, if so, update value
        while (entry != null) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
            entry = entry.next;
        }
        
        // Insert a new entry at the head of the linked list for this index
        Entry<K, V> newEntry = new Entry<>(key, value, table[index]);
        table[index] = newEntry;
        size++;
    }
    
    // Get method to retrieve value by key
    public synchronized V get(K key) {
        if (key == null) {
            throw new NullPointerException("Null keys are not allowed in HashTable");
        }
        
        int index = hash(key);
        Entry<K, V> entry = table[index];
        
        // Traverse the linked list to find the key
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
            entry = entry.next;
        }
        
        return null; // Key not found
    }
    
    // Remove method to delete key-value pair
    public synchronized V remove(K key) {
        if (key == null) {
            throw new NullPointerException("Null keys are not allowed in HashTable");
        }
        
        int index = hash(key);
        Entry<K, V> entry = table[index];
        Entry<K, V> previous = null;
        
        // Traverse the linked list to find the entry to remove
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (previous == null) {
                    // Removing the head of the linked list
                    table[index] = entry.next;
                } else {
                    // Bypass the entry to remove it
                    previous.next = entry.next;
                }
                size--;
                return entry.value;
            }
            previous = entry;
            entry = entry.next;
        }
        
        return null; // Key not found
    }
    
    // Check if the HashTable contains a specific key
    public synchronized boolean containsKey(K key) {
        return get(key) != null;
    }
    
    // Get the size of the HashTable
    public synchronized int size() {
        return size;
    }
    
    // Print the entire HashTable (for debugging purposes)
    public synchronized void printTable() {
        for (int i = 0; i < table.length; i++) {
            Entry<K, V> entry = table[i];
            if (entry != null) {
                System.out.print("Bucket " + i + ": ");
                while (entry != null) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                    entry = entry.next;
                }
                System.out.println();
            }
        }
    }

    public static void HashTable(String[] args) {
        MyHashTable<String, Integer> hashTable = new MyHashTable<>();
        
        hashTable.put("Apple", 10);
        hashTable.put("Banana", 20);
        hashTable.put("Mango", 30);
        hashTable.put("Apple", 40); // Update the value for 'Apple'
        
        // Print the HashTable
        hashTable.printTable();
        
        // Get value for a key
        System.out.println("Value for 'Banana': " + hashTable.get("Banana"));
        
        // Remove a key-value pair
        System.out.println("Removed value for 'Mango': " + hashTable.remove("Mango"));
        
        // Check if a key exists
        System.out.println("Contains key 'Apple'? " + hashTable.containsKey("Apple"));
        
        // Print size
        System.out.println("Size of HashTable: " + hashTable.size());
    }
}

