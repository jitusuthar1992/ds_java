package main.tree;

public class InorderSuccesorOfBT {

    static BinaryTreeNode temp = new BinaryTreeNode(-1);
    static BinaryTreeNode leftMostNode(BinaryTreeNode node)
    {
        while (node != null && node.left != null)
            node = node.left;
        return node;
    }

    // function to find right most node in a tree
    static BinaryTreeNode rightMostNode(BinaryTreeNode node)
    {
        while (node != null && node.right != null)
            node = node.right;
        return node;
    }

    // recursive function to find the Inorder Successor
// when the right child of node x is null
    static BinaryTreeNode findInorderRecursive(BinaryTreeNode root, BinaryTreeNode x )
    {
        if (root==null)
            return null;

        if (root==x || (temp = findInorderRecursive(root.left,x))!=null ||
                (temp = findInorderRecursive(root.right,x))!=null)
        {
            if (temp!=null)
            {
                if (root.left == temp)
                {
                    System.out.print( "Inorder Successor of "+x.data);
                    System.out.print( " is "+ root.data + "\n");
                    return null;
                }
            }

            return root;
        }

        return null;
    }

    // function to find inorder successor of
// a node
    static void inorderSuccessor(BinaryTreeNode root, BinaryTreeNode x)
    {
        // Case1: If right child is not null
        if (x.right != null)
        {
            BinaryTreeNode inorderSucc = leftMostNode(x.right);
            System.out.print("Inorder Successor of "+x.data+" is ");
            System.out.print(inorderSucc.data+"\n");
        }

        // Case2: If right child is null
        if (x.right == null)
        {
            int f = 0;

            BinaryTreeNode rightMost = rightMostNode(root);

            // case3: If x is the right most node
            if (rightMost == x)
                System.out.print("No inorder successor! Right most node.\n");
            else
                findInorderRecursive(root, x);
        }
    }
    public static void main(String args[])
    {
        // Let's construct the binary tree
        // as shown in above diagram

        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(6);

        // Case 1
        inorderSuccessor(root, root.right);

        // case 2
        inorderSuccessor(root, root.left.left);

        // case 3
        inorderSuccessor(root, root.right.right);

    }

}
