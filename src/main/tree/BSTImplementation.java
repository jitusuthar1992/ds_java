package main.tree;

/**
 * @author jitendra.kumar01
 * 27/11/19
 */
public class BSTImplementation {

    public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if (null == root) {
            root = new BinaryTreeNode(null, null, data);
        } else if (data < root.data) {
            root.setLeft(insert(root.left, data));
        } else if (data > root.data) {
            root.setRight(insert(root.right, data));
        }
        return root;
    }

    public static BinaryTreeNode insertIterative(BinaryTreeNode root, int data) {
       BinaryTreeNode newNode = new BinaryTreeNode(data);
       BinaryTreeNode curr = root;
       BinaryTreeNode parent = null;

       while (curr != null){
           parent = curr;
           if(data < curr.data)
               curr = curr.left;
           else
               curr = curr.right;
       }
       if(parent == null)
           return newNode;
       else if(data < parent.data){
           parent.left = newNode;
       }else {
           parent.right = newNode;
       }
       return root;
    }


    public static BinaryTreeNode findMin(BinaryTreeNode root) {
        if (root == null)
            return null;

        while (root.left != null)
            root = root.left;
        return root;

    }

    public static BinaryTreeNode findMax(BinaryTreeNode root) {
        if (root == null)
            return null;
        while (root.right != null)
            root = root.right;
        return root;

    }

    public static BinaryTreeNode search(int data, BinaryTreeNode root) {
        if (root == null) {
            System.out.println("Element Not Found");
            return null;
        }

        if (root.data == data)
            return root;
        if (root.data > data) {
            return search(data, root.left);
        }

        return search(data, root.right);
    }

    public static BinaryTreeNode delete(BinaryTreeNode root, int data) {
        BinaryTreeNode temp = null;
        if (null == root) {
            System.out.println("Element Not Found");
            return root;
        }

        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.right != null && root.left != null) {
                temp = findMax(root);
                root.data = temp.data;
                root.left = delete(root.left, root.data);
            } else {
                if (root.left == null)
                    root = root.left;
                else if (root.right == null)
                    root = root.right;
            }
        }
        return root;
    }

    public static void main(String[] args) {

        BinaryTreeNode root = null;
        int[] keys = {15, 10, 20, 8, 12, 16, 25};

        for (int key : keys) {
            root = insert(root, key);
        }
        BinaryTreeTraversal.inOrderRecursion(root);

        System.out.println();
        delete(root, 12);
        BinaryTreeTraversal.inOrderRecursion(root);

    }
}
