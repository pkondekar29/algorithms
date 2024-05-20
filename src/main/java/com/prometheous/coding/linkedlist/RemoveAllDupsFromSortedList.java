package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.List;

public class RemoveAllDupsFromSortedList {

   public static void main(String[] args) {

      ListNode head = new ListNode(1, new ListNode(1));
      PrinterUtils.print(deleteDuplicates(head));
   }

   public static ListNode deleteDuplicates(ListNode head) {

      if (head == null)
         return null;
      ListNode curr = head;
      ListNode fakeHead = new ListNode(0);
      ListNode prev = fakeHead;
      fakeHead.next = head;

      while (curr != null) {
         while (curr.next != null && curr.val == curr.next.val)
            curr = curr.next;

         if (prev.next == curr) {
            prev = prev.next;
         } else {
            prev.next = curr.next;
         }
         curr = curr.next;
      }
      return fakeHead.next;
   }

}
