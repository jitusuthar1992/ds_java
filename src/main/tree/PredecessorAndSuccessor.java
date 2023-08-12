package main.tree;

public class PredecessorAndSuccessor {
    public static void findPredSucc(BinaryTreeNode root, BinaryTreeNode succ , BinaryTreeNode pred , int key){
        if(null == root)
            return;
        if(root.data == key){
            if(root.left != null){
                pred = findPred(root);
            }
            if(root.right != null){
                succ = findSucc(root);
            }
        }else if(key > root.data){
            pred = root;
            findPredSucc(root.right,succ,pred,key);
        }else {
            succ = root;
            findPredSucc(root.left,succ,pred,key);
        }
    }

    private static BinaryTreeNode findSucc(BinaryTreeNode root) {
        BinaryTreeNode tmp = root.right;
        while (tmp.left != null){
            tmp = tmp.left;
        }
        return tmp;
    }

    private static BinaryTreeNode findPred(BinaryTreeNode root) {
        BinaryTreeNode tmp = root.left;
        while (tmp.right != null){
            tmp = tmp.right;
        }
        return tmp;
    }
}
