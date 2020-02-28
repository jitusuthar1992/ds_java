package main.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author jitendra.kumar01
 * 03/02/20
 */
public class BFSTraversal {
    void bfsTraversal(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            BinaryTreeNode tmp = queue.poll();
            if(null !=tmp  ){
                System.out.println(tmp.getData());
                if (null != tmp.getLeft())
                    queue.offer(tmp.getLeft());
                if (null != tmp.getRight())
                    queue.offer(tmp.getRight());
            }
        }
    }
}
