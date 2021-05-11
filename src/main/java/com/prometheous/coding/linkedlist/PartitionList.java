package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

public class PartitionList {

    public static void main(String[] args) {
        ListNode node = new ListNode(9, new ListNode(3, new ListNode(0, new ListNode(-10, new ListNode(-9)))));
        PrinterUtils.print(new PartitionList().partition(node, 0));
        PrinterUtils.print(new PartitionList().partitionInPlace(node, -10));
    }

    // This changes the value of the numbers inside which is not preferred.
    public ListNode partition(ListNode head, int pivot) {
        ListNode i = new ListNode(), j = head;
        i.next = head;
        int temp;
        while(j != null) {
            if(j.val < pivot) {
                i = i.next;
                temp = j.val;
                j.val = i.val;
                i.val = temp;
            }
            j = j.next;
        }
        return head;
    }

    public ListNode partitionInPlace(ListNode head, int pivot) {
        if(head == null) return null;

        ListNode lessThanPivot = new ListNode(0), lItr = lessThanPivot;
        ListNode greaterThanPivot = new ListNode(0), gItr = greaterThanPivot;

        while(head != null) {
            if(head.val < pivot) {
                lItr.next = head;
                lItr = lItr.next;
            } else {
                gItr.next = head;
                gItr = gItr.next;
            }
            head = head.next;
        }
        lItr.next = greaterThanPivot.next;
        return lessThanPivot.next;
    }

}
