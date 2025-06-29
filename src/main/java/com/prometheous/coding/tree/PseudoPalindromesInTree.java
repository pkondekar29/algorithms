package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PseudoPalindromesInTree {

    public int pseudoPalindromicPaths (TreeNode root) {
        if(root == null) return 0;
        Map<Integer, Integer> count = new HashMap<>();
        return checkPalindromicPaths(root, count);
    }

    private int checkPalindromicPaths(TreeNode root, Map<Integer, Integer> fMap) {
        fMap.put(root.val, fMap.getOrDefault(root.val, 0) + 1);
        // Reached leaf node
        Integer freq = fMap.get(root.val);
        if(root.left == null && root.right == null) {
            boolean palindrome = checkPalindrome(fMap);
            if(freq == 1) fMap.remove(root.val);
            else fMap.put(root.val, fMap.get(root.val) - 1);
            return palindrome ? 1 : 0;
        }
        int n = 0;
        if(root.left != null) {
            n += checkPalindromicPaths(root.left, fMap);
        }
        if(root.right != null) {
            n += checkPalindromicPaths(root.right, fMap);
        }
        if(freq == 1) fMap.remove(root.val);
        else fMap.put(root.val, freq - 1);
        return n;
    }

    private boolean checkPalindrome(Map<Integer, Integer> map) {
        return map.values().stream().filter(x -> x%2 == 1).count() <= 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2,
                new TreeNode(3, new TreeNode(3, null, null), new TreeNode(1, null, null)),
                new TreeNode(1, null, new TreeNode(1, null, null)));
        System.out.println(new PseudoPalindromesInTree().pseudoPalindromicPaths(root));
    }
}
