package com.prometheous.coding.tree;

import com.prometheous.coding.model.TreeNode;

public class SortedArrToBST {

    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = convertToBST(arr);
    }

    public static TreeNode convertToBST(int[] arr) {
        int lo = 0, hi = arr.length - 1;
        return toBST(arr, lo, hi);
    }

    private static TreeNode toBST(int[] arr, int lo, int hi) {
        if(lo <= hi) {
            int mid = (lo + hi) / 2;
            return new TreeNode(arr[mid],
                    toBST(arr, lo, mid - 1),
                    toBST(arr, mid + 1, hi));
        }
        return null;
    }
}
