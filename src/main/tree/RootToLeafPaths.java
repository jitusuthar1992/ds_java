package main.tree;

public class RootToLeafPaths {
    BinaryTreeNode root ;

    void printPaths(int[] path , int pathLength){
        for (int i = 0; i <pathLength ; i++) {
            System.out.print(path[i] + " ");

        }
        System.out.println();
    }

    void printPaths(BinaryTreeNode node){
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }

    void printPathsRecur(BinaryTreeNode node, int[] path, int pathLen) {
        if(node == null){
            return;
        }

        path[pathLen++] = node.data;

        if(node.left == null && node.right == null){
            printPaths(path,pathLen);
        }else {
            printPathsRecur(node.left,path,pathLen);
            printPathsRecur(node.right,path,pathLen);
        }

    }
    public static void main(String args[])
    {
        RootToLeafPaths tree = new RootToLeafPaths();
        tree.root = new BinaryTreeNode(10);
        tree.root.left = new BinaryTreeNode(8);
        tree.root.right = new BinaryTreeNode(2);
        tree.root.left.left = new BinaryTreeNode(3);
        tree.root.left.right = new BinaryTreeNode(5);
        tree.root.right.left = new BinaryTreeNode(2);

        /* Let us test the built tree by printing Insorder traversal */
        tree.printPaths(tree.root);
    }

}
