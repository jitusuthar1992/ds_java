package main.tree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversalBT {

    static void diagonalTraversal(BinaryTreeNode root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (tmp != null) {
                while (tmp != null) {
                    System.out.print(tmp.getData() + " ");
                    if (null != tmp.getLeft())
                        q.offer(tmp.getLeft());
                    tmp = tmp.getRight();
                }
            } else {
                if (q.isEmpty())
                    return;
                System.out.println();
                q.offer(null);
            }
        }
    }

    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(14);
        root.right.right.left = new BinaryTreeNode(13);
        root.left.right.left = new BinaryTreeNode(4);
        root.left.right.right = new BinaryTreeNode(7);
        diagonalTraversal(root);
    }
}
