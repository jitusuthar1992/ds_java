package main.tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
    public static boolean isPairPresent(BinaryTreeNode root, int sum){
        Set<Integer> set = new HashSet<>();
        return isPairUtil(root,sum,set);
    }

    private static boolean isPairUtil(BinaryTreeNode node, int sum, Set<Integer> set) {
        if(null == node)
            return false;

        if(isPairUtil(node.left,sum,set))
            return true;

        if(set.contains(sum-node.data))
            return true;
        set.add(node.data);

        return isPairUtil(node.left,sum,set);
    }
}
