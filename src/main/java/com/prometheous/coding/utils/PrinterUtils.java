package com.prometheous.coding.utils;

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
    }

    public static void print(int[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static <T> void print(List<List<T>> list) {
        list.stream()
                .map(l -> l.stream().map(Object::toString).collect(Collectors.joining(",")))
                .forEach(System.out::println);
    }

    public static void print(int num) {
        System.out.println(num);
    }
}
