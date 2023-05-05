package main.heap;

import main.tree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class BstToMinHeap {
    public static void bstToMinHeap(BinaryTreeNode root){
        if(root== null)
            return ;

        List<Integer> list = new ArrayList<>();
        inorderTraversal(root,list);
        fillPreorder(root,0,list);
    }

    public static void inorderTraversal(BinaryTreeNode node, List<Integer> list){
        if(node == null)
            return;
        inorderTraversal(node.left,list);
        list.add(node.data);
        inorderTraversal(node.right,list);
    }

    public static void fillPreorder(BinaryTreeNode node,int index,List<Integer> list){
        if(null == node)
            return;
        node.data = list.get(index);
        index++;
        fillPreorder(node.left,index,list);
        fillPreorder(node.right,index,list);
    }
}
