package com.prometheous.coding.utils;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.model.TreeNode;

import java.util.List;
import java.util.stream.Collectors;

public class PrinterUtils {

    public static void print(int[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        printLine();
    }

    public static void print(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        printLine();
    }

    public static <T> void print(List<List<T>> list) {
        list.stream()
                .map(l -> l.stream().map(Object::toString).collect(Collectors.joining(",")))
                .forEach(System.out::println);
    }

    public static void print(int num) {
        System.out.println(num);
    }

    public static void print(ListNode head) {
        while(head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        printLine();
    }

    private static void printLine() {
        System.out.println();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static void print(TreeNode connect) {

    }

    public static <T> void printList(List<T> list) {
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    public static void print(boolean b) {
        System.out.print(b);
    }
}
