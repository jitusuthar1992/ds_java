package main.tree;

import sun.jvm.hotspot.utilities.Interval;

/**
 * @author jitendra.kumar01
 * 03/12/19
 */
public class IntervalTreeImplementation {
    class Node {
        private Interval interval;
        private int max ;
        private Node left , right ;

        public Node(Interval interval) {
            this.interval = interval;
            this.max = (int) interval.getHighEndpoint();
            this.left = null;
            this.right = null;
        }
    }


    Node insert(Node root ,Interval interval){
        if(null == root){
            root = new Node(interval);
        }

        int low = (int) interval.getLowEndpoint();
        if(low < (int)root.interval.getLowEndpoint()){
            root.left = insert(root.left,interval);
        }else{
            root.right = insert(root.right,interval);
        }

        if(root.max < (int)interval.getHighEndpoint()){
            root.max = (int)interval.getHighEndpoint();
        }
        return root;
    }
}
