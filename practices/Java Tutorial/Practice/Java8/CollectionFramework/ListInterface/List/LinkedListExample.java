package Java8.CollectionFramework.ListInterface.List;
// Define the Node class
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Custom LinkedList implementation
class CustomLinkedList {
    private Node head;

    // Constructor for LinkedList
    public CustomLinkedList() {
        this.head = null;
    }

    // Add an element to the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add an element at a specific position
    public void addAtPosition(int data, int position) {
        Node newNode = new Node(data);

        // If adding at the head (position 0)
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        int count = 0;

        //1,2 => add to second place
        // Traverse the list to find the position
        while (current != null && count < position - 1) {
            count++;
            current = current.next;
        }

        // If the current node is not null, insert the new node
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Position out of bounds");
        }
    }

    // Remove an element at a specific position
    public void removeAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty. Nothing to remove.");
            return;
        }

        // If removing the head (position 0)
        if (position == 0) {
            head = head.next;
            return;
        }

        Node current = head;
        Node previous = null;
        int count = 0;

        // Traverse to the desired position
        while (current != null && count < position) {
            count++;
            previous = current;
            current = current.next;
        }

        // If the position is found, remove the node
        if (current != null) {
            previous.next = current.next;
        } else {
            System.out.println("Position out of bounds");
        }
    }

    // Display the elements in the LinkedList
    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Get the size of the LinkedList
    public int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Check if the list contains a specific element
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
}

// Main class to test the LinkedList implementation
public class LinkedListExample {
    public static void main(String[] args) {
        CustomLinkedList list = new CustomLinkedList();

        // Add elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.display(); // Linked List: 10 -> 20 -> 30 -> 40 -> null

        // Add an element at position 2
        list.addAtPosition(25, 2);
        list.display(); // Linked List: 10 -> 20 -> 25 -> 30 -> 40 -> null

        // Remove an element at position 3
        list.removeAtPosition(3);
        list.display(); // Linked List: 10 -> 20 -> 25 -> 40 -> null

        // Try to remove an element at an out-of-bounds position
        list.removeAtPosition(10); // Position out of bounds
    }
}

// In a LinkedList, adding or removing elements at a specific position involves traversing the list to reach the desired index,
// then updating the references accordingly. Below are methods that implement these operations in a custom LinkedList class:

// Adding an element at a specific position
// Removing an element at a specific position


// Key Methods
// 1. addAtPosition(int data, int position):
// This method inserts a new element at a specific position.
// If the position is 0, it adds the element at the head.
// Otherwise, it traverses the list to the node just before the specified position, and inserts the new node.
// 2. removeAtPosition(int position):
// This method removes the element at a specified position.
// If the position is 0, it removes the head.
// Otherwise, it traverses the list to the node just before the specified position, and updates the links to skip the node at 
//that position.
// Time Complexity
// Adding at a specific position:

// If the position is the beginning (0), it's O(1).
// If the position is towards the end, it's O(n) where n is the number of nodes (because you need to traverse the list to the 
//position).
// Removing at a specific position:

// Similar to adding, it's O(1) if you're removing the first element.
// For other positions, it's O(n) since you need to traverse to the correct position.
// By implementing these methods, you can now add and remove elements at specific positions in a linked list!