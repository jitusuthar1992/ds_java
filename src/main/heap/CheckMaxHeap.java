package main.heap;

import main.tree.BinaryTreeNode;

public class CheckMaxHeap {

    public static boolean isMaxHeap(BinaryTreeNode node){
        if(node == null){
            return true;
        }
        int count = countNodes(node);
        if(isCBT(node,0,count) && isMaxOrder(node)){
            return true;
        }
        return false;
    }

    private static boolean isMaxOrder(BinaryTreeNode node) {
        if(node.left == null && node.right == null){
            return true;
        }
        if(node.right == null){
            return node.left.data < node.data;
        }
        boolean left = isMaxOrder(node.left);
        boolean right = isMaxHeap(node.right);
        return left  && right && node.left.data < node.data && node.right.data < node.data;
    }

    private static int countNodes(BinaryTreeNode node) {
        if(node == null)
            return 0;
        return 1+countNodes(node.left)+ countNodes(node.right);
    }

    private static boolean isCBT(BinaryTreeNode node , int index , int count){

        if(node == null)
            return true;
        if(index >= count){
            return false;
        }
        return isCBT(node.left,2*index+1,count) && isCBT(node.right,2*index+2,count);
    }
}

