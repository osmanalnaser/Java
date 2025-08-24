package Datenstrukturen;

public class BinarySearchTreeUtils {

    public static void printNodes(BinarySearchTree root) {
        if (root == null) return;

        printNodes(root.left);
        System.out.print(root.value + ",");
        printNodes(root.right);
    }
}

