package main.tree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightBinaryTree {
    static int height(BinaryTreeNode root){

        if(root==null)
            return 0;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height =0;

        while (1==1){
            int nodeCount =queue.size();

            if(nodeCount==0)
                return height;
            height++;
            while (nodeCount-- >0){
                BinaryTreeNode tmp = queue.poll();
                if(tmp.getLeft() != null)
                    queue.add(tmp.getLeft());
                if (tmp.getRight() != null)
                    queue.add(tmp.getRight());

            }
        }
    }

    public static void main(String args[])
    {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        // Let us create a binary tree shown in above diagram
        tree.setRoot(new BinaryTreeNode(1));
        tree.getRoot().left = new BinaryTreeNode(2);
        tree.getRoot().right = new BinaryTreeNode(3);
        tree.getRoot().left.left = new BinaryTreeNode(4);
        tree.getRoot().left.right = new BinaryTreeNode(5);
        System.out.println("Height of tree is " + HeightBinaryTree.height(tree.getRoot()));
    }
}
