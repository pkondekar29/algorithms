package com.prometheous.coding.utils;

import com.prometheous.coding.model.ListNode;
import com.prometheous.coding.model.Node;
import com.prometheous.coding.model.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class PrinterUtils {

    private PrinterUtils() {}

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

    public static void printLine() {
        System.out.println();
    }

    public static void print(String str) {
        System.out.println(str);
    }

    public static <T> void printList(List<T> list) {
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(", ")));
    }

    public static void print(boolean b) {
        System.out.print(b);
    }

    public static void print(Node node) {
        if(node == null) return;
        HashSet<Node> visited = new HashSet<>();
        dfs(node, visited);
    }

    private static void dfs(Node node, HashSet<Node> visited) {
        if(node == null) return;
        visited.add(node);
        System.out.println(node.val + ":[" +
                node.neighbors.stream().map(n -> n.val).map(Object::toString).collect(Collectors.joining(","))
            + "]");
        for(Node n : node.neighbors){
            if(!visited.contains(n)) {
                dfs(n, visited);
            }
        }
    }

    public static void print(boolean[][] a) {
        for(int i = 0; i < a.length; i++) {
            for(int j = 0; j < a[0].length; j++) {
                System.out.print((a[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
        printLine();
    }

    public static <T> void print(ArrayList<T>[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(i + ": [" + a[i].stream().map(Object::toString).collect(Collectors.joining(", ")) + "]");
        }
    }

    public static void print(Integer[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        printLine();
    }

    public static void print(TreeNode root) {
        BTreePrinter.printNode(root);
    }
}
