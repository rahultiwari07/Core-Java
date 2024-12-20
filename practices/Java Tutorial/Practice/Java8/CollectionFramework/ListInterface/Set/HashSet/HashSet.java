package Java8.CollectionFramework.ListInterface.Set.HashSet;

import java.util.LinkedList;

class MyHashSet {
    // Define the initial capacity of the HashSet (size of hash table)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Integer>[] bucketArray;
    private int size;

    // Constructor to initialize the hash set
    public MyHashSet() {
        // Create an array of linked lists (to handle collisions via chaining)
        bucketArray = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // A simple hash function that maps a value to an index
    private int getHash(int key) {
        return key % INITIAL_CAPACITY;
    }

    // Add an element to the HashSet
    public void add(int key) {
        int index = getHash(key);

        // If the bucket is empty, create a new linked list
        if (bucketArray[index] == null) {
            bucketArray[index] = new LinkedList<>();
        }

        // Check if the key already exists
        if (!bucketArray[index].contains(key)) {
            bucketArray[index].add(key);
            size++;
        }
    }

    // Remove an element from the HashSet
    public void remove(int key) {
        int index = getHash(key);

        // If the bucket exists, attempt to remove the element
        if (bucketArray[index] != null) {
            boolean removed = bucketArray[index].remove((Integer) key);
            if (removed) {
                size--;
            }
        }
    }

    // Check if the HashSet contains an element
    public boolean contains(int key) {
        int index = getHash(key);

        // If the bucket is empty, the element doesn't exist
        if (bucketArray[index] == null) {
            return false;
        }

        // Check if the element exists in the linked list at the index
        return bucketArray[index].contains(key);
    }

    // Get the current size of the HashSet
    public int size() {
        return size;
    }

    // Clear the HashSet
    public void clear() {
        bucketArray = new LinkedList[INITIAL_CAPACITY];
        size = 0;
    }

    // Display the elements in the HashSet (for testing)
    public void display() {
        for (int i = 0; i < bucketArray.length; i++) {
            if (bucketArray[i] != null && !bucketArray[i].isEmpty()) {
                System.out.println("Bucket " + i + ": " + bucketArray[i]);
            }
        }
    }
}

// Test the MyHashSet class
public class HashSet {
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        
        // Add elements to the HashSet
        myHashSet.add(5);
        myHashSet.add(10);
        myHashSet.add(15);
        myHashSet.add(5);  // Attempting to add a duplicate element

        // Display the HashSet
        System.out.println("HashSet after adding elements:");
        myHashSet.display();

        // Check for element existence
        System.out.println("Does HashSet contain 10? " + myHashSet.contains(10));
        System.out.println("Does HashSet contain 7? " + myHashSet.contains(7));

        // Remove an element from the HashSet
        myHashSet.remove(10);
        System.out.println("HashSet after removing 10:");
        myHashSet.display();

        // Check the size of the HashSet
        System.out.println("Current size of HashSet: " + myHashSet.size());
        
        // Clear the HashSet
        myHashSet.clear();
        System.out.println("HashSet after clearing:");
        myHashSet.display();
    }
}


// public class RemoveDuplicates {
//     public static void main(String[] args) {
//         int[] numbers = {5, 3, 7, 1, 3, 9, 7, 6, 2, 5};

//         // Use a HashSet to remove duplicates
//         Set<Integer> uniqueNumbers = new HashSet<>();
        
//         // Adding all numbers to the set (duplicates will automatically be removed)
//         for (int number : numbers) {
//             uniqueNumbers.add(number);
//         }

//         // Display the unique numbers
//         System.out.println("Unique numbers: " + uniqueNumbers);
//     }
// }