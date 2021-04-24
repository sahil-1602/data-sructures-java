package binarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BST {

    Node root;

    public void insert(int data) {
        Node current = root;
        Node newNode = new Node(data);
        if (isEmpty()) {
            root = newNode;
            return;
        }
        while (true) {
            if (newNode.data == current.data)
                return;
            if (newNode.data < current.data) {
                if (current.left == null) {
                    current.left = newNode;
                    return;
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = newNode;
                    return;
                }
                current = current.right;
            }
        }
    }

    public boolean contains(int data) {
        Node value = new Node(data);
        Node current = root;
        if (root == null)
            return false;
        boolean found = false;
        while (current != null && !found) {
            if (value.data < current.data)
                current = current.left;
            else if (value.data > current.data)
                current = current.right;
            else
                found = true;
        }
        return found;
    }

    public int[] breadthFirstSearch() {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        if (isEmpty())
            return null;
        q.add(root);
        while (!q.isEmpty()) {
            Node visiting = (Node) q.remove();
            visited.add(visiting.data);
            if (visiting.left != null)
                q.add(visiting.left);
            if (visiting.right != null)
                q.add(visiting.right);
        }
        int[] tree = new int[visited.toArray().length];
        for (int i = 0; i < visited.toArray().length; i++) {
            tree[i] = visited.get(i);
        }
        return tree;
    }

    public int[] DFSPreOrder() {
        ArrayList<Integer> data = new ArrayList<>();
        data = traversePre(root, data);
        int[] tree = new int[data.toArray().length];
        for (int i = 0; i < data.toArray().length; i++) {
            tree[i] = data.get(i);
        }
        return tree;
    }

    public int[] DFSPostOrder() {
        ArrayList<Integer> data = new ArrayList<>();
        data = traversePost(root, data);
        int[] tree = new int[data.toArray().length];
        for (int i = 0; i < data.toArray().length; i++) {
            tree[i] = data.get(i);
        }
        return tree;

    }

    public int[] DFSInOrder() {
        ArrayList<Integer> data = new ArrayList<>();
        data = traverseIn(root, data);
        int[] tree = new int[data.toArray().length];
        for (int i = 0; i < data.toArray().length; i++) {
            tree[i] = data.get(i);
        }
        return tree;

    }

    ArrayList<Integer> traversePre(Node current, ArrayList<Integer> data) {
        data.add(current.data);
        if (current.left != null)
            traversePre(current.left, data);
        if (current.right != null)
            traversePre(current.right, data);
        return data;
    }

    ArrayList<Integer> traversePost(Node current, ArrayList<Integer> data) {
        if (current.left != null)
            traversePost(current.left, data);
        if (current.right != null)
            traversePost(current.right, data);
        data.add(current.data);
        return data;
    }

    ArrayList<Integer> traverseIn(Node current, ArrayList<Integer> data) {
        if (current.left != null)
            traverseIn(current.left, data);
        data.add(current.data);
        if (current.right != null)
            traverseIn(current.right, data);
        return data;
    }

    // 10
    // 6 15
    // 3 8 20
    boolean isEmpty() {
        return root == null;
    }

    /*
     * Code for deletion of a node in BST case 1: Node to be deleted is a leaf node
     * case 2: Node to be deleted has 1 child - either left or right case 3: Node to
     * be deleted has 2 child - (inorder predecessor or inorder successor)
     */

    // Helper function for finding :
    // inorder successor (smallest node in the right subtree of the node to be
    // deleted)

    Node inorderSuccessor(Node root) {
        // base case
        if (root.left == null)
            return root;
        else
            return inorderSuccessor(root.left);
    }

    Node deleteNode(Node rootNode, int value) {

        if (rootNode == null)
            return null;

        else if (rootNode.data > value) {

            // if value is less than rootNode move to left
            rootNode.left = deleteNode(rootNode.left, value);

        } else if (rootNode.data < value) {

            // if value is greater than rootNode move to right
            rootNode.right = deleteNode(rootNode.right, value);

        } else {

            // if node to be deleted has 2 child
            if (rootNode.left != null && rootNode.right != null) {
                Node temp = rootNode;

                // finding the minimum element from the right subtree of rootNode
                Node succesor = inorderSuccessor(temp.right);
                System.out.println("Replacing " + rootNode.data + " with " + succesor.data);

                // replacing the node to be deleted with the minimum element (successor)
                rootNode.data = succesor.data;

                // deleting successor from its position
                rootNode.right = deleteNode(rootNode.right, succesor.data);
            }

            // if node has 1 left child
            else if (rootNode.left != null) {
                rootNode = rootNode.left;
            }

            // if node has 1 right child
            else if (rootNode.right != null) {
                rootNode = rootNode.right;
            }

            // if node is a leaf node (no child)
            else {
                rootNode = null;
            }
        }
        return rootNode;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}