package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

public class PartitionList {

    public static void main(String[] args) {
        ListNode node = new ListNode(3, new ListNode(9, new ListNode(0, new ListNode(-10, new ListNode(-9)))));
        PrinterUtils.print(new PartitionList().partition(node, 0));
    }

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

}
