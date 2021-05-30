package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;

public class SortList {

    // TODO
    // T = O(nlogn), S = O(logN)
    public ListNode sort(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = getMiddle(head);
        ListNode next = middle.next;

        middle.next = null;
        ListNode left = sort(head);
        ListNode right = sort(next);

        return merge(left, right);
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode result;
        if(a == null) return b;
        else if (b == null) return a;

        if(a.val <= b.val) {
            result = a;
            result.next = merge(a.next, b);
        } else {
            result = b;
            result.next = merge(a, b.next);
        }
        return result;
    }

    private ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}