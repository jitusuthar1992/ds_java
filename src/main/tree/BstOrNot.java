package main.tree;

public class BstOrNot {

    static BinaryTreeNode prev = null;
    static boolean isBSTUtil(BinaryTreeNode node, int min, int max) {
        if (node == null)
            return true;
        if (node.getData() < min || node.getData() > max)
            return false;

        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }

    static boolean isBST(BinaryTreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }
    static boolean isBSTOrNot(BinaryTreeNode root) {

        if(root == null)
            return true;

        if(!isBSTOrNot(root.left))
            return false;

        if(prev != null && root.data <= prev.data )
            return false;

        return isBSTOrNot(root.right);
    }
}
