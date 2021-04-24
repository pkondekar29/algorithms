package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {

    public static void main(String[] args) {
        TreeNode root =
            new TreeNode(10,
                new TreeNode(5,
                    new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(-2)),
                    new TreeNode(2,
                        null,
                        new TreeNode(1))),
                new TreeNode(-3,
                    null,
                    new TreeNode(11)));
        PrinterUtils.print(zigzag(root));
    }

    public static List<List<Integer>> zigzag (TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> levelQ = new LinkedList<>();
        Deque<TreeNode> nextLevelQ = null;
        boolean right = true;
        levelQ.add(root);
        while(!levelQ.isEmpty()) {
            List<Integer> levelList = new LinkedList<>();
            nextLevelQ = new LinkedList<>();
            while(!levelQ.isEmpty()) {
                TreeNode last = levelQ.pollLast();
                levelList.add(last.val);
                if(right) {
                    if(last.right != null)
                        nextLevelQ.offer(last.right);
                    if(last.left != null)
                        nextLevelQ.offer(last.left);
                } else {
                    if(last.left != null)
                        nextLevelQ.offer(last.left);
                    if(last.right != null)
                        nextLevelQ.offer(last.right);
                }
            }
            right = !right;
            levelQ = nextLevelQ;
            res.add(levelList);
        }
        return res;
    }

}
