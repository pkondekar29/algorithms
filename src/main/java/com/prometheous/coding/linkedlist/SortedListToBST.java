package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.model.TreeNode;

public class SortedListToBST {

    public static void main(String[] args) {
        ListNode node = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
        TreeNode root = convertToBST(node);
    }

    public static TreeNode convertToBST(ListNode head) {
        if(head == null) return null;
        return toBST(head, null);
    }

    private static TreeNode toBST(ListNode head, ListNode tail) {
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail) return null;

        while(fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return new TreeNode(slow.val, toBST(head, slow), toBST(slow.next, tail));
    }


}
