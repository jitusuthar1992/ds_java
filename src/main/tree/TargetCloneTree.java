package main.tree;

public class TargetCloneTree {
    public static BinaryTreeNode getTargetNode(BinaryTreeNode orig, BinaryTreeNode clone , BinaryTreeNode target){
        if(null == orig){
            return orig;
        }

        if(orig == target){
            return clone;
        }
        BinaryTreeNode left = getTargetNode(orig.left,clone.left,target);
        if(null != left)
            return left;
        return getTargetNode(orig.right,clone.right,target);
    }
}
