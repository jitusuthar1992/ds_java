package main.tree;


public class DiameterBT {
    public static int diameter(BinaryTreeNode node){
        if(node == null)
            return 0;
        int dl = diameter(node.left);
        int dr = diameter(node.right);
        int height = height(node.left)+ height(node.right)+1;
        return Math.max(height,Math.max(dl,dr));
    }

    private static int height(BinaryTreeNode node) {
        if(node == null)
            return 0;

        return Math.max(height(node.left),height(node.right))+1;
    }
    public static int diameter1(BinaryTreeNode node){
        if(node == null)
            return 0;
        int ans = 0;
        height1(node,ans);
        return ans;
    }

    private static int height1(BinaryTreeNode node,int ans) {
        if(node == null)
            return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        ans = Math.max(ans,1+lh+rh);
        return Math.max(lh,rh)+1;
    }

}
