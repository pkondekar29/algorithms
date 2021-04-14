package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class ValidateBST {

    public static void main(String[] args) {
        TreeNode root = null;
        System.out.println(isValid(root));
    }

    public static boolean isValid(TreeNode root) {
        Integer leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;
        return isValidSubTree(root, leftMax, rightMax);
    }

    private static boolean isValidSubTree(TreeNode root, Integer leftMax, Integer rightMax) {
        if(root == null) return true;

        boolean isValid = isValidSubTree(root.left, leftMax, rightMax);
        return true;
    }

}
