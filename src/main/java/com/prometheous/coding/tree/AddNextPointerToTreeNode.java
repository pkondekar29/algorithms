package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.Deque;
import java.util.LinkedList;

public class AddNextPointerToTreeNode {

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
        PrinterUtils.print(connectEff(root));
    }

    public static TreeNode connect(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;

        Deque<TreeNode> levelQ = new LinkedList<>();
        Deque<TreeNode> nextLevelQ;

        levelQ.add(root);
        TreeNode prev, curr;
        while(!levelQ.isEmpty()) {
            prev = null;
            nextLevelQ = new LinkedList<>();
            while(!levelQ.isEmpty()) {
                curr = levelQ.pollLast();
                if(prev != null) {
                    prev.next = curr;
                }
                prev = curr;

                if(curr.left != null)
                    nextLevelQ.push(curr.left);
                if(curr.right != null)
                    nextLevelQ.push(curr.right);
            }
            levelQ = nextLevelQ;
        }
        return root;
    }

    public static TreeNode connectEff(TreeNode root) {
        if (root == null) return null;
        TreeNode dummyHead = new TreeNode(0);
        TreeNode currP = root;
        TreeNode p = dummyHead;
        while (currP != null) {
            if (currP.left != null) {
                p.next = currP.left;
                p = p.next;
            }
            if (currP.right != null) {
                p.next = currP.right;
                p = p.next;
            }

            if (currP.next != null) {
                currP = currP.next;
            } else {
                currP = dummyHead.next;
                dummyHead.next = null;
                p = dummyHead;
            }
        }
        return root;
    }

}
