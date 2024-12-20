package Java8.CollectionFramework.ListInterface.Set.TreeSet;

class MyTreeSet {
    private Node root;  // Root of the binary search tree (BST)
    private int size;

    // Node class representing each node of the tree
    private class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
            left = right = null;
        }
    }

    // Constructor to initialize the TreeSet
    public MyTreeSet() {
        root = null;
        size = 0;
    }

    // Add an element to the TreeSet (insert in the binary search tree)
    public boolean add(int value) {
        if (contains(value)) {
            return false;  // No duplicates allowed
        }
        root = insert(root, value);
        size++;
        return true;
    }

    // Helper function to insert a value into the binary search tree
    private Node insert(Node node, int value) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        }

        return node;  // Return the unchanged node pointer
    }

    // Check if the TreeSet contains a value (search in the binary search tree)
    public boolean contains(int value) {
        return search(root, value);
    }

    // Helper function to search for a value in the binary search tree
    private boolean search(Node node, int value) {
        if (node == null) {
            return false;  // Base case: value not found
        }

        if (value == node.value) {
            return true;  // Value found
        } else if (value < node.value) {
            return search(node.left, value);  // Search in the left subtree
        } else {
            return search(node.right, value);  // Search in the right subtree
        }
    }

    // Remove an element from the TreeSet (delete from the binary search tree)
    public boolean remove(int value) {
        if (!contains(value)) {
            return false;  // Value not found, nothing to remove
        }
        root = delete(root, value);
        size--;
        return true;
    }

    // Helper function to delete a value from the binary search tree
    private Node delete(Node node, int value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            node.left = delete(node.left, value);
        } else if (value > node.value) {
            node.right = delete(node.right, value);
        } else {
            // Node to be deleted found

            // Case 1: Node with only one child or no child
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Case 2: Node with two children
            // Get the smallest value in the right subtree (in-order successor)
            node.value = findMin(node.right);
            // Delete the in-order successor
            node.right = delete(node.right, node.value);
        }

        return node;
    }

    // Helper function to find the minimum value in the subtree
    private int findMin(Node node) {
        int min = node.value;
        while (node.left != null) {
            node = node.left;
            min = node.value;
        }
        return min;
    }

    // Get the size of the TreeSet
    public int size() {
        return size;
    }

    // In-order traversal of the binary search tree (to display elements in sorted order)
    public void display() {
        System.out.print("TreeSet: ");
        inOrderTraversal(root);
        System.out.println();
    }

    // Helper function for in-order traversal of the tree
    private void inOrderTraversal(Node node) {
        if (node != null) {
            inOrderTraversal(node.left);  // Traverse the left subtree
            System.out.print(node.value + " ");  // Print the current node
            inOrderTraversal(node.right);  // Traverse the right subtree
        }
    }
}

// Test the MyTreeSet class
public class TreeSet {
    public static void main(String[] args) {
        MyTreeSet myTreeSet = new MyTreeSet();

        // Add elements to the TreeSet
        myTreeSet.add(10);
        myTreeSet.add(5);
        myTreeSet.add(15);
        myTreeSet.add(3);
        myTreeSet.add(8);

        // Display the TreeSet (elements should be in sorted order)
        System.out.println("TreeSet after adding elements:");
        myTreeSet.display();

        // Check for element existence
        System.out.println("Does TreeSet contain 8? " + myTreeSet.contains(8));
        System.out.println("Does TreeSet contain 20? " + myTreeSet.contains(20));

        // Remove an element from the TreeSet
        myTreeSet.remove(5);
        System.out.println("TreeSet after removing 5:");
        myTreeSet.display();

        // Check the size of the TreeSet
        System.out.println("Current size of TreeSet: " + myTreeSet.size());
    }
}

