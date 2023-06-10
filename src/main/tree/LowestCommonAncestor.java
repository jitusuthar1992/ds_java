package main.tree;

public class LowestCommonAncestor {
    public static BinaryTreeNode findLCA(BinaryTreeNode node,int n1,int n2){
        if(null == node)
            return null;
        if(node.data == n1 || node.data ==n2  )
            return node;
        BinaryTreeNode left = findLCA(node.left,n1,n2);
        BinaryTreeNode right = findLCA(node.left,n1,n2);

        if(left == null)return right;
        if(right == null) return left;

        return node;
    }
}
