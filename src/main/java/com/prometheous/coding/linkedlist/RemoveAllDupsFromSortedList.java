package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

public class RemoveAllDupsFromSortedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(1));
//        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(2, new ListNode(3))))));
        PrinterUtils.print(deleteDuplicates(head));
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode headRef = head;
        ListNode next = head.next;
        ListNode prev = null;
        while(next != null) {
            while(next != null && next.val == head.val)
                next = next.next;

            if(prev != null)
                prev.next = next;
            else
                headRef = next;
            prev = next;
            head = next;
            if(next != null) {
                next = next.next;
            }
        }
        return headRef;
    }

}
