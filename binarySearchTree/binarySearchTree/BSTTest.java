package binarySearchTree;

public class BSTTest {
    public static void main(String[] args) {
        BST bst = new BST();
        bst.insert(10);
        bst.insert(6);
        bst.insert(15);
        bst.insert(3);
        bst.insert(8);
        bst.insert(20);

        /*
         * 10 6 15 3 8 20
         */

        // int[] tree = bst.DFSPreOrder();
        // for(int item : tree){
        // System.out.print(item + " ");
        // }

        // System.out.println();

        // int[] post = bst.DFSPostOrder();
        // for(int item : post){
        // System.out.print(item + " ");
        // }

        // System.out.println();

        System.out.println("Inorder traversal....");
        int[] in = bst.DFSInOrder();
        for (int item : in) {
            System.out.print(item + " ");
        }
        System.out.println();
        System.out.println("Deleting 6...");
        bst.deleteNode(bst.root, 6);

        System.out.println("Inorder traversal....");
        int[] in2 = bst.DFSInOrder();
        for (int item : in2) {
            System.out.print(item + " ");
        }

    }
}