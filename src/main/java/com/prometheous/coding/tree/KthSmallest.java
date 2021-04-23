package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class KthSmallest {

    private static int count = 0;
    public static void main(String[] args) {
        TreeNode root =
            new TreeNode(10,
                new TreeNode(5,
                    new TreeNode(3,
                        new TreeNode(-2),
                        new TreeNode(4)),
                    new TreeNode(7,
                        null,
                        new TreeNode(8))),
                new TreeNode(11,
                    null,
                    new TreeNode(14)));
        System.out.println(kthSmallest(root, 4));
    }

    public static int kthSmallest(TreeNode root, int k) {
        return helper(root, k);
    }

    public static int helper(TreeNode root, int k) {
        if(root == null) return -1;

        int kthNode = helper(root.left, k);
        count = count + 1;
        if(k == count) return root.val;
        return kthNode != -1 ? kthNode : helper(root.right, k);
    }
}
