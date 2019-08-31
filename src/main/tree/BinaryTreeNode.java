package main.tree;

public class BinaryTreeNode {
    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private int data;

    public BinaryTreeNode(BinaryTreeNode left, BinaryTreeNode right, int data) {
        this.left = left;
        this.right = right;
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
