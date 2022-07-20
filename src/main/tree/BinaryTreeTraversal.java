package main.tree;

import java.util.*;

public class BinaryTreeTraversal {
    private BinaryTreeNode root;

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public static void preOrderRecursion(BinaryTreeNode root) {
        if (null != root) {
            System.out.println(root.getData());
            preOrderRecursion(root.getLeft());
            preOrderRecursion(root.getRight());
        }
    }

    public static void preOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (null != root) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            BinaryTreeNode tmp = stack.pop();
            res.add(tmp.getData());
            if (null != tmp.getRight())
                stack.push(tmp.getRight());
            if (null != tmp.getLeft())
                stack.push(tmp.getLeft());
        }
    }

    public static void postOrderRecursion(BinaryTreeNode root) {
        if (null != root) {
            postOrderRecursion(root.getLeft());
            postOrderRecursion(root.getRight());
            System.out.println(root.getData());
        }
    }

    public static void inOrderRecursion(BinaryTreeNode root) {
        if (null != root) {
            inOrderRecursion(root.getLeft());
            System.out.print(root.getData() + " ");
            inOrderRecursion(root.getRight());

        }

    }


    public static void inOrderIterative(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode current = root;

        while (true) {
            if (null != current) {
                stack.push(current);
                current = current.getLeft();
            } else {
                if (stack.isEmpty())
                    break;
                current = stack.pop();
                res.add(current.getData());
                current = current.getRight();
            }
        }
    }

    public ArrayList<Integer> levelOrder(BinaryTreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == root)
            return res;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);
        ArrayList<Integer> curr = new ArrayList<>();
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (null != tmp) {
                curr.add(tmp.getData());
                if (null != tmp.getLeft())
                    q.offer(tmp.getLeft());
                if (null != tmp.getRight())
                    q.offer(tmp.getRight());
            } else {
                ArrayList<Integer> curr_res = new ArrayList<>(curr);
                res.addAll(curr_res);
                curr.clear();
                if (!q.isEmpty())
                    q.offer(null);
            }

        }
        return res;
    }

    public Integer maxInBinaryTree(BinaryTreeNode root) {
        int max_value = Integer.MIN_VALUE;
        if (null != root) {
            int leftMax = maxInBinaryTree(root.getLeft());
            int rightMax = maxInBinaryTree(root.getRight());
            if (leftMax > rightMax)
                max_value = leftMax;
            else
                max_value = rightMax;
            if (root.getData() > max_value)
                max_value = root.getData();
        }
        return max_value;
    }

    public Integer maxInBinaryTreeLevelOrder(BinaryTreeNode root) {
        if (null == root)
            return Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            BinaryTreeNode tmp = q.poll();
            if (null != tmp) {
                if (tmp.getData() > max)
                    max = tmp.getData();
            }
            if (null != tmp.getLeft()) {
                q.offer(tmp.getLeft());
            }
            if (null != tmp.getRight()) {
                q.offer(tmp.getRight());
            }
        }

        return max;

    }


    public void leftView(BinaryTreeNode root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 1; i < size; i++) {
                BinaryTreeNode tmp = queue.poll();
                if (i == 1) {
                    System.out.println(tmp.getData());
                }
                if (tmp.getLeft() != null)
                    queue.offer(tmp.getLeft());
                if (tmp.getRight() != null)
                    queue.offer(tmp.getRight());
            }
        }
    }

    public void leftView1(BinaryTreeNode root) {
        if (root == null)
            return;
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode tmp = queue.poll();

            if (null != tmp) {
                System.out.print(tmp.getData() + " ");
                while (queue.peek() != null) {
                    if (tmp.getLeft() != null)
                        queue.offer(tmp.getLeft());
                    if (tmp.getRight() != null)
                        queue.offer(tmp.getRight());
                    queue.remove();
                    tmp = queue.peek();
                }
                queue.offer(null);
            }
            queue.remove();
        }
    }

    private static void printRightView(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // number of nodes at current level
            int n = queue.size();

            // Traverse all nodes of current level
            for (int i = 1; i <= n; i++) {
                BinaryTreeNode temp = queue.poll();

                // Print the right most element at
                // the level
                if (i == n)
                    System.out.print(temp.getData() + " ");

                // Add left node to queue
                if (temp.getLeft() != null)
                    queue.add(temp.getLeft());

                // Add right node to queue
                if (temp.getRight() != null)
                    queue.add(temp.getRight());
            }
        }
    }

    private static void printTopView(BinaryTreeNode root) {

        class QueueNode {
            BinaryTreeNode node;
            int hd;

            public QueueNode(BinaryTreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QueueNode> queueNodes = new LinkedList<>();
        if (null == root) {
            return;
        } else {
            queueNodes.add(new QueueNode(root, 0));
        }

        Map<Integer, BinaryTreeNode> treeMap = new TreeMap<>();

        while (!queueNodes.isEmpty()) {
            QueueNode tmp = queueNodes.poll();
            if (!treeMap.containsKey(tmp.hd)) {
                treeMap.put(tmp.hd, tmp.node);
            }
            if (tmp.node.getLeft() != null)
                queueNodes.add(new QueueNode(tmp.node.getLeft(), tmp.hd - 1));
            if (tmp.node.getRight() != null)
                queueNodes.add(new QueueNode(tmp.node.getRight(), tmp.hd + 1));
        }

        for (Map.Entry<Integer, BinaryTreeNode> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue().getData());
        }

    }

    private static void printBottomView(BinaryTreeNode root) {
        class QueueNode {
            BinaryTreeNode node;
            int hd;

            public QueueNode(BinaryTreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        Queue<QueueNode> queueNodes = new LinkedList<>();
        if (null == root) {
            return;
        } else {
            queueNodes.add(new QueueNode(root, 0));
        }

        Map<Integer, BinaryTreeNode> treeMap = new TreeMap<>();

        while (!queueNodes.isEmpty()) {
            QueueNode tmp = queueNodes.poll();

            treeMap.put(tmp.hd, tmp.node);

            if (tmp.node.getLeft() != null)
                queueNodes.add(new QueueNode(tmp.node.getLeft(), tmp.hd - 1));
            if (tmp.node.getRight() != null)
                queueNodes.add(new QueueNode(tmp.node.getRight(), tmp.hd + 1));
        }

        for (Map.Entry<Integer, BinaryTreeNode> entry : treeMap.entrySet()) {
            System.out.println(entry.getValue().getData());
        }

    }


    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map,
                                          Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }

    private static void vertialOrderTraversal(BinaryTreeNode root) {
        class QueueNode {
            BinaryTreeNode node;
            int hd;

            public QueueNode(BinaryTreeNode node, int hd) {
                this.node = node;
                this.hd = hd;
            }

        }

        Map<Integer, List<Integer>> map = new HashMap();

        Queue<QueueNode> queue = new LinkedList<>();

        if (null == root)
            return;

        queue.offer(new QueueNode(root, 0));
        while (!queue.isEmpty()) {
            QueueNode tmp = queue.poll();
            insertIntoMultiMap(map, tmp.hd, tmp.node.data);

            if (null != tmp.node.left) {
                queue.offer(new QueueNode(tmp.node.left, tmp.hd + 1));
            }

            if (null != tmp.node.right) {
                queue.offer(new QueueNode(tmp.node.right, tmp.hd - 1));
            }
        }

        map.values().stream().forEach(System.out::println);
    }
}
