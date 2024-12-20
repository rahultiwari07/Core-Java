package Java8.CollectionFramework.Map.TreeMap;

import java.util.*;

public class MyTreeMap<K extends Comparable<K>, V> {

    private TreeNode<K, V> root;
    private int size = 0;

    // TreeNode class representing a node in the red-black tree
    static class TreeNode<K, V> {
        K key;
        V value;
        TreeNode<K, V> left, right;

        public TreeNode(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Insert a key-value pair into the tree map
    public void put(K key, V value) {
        root = put(root, key, value);
    }

    private TreeNode<K, V> put(TreeNode<K, V> node, K key, V value) {
        if (node == null) {
            size++;
            return new TreeNode<>(key, value);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.value = value; // Update value if key already exists
        }
        return node;
    }

    // Retrieve the value associated with the key
    public V get(K key) {
        TreeNode<K, V> node = get(root, key);
        return (node == null) ? null : node.value;
    }

    private TreeNode<K, V> get(TreeNode<K, V> node, K key) {
        if (node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node;
        }
    }

    // Remove a key-value pair from the map
    public void remove(K key) {
        root = remove(root, key);
    }

    private TreeNode<K, V> remove(TreeNode<K, V> node, K key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = remove(node.left, key);
        } else if (cmp > 0) {
            node.right = remove(node.right, key);
        } else {
            // Node with only one child or no child
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            TreeNode<K, V> temp = min(node.right);
            node.key = temp.key;
            node.value = temp.value;
            node.right = remove(node.right, temp.key);
        }
        return node;
    }

    // Find the minimum node in the tree
    private TreeNode<K, V> min(TreeNode<K, V> node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Retrieve the size of the tree map
    public int size() {
        return size;
    }

    // Get the first (lowest) key
    public K firstKey() {
        if (root == null) throw new NoSuchElementException();
        return min(root).key;
    }

    // Get the last (highest) key
    public K lastKey() {
        if (root == null) throw new NoSuchElementException();
        TreeNode<K, V> node = root;
        while (node.right != null) {
            node = node.right;
        }
        return node.key;
    }

    // Print the TreeMap (In-order traversal to print sorted keys)
    public void printTreeMap() {
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(TreeNode<K, V> node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print("[" + node.key + " -> " + node.value + "] ");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        MyTreeMap<String, Integer> treeMap = new MyTreeMap<>();

        // Inserting elements
        treeMap.put("Banana", 2);
        treeMap.put("Apple", 1);
        treeMap.put("Mango", 3);
        treeMap.put("Pineapple", 5);

        // Print TreeMap in sorted order
        treeMap.printTreeMap(); // Should print keys in alphabetical order

        // Retrieve values
        System.out.println("Value for 'Apple': " + treeMap.get("Apple"));
        System.out.println("First key: " + treeMap.firstKey());
        System.out.println("Last key: " + treeMap.lastKey());

        // Remove an element
        treeMap.remove("Mango");
        System.out.println("After removing 'Mango':");
        treeMap.printTreeMap();
    }
}
