package main.tree;

import java.util.*;

public class VerticalOrderTraversal {

    static class QueueNode {
        BinaryTreeNode node;
        int hd;

        public QueueNode(BinaryTreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void verticalOrderTraversal(BinaryTreeNode root) {
        Queue<QueueNode> queue = new LinkedList<>();


        Map<Integer, List<BinaryTreeNode>> map = new HashMap<>();
        if (null == root) {
            return;
        }

        queue.offer(new QueueNode(root, 0));

        while (!queue.isEmpty()) {

            QueueNode temp = queue.poll();

            List<BinaryTreeNode> nodes = map.get(temp.hd);

            if (nodes == null || nodes.isEmpty()) {
                nodes = new ArrayList<>();
            }

            nodes.add(temp.node);

            if (null != temp.node.left) {
                queue.add(new QueueNode(temp.node.left, temp.hd - 1));
            }

            if (null != temp.node.right) {
                queue.add(new QueueNode(temp.node.right, temp.hd + 1));
            }
        }
    }
}
