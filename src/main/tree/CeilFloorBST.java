package main.tree;

public class CeilFloorBST {
    static class NodeWrapper {
        BinaryTreeNode node;

        NodeWrapper() {
            this.node = new BinaryTreeNode(-1);
        }
    }

    // Recursive function to insert an key into BST
    public static BinaryTreeNode insert(BinaryTreeNode root, int key) {
        // if the root is null, create a new node an return it
        if (root == null) {
            return new BinaryTreeNode(key);
        }

        // if given key is less than the root node, recur for left subtree
        if (key < root.getData()) {
            root.setLeft(insert(root.getLeft(), key));
        }

        // if given key is more than the root node, recur for right subtree
        else {
            root.setRight(insert(root.getRight(), key));
        }

        return root;
    }


    private static void ceilOrFloor(BinaryTreeNode root, NodeWrapper ceil, NodeWrapper floor, int key) {

        while (null != root) {
            if (root.getData() == key) {
                ceil.node = root;
                floor.node = root;
                break;
            }

            if (key < root.getData()) {
                ceil.node = root;
                root = root.getLeft();
            } else {
                floor.node = root;
                root = root.getRight();
            }
        }
    }

    public static void main(String[] args) {
        int[] keys = {2, 4, 6, 8, 9, 10, 12};

        BinaryTreeNode root = null;
        for (int key : keys) {
            root = insert(root, key);
        }

        NodeWrapper floor = new NodeWrapper();
        NodeWrapper ceil = new NodeWrapper();

        ceilOrFloor(root, ceil, floor, 3);
        System.out.println(" Floor is " + floor.node.getData() + ", Ceil is "
                + ceil.node.getData());

    }
}
