package main.tree;

/**
 * @author jitendra.kumar01
 * 12/11/19
 */
public class PrintAncestors {
    BinaryTreeNode root;

    static boolean printAncestors(BinaryTreeNode node , int target){
        if(node == null)
            return false;

        if(node.data == target)
            return true;

        if(printAncestors(node.left,target) || printAncestors(node.right,target)){
            System.out.println(node.data +" ");
            return true;
        }

        return false;
    }

    public static void main(String args[])
    {
        PrintAncestors tree = new PrintAncestors();
        tree.root = new BinaryTreeNode(10);
        tree.root.left = new BinaryTreeNode(8);
        tree.root.right = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(3);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(2);

        /* Let us test the built tree by printing Insorder traversal */
        PrintAncestors.printAncestors(tree.root,3);
    }

}
