package main.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseLevelOrderTraversal {
    static  void reverseLevelOrder(BinaryTreeNode node){
        if(node == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<BinaryTreeNode > stack = new Stack<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            BinaryTreeNode tmp = queue.poll();
            if(null !=tmp){
                stack.push(tmp);
                if(tmp.getRight() != null)
                    queue.offer(tmp.getRight());
                if(tmp.getLeft() != null)
                    queue.offer(tmp.getLeft());

            }
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop().getData()+" ");
        }
    }

    public static void main(String args[])
    {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();

        // Let us create trees shown in above diagram
        tree.setRoot(new BinaryTreeNode(1));
        tree.getRoot().left = new BinaryTreeNode(2);
        tree.getRoot().right = new BinaryTreeNode(3);
        tree.getRoot().left.left = new BinaryTreeNode(4);
        tree.getRoot().left.right = new BinaryTreeNode(5);
        tree.getRoot().right.left = new BinaryTreeNode(6);
        tree.getRoot().right.right = new BinaryTreeNode(7);

        System.out.println("Level Order traversal of binary tree is :");
        ReverseLevelOrderTraversal.reverseLevelOrder(tree.getRoot());

    }

}
