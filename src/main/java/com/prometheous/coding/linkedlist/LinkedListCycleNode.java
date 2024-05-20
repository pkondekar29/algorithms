package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

public class LinkedListCycleNode {

   public static void main(String[] args) {

      ListNode last = new ListNode(9);
      ListNode cyclePoint = new ListNode(0, new ListNode(5, last));
      ListNode node = new ListNode(-10, new ListNode(-3, cyclePoint));
      last.next = cyclePoint;

      ListNode c = findCyclePoint(node);
      System.out.println(c != null ? "" + c.val : "Null");
   }

   public static ListNode findCyclePointConcise(ListNode head) {

      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
         fast = fast.next.next;
         slow = slow.next;

         if (fast == slow) {         // If cycle found
            ListNode slow2 = head;
            /**
             * The steps which would be taken by slow2 & slow to meet would be the same point where there is a cycle.
             *
             * */
            while (slow2 != slow) {
               slow = slow.next;
               slow2 = slow2.next;
            }
            return slow;
         }
      }
      return null;
   }

   public static ListNode findCyclePoint(ListNode head) {

      if (head == null || head.next == null)
         return null;
      ListNode headRef = head;
      int max = Integer.MIN_VALUE;
      ListNode slow = head, fast = head;
      while (slow != null && fast != null && fast.next != null) {
         max = Math.max(max, slow.val);
         slow = slow.next;
         fast = fast.next.next;
         if (slow == fast)
            break;
      }

      // No cycle found
      if (slow != fast)
         return null;

      slow = slow.next;
      while (slow != fast) {
         max = Math.max(max, slow.val);
         slow = slow.next;
      }

      slow.val = max + 1;
      slow = slow.next;
      while (slow != fast) {
         slow.val = max + 1;
         slow = slow.next;
      }

      while (headRef.val != max + 1) {
         headRef = headRef.next;
      }
      return headRef;
   }

}
