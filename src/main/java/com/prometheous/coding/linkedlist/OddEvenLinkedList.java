package com.prometheous.coding.linkedlist;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.utils.PrinterUtils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class OddEvenLinkedList {

   public static void main(String[] args) {

      ListNode node = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))));
      PrinterUtils.print(groupOddEven(node));
   }

   public static ListNode groupOddEvenCorrect(ListNode head) {

      if (head == null || head.next == null)
         return head;

      ListNode odd = head, even = head.next, eHead = even;
      while (even != null && even.next != null) {
         odd.next = odd.next.next;
         even.next = even.next.next;

         odd = odd.next;
         even = even.next;
      }
      odd.next = eHead;
      return head;
   }

   public static ListNode groupOddEven(ListNode head) {

      if (head == null)
         return null;
      ListNode headRef = head;
      ListNode odd = null;
      ListNode even = null, eHead = null;
      int i = 1;
      while (head != null) {
         if (i % 2 == 1) {      // Odd
            if (odd == null) {
               odd = head;
            } else {
               odd.next = head;        // Pass by ref, so, this will create circular link on start node.
               odd = odd.next;
            }
         } else {    // Even
            if (even == null) {
               even = head;
               eHead = even;
            } else {
               even.next = head;
               even = even.next;
            }
         }
         head = head.next;
         i++;
      }
      if (even != null)
         even.next = null;
      odd.next = eHead;
      return headRef;
   }

}
