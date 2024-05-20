package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

public class InsertionSortList {

   public static void main(String[] args) {

      ListNode node = new ListNode(3, new ListNode(9, new ListNode(0, new ListNode(-10, new ListNode(-9)))));
      PrinterUtils.print(new InsertionSortList().sort(node));
   }

   public ListNode sort(ListNode head) {

      ListNode dummy = new ListNode();
      ListNode prev = dummy;
      ListNode next;
      while (head != null) {
         // Holder for the next head increment
         next = head.next;

         // Find the correct position for insertion
         while (prev.next != null && prev.next.val <= head.val) {
            prev = prev.next;
         }

         // Insert in b/w prev and prev.next
         head.next = prev.next;
         prev.next = head;

         // Update prev and head
         prev = dummy;
         head = next;
      }
      return dummy.next;
   }

}
