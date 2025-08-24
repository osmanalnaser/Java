package Datenstrukturen;

public class BinarySearchTreeApplication {
    public static void main(String[] args) {

        BinarySearchTree root = new BinarySearchTree(45);

        root.left = new BinarySearchTree(13);
        root.right = new BinarySearchTree(100);

        root.left.left = new BinarySearchTree(9);
        root.left.right = new BinarySearchTree(26);

        root.right.left = new BinarySearchTree(94);
        root.right.right = new BinarySearchTree(102);

        root.right.left.left = new BinarySearchTree(63);

        // Ausgabe in inorder
        BinarySearchTreeUtils.printNodes(root);
    }
}
