package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class GetPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), null);

        int targetSum = 3;

        getPathSum(root, targetSum)
                .stream()
                .map(list -> "[" + list.stream().map(Object::toString).collect(Collectors.joining(", ")) + "]")
                .forEach(System.out::println);
    }

    public static List<List<Integer>> getPathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> curr = new LinkedList<>();
        findPath(root, targetSum, curr, res);
        return res;
    }

    private static void findPath(TreeNode root, int targetSum, LinkedList<Integer> curr, List<List<Integer>> res) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            if(root.val == targetSum) {
                List<Integer> list = new ArrayList<>(curr);
                list.add(root.val);
                res.add(list);
            }
            return;
        }
        curr.addLast(root.val);
        findPath(root.left, targetSum - root.val, curr, res);
        findPath(root.right, targetSum - root.val, curr, res);
        curr.removeLast();
    }

}