package Java8.CollectionFramework.ListInterface.Set.LinkedHashSet;

import java.util.LinkedList;

class MyLinkedHashSet {
    // Define the initial capacity of the LinkedHashSet (size of hash table)
    private static final int INITIAL_CAPACITY = 16;
    private LinkedList<Integer>[] bucketArray;  // For storing elements
    private Node head, tail;  // Doubly linked list nodes for maintaining insertion order
    private int size;

    // Constructor to initialize the LinkedHashSet
    public MyLinkedHashSet() {
        // Create an array of linked lists (to handle collisions via chaining)
        bucketArray = new LinkedList[INITIAL_CAPACITY];
        size = 0;
        head = null;
        tail = null;
    }

    // Node class for doubly linked list
    private class Node {
        int key;
        Node next, prev;

        Node(int key) {
            this.key = key;
            this.next = null;
            this.prev = null;
        }
    }

    // A simple hash function that maps a value to an index
    private int getHash(int key) {
        return key % INITIAL_CAPACITY;
    }

    // Add an element to the LinkedHashSet
    public void add(int key) {
        int index = getHash(key);

        // If the bucket is empty, create a new linked list
        if (bucketArray[index] == null) {
            bucketArray[index] = new LinkedList<>();
        }

        // Check if the key already exists in the HashSet
        if (!bucketArray[index].contains(key)) {
            // Add the key to the hash table (bucket array)
            bucketArray[index].add(key);
            size++;

            // Insert the new node at the end of the doubly linked list
            Node newNode = new Node(key);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }
    }

    // Remove an element from the LinkedHashSet
    public void remove(int key) {
        int index = getHash(key);

        // If the bucket exists, attempt to remove the element
        if (bucketArray[index] != null) {
            boolean removed = bucketArray[index].remove((Integer) key);
            if (removed) {
                size--;

                // Remove the element from the doubly linked list
                Node current = head;
                while (current != null) {
                    if (current.key == key) {
                        if (current.prev != null) {
                            current.prev.next = current.next;
                        } else {
                            head = current.next;  // Update head if needed
                        }
                        if (current.next != null) {
                            current.next.prev = current.prev;
                        } else {
                            tail = current.prev;  // Update tail if needed
                        }
                        break;
                    }
                    current = current.next;
                }
            }
        }
    }

    // Check if the LinkedHashSet contains an element
    public boolean contains(int key) {
        int index = getHash(key);

        // If the bucket is empty, the element doesn't exist
        if (bucketArray[index] == null) {
            return false;
        }

        // Check if the element exists in the linked list at the index
        return bucketArray[index].contains(key);
    }

    // Get the current size of the LinkedHashSet
    public int size() {
        return size;
    }

    // Clear the LinkedHashSet
    public void clear() {
        bucketArray = new LinkedList[INITIAL_CAPACITY];
        head = null;
        tail = null;
        size = 0;
    }

    // Display the elements in the LinkedHashSet in insertion order
    public void display() {
        Node current = head;
        System.out.print("LinkedHashSet: ");
        while (current != null) {
            System.out.print(current.key + " ");
            current = current.next;
        }
        System.out.println();
    }
}

// Test the MyLinkedHashSet class
public class LinkedHashSet {
    public static void main(String[] args) {
        MyLinkedHashSet myLinkedHashSet = new MyLinkedHashSet();
        
        // Add elements to the LinkedHashSet
        myLinkedHashSet.add(5);
        myLinkedHashSet.add(10);
        myLinkedHashSet.add(15);
        myLinkedHashSet.add(5);  // Duplicate, should not be added

        // Display the LinkedHashSet (insertion order should be maintained)
        System.out.println("LinkedHashSet after adding elements:");
        myLinkedHashSet.display();

        // Check for element existence
        System.out.println("Does LinkedHashSet contain 10? " + myLinkedHashSet.contains(10));
        System.out.println("Does LinkedHashSet contain 7? " + myLinkedHashSet.contains(7));

        // Remove an element from the LinkedHashSet
        myLinkedHashSet.remove(10);
        System.out.println("LinkedHashSet after removing 10:");
        myLinkedHashSet.display();

        // Check the size of the LinkedHashSet
        System.out.println("Current size of LinkedHashSet: " + myLinkedHashSet.size());
        
        // Clear the LinkedHashSet
        myLinkedHashSet.clear();
        System.out.println("LinkedHashSet after clearing:");
        myLinkedHashSet.display();
    }
}
