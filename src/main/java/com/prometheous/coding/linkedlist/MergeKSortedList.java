package com.prometheous.coding.linkedlist;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedList {

    static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        ListNode[] list = new ListNode[5];
        ListNode head = merge(list);
        while(head != null) {
            System.out.print(head.val + " ");
        }
    }

    public static ListNode mergeEff(ListNode[] list) {
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        ListNode prev = null, head = null;
        for(ListNode node : list) {
            q.add(node);
        }

        while(!q.isEmpty()) {
            ListNode min = q.poll();
            if(min.next != null) {
                q.add(min.next);
            }

            if(prev != null) {
                prev.next = min;
                prev = prev.next;
            } else {
                prev = min;
                head = min;
            }
        }

        return head;
    }


    public static ListNode merge(ListNode[] list) {
        ListNode prev = null, head = null;
        ListNode[] pointers = new ListNode[list.length];
        int i = 0;
        for(ListNode node : list) {
            pointers[i++] = node;
        }
        while(!allTraversed(pointers)) {
            int minPos = findMinNode(pointers);
            if(minPos != -1) {
                ListNode minNode = new ListNode(pointers[minPos].val);
                if(head != null) {
                    head.next = minNode;
                    head = head.next;
                } else {    // 1st Min node
                    prev = minNode;
                    head = minNode;
                }
                pointers[minPos] = pointers[minPos].next;
            }
        }
        return prev;
    }

    private static int findMinNode(ListNode[] pointers) {
        int min = Integer.MAX_VALUE, minPos = -1;
        for(int i = 0; i < pointers.length; i++) {
            if(pointers[i] != null && min > pointers[i].val) {
                min = pointers[i].val;
                minPos = i;
            }
        }
        return minPos;
    }

    private static boolean allTraversed(ListNode[] list) {
        for(ListNode i : list) {
            if(i != null) return false;
        }
        return true;
    }

}
