package tree;

import java.util.ArrayList;
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
}
