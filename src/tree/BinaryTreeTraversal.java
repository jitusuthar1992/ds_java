package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public static  void preOrderRecursion(BinaryTreeNode root){
        if(null!= root){
            System.out.println(root.getData());
            preOrderRecursion(root.getLeft());
            preOrderRecursion(root.getRight());
        }
    }

    public static  void preOrderIterative(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if(null!= root){
            stack.push(root);
        }
        while(!stack.isEmpty()){
            BinaryTreeNode tmp = stack.pop();
            res.add(tmp.getData());
            if(null!= tmp.getRight())
                stack.push(tmp.getRight());
            if(null != tmp.getLeft())
                stack.push(tmp.getLeft());
        }
    }

    public static  void postOrderRecursion(BinaryTreeNode root){
        if(null!= root){
            postOrderRecursion(root.getLeft());
            postOrderRecursion(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static  void inOrderRecursion(BinaryTreeNode root){
        if(null!= root){
            inOrderRecursion(root.getLeft());
            System.out.println(root.getData());
            inOrderRecursion(root.getRight());

        }
    }


    public static  void inOrderIterative(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;

        while(true){
            if(null != current){
                stack.push(current);
                current = current.getLeft();
            }else {
                if(stack.isEmpty())
                    break;
                current = stack.pop();
                res.add(current.getData());
                current = current.getRight();
            }
        }
    }
    public ArrayList<Integer> levelOrder(BinaryTreeNode root){
        ArrayList<Integer> res = new ArrayList<>();
        if(null==root)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(null != tmp){
                curr.add(tmp.getData());
                if(null != tmp.getLeft())
                    q.offer(tmp.getLeft());
                if(null != tmp.getRight())
                    q.offer(tmp.getRight());
            }else{
                ArrayList<Integer> curr_res = new ArrayList<>(curr);
                res.addAll(curr_res);
                curr.clear();
                if(!q.isEmpty())
                    q.offer(null);
            }

        }
        return  res;
    }

    public  Integer maxInBinaryTree(BinaryTreeNode root){
        int max_value = Integer.MIN_VALUE;
        if(null != root){
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());
            if(leftMax > rightMax)
                max_value = leftMax;
            max_value = rightMax;
            if(root.getData() > max_value)
                max_value = root.getData();
        }
        return max_value;
    }
    public  Integer maxInBinaryTreeLevelOrder(BinaryTreeNode root){
        if(null == root)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            BinaryTreeNode tmp = q.poll();
            if(null != tmp){
                if(tmp.getData() > max)
                    max = tmp.getData();
            }
            if(null != tmp.getLeft()){
                q.offer(tmp.getLeft());
            }
            if(null != tmp.getRight()){
                q.offer(tmp.getRight());
            }
        }

        return  max;
        
    }
}
