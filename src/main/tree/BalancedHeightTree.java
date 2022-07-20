package main.tree;

public class BalancedHeightTree {
    static BinaryTreeNode root;

    static int height(BinaryTreeNode node) {
        if (null == node) {
            return 0;
        }

        int lh = height(node.left);
        int rh = height(node.right);

        if (lh > rh)
            return (lh + 1);
        return (rh + 1);
    }

    static boolean isBalanced(BinaryTreeNode node) {
        if (node == null)
            return true;
        int lh = height(node.left);
        int rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
        return false;
    }

    public static void main(String args[]) {
        BalancedHeightTree tree = new BalancedHeightTree();
        tree.root = new BinaryTreeNode(1);
        tree.root.left = new BinaryTreeNode(2);
        tree.root.right = new BinaryTreeNode(3);
        tree.root.left.left = new BinaryTreeNode(4);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.left.left.left = new BinaryTreeNode(8);

        Height height = new Height();
        if (isBalancedSOl1(tree.root, height))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }


    static boolean isBalancedSOl1(BinaryTreeNode root, Height height) {
        /* If tree is empty then return true */
        if (root == null) {
            height.height = 0;
            return true;
        }

        /* Get heights of left and right sub trees */
        Height lheight = new Height(), rheight = new Height();
        boolean l = isBalancedSOl1(root.left, lheight);
        boolean r = isBalancedSOl1(root.right, rheight);
        int lh = lheight.height, rh = rheight.height;

        /* Height of current node is max of heights of
           left and right subtrees plus 1*/
        height.height = (lh > rh ? lh : rh) + 1;

        /* If difference between heights of left and right
           subtrees is more than 2 then this node is not balanced
           so return 0 */
        if ((lh - rh >= 2) || (rh - lh >= 2))
            return false;

        /* If this node is balanced and left and right subtrees
           are balanced then return true */
        else
            return l && r;
    }

    static class Height {
        int height = 0;
    }

}
