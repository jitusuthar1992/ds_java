package main.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jitendra.kumar01
 * 01/02/20
 */
public class MirrorOfBinaryTree {

    public BinaryTreeNode mirrorOfTreeSol1(BinaryTreeNode root){
        BinaryTreeNode temp;
        if(null != root){
            mirrorOfTreeSol1(root.left);
            mirrorOfTreeSol1(root.right);

            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    public BinaryTreeNode mirrorOfTreeUsingStack(BinaryTreeNode root){
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode parent;
        stack.push(root);

        while (!stack.isEmpty()){
            parent = stack.pop();
            BinaryTreeNode tmp = parent.left;
            parent.left = parent.right;
            parent.right = tmp;

            if(parent.right != null){
                stack.push(parent.right);
            }
            if (parent.left != null) {
                stack.push(parent.left);
            }

        }
        return root;
    }

    public BinaryTreeNode mirrorOfTreeUsingQueue(BinaryTreeNode root){

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            BinaryTreeNode temp = queue.poll();

            if((temp == null) && (temp.left ==null && temp.right == null)){
                continue;
            }

            if(temp.left != null && temp.right != null){
                BinaryTreeNode node = temp.left;
                temp.left = temp.right;
                temp.right= node;

                queue.offer(temp.left);
                queue.offer(temp.right);
            }

            if(temp.left == null ){
                temp.left = temp.right;
                temp.right = null;
                queue.offer(temp.left);
            }
            if(temp.right == null ){
                temp.right = temp.left;
                temp.left = null;
                queue.offer(temp.right);
            }

        }
        return root;
    }
}
