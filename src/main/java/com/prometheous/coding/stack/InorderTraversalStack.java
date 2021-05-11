package com.prometheous.coding.stack;

import com.prometheous.coding.model.TreeNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.IntFunction;

public class InorderTraversalStack {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                null,
                new TreeNode(2,
                        new TreeNode(3,
                                null,
                                null),
                        null));
        PrinterUtils.print(new InorderTraversalStack().inorderTraversal(root));
    }

    public int[] inorderTraversal(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            // Since this is inorder, we need to move to the
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

}
