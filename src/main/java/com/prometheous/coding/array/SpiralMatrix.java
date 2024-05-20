package com.prometheous.coding.array;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrix {

   public static void main(String[] args) {

      int[][] arr = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
      int[][] arr1 = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
      System.out.println(traverseSpiral(arr1).stream().map(Object::toString).collect(Collectors.joining(", ")));
   }

   private static List<Integer> traverseSpiral(int[][] arr) {

      LinkedList<Integer> res = new LinkedList<>();
      int c = 0, m = arr.length, n = arr[0].length, lcc = 0, rcc = 0, trc = 0, brc = 0, i = 0, j = 0, total = m * n;

      while (c < total) {
         System.out.println(
               String.format("c: %d, m: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, m, n, lcc, rcc,
                     trc, brc, i, j));
         while (j < n - rcc && c < total) {
            res.addLast(arr[i][j]);
            j++;
            c++;
         }
         i++;
         j--;
         trc++;
         System.out.println(
               String.format("c: %d, m: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, m, n, lcc, rcc,
                     trc, brc, i, j));
         while (i < m - brc && c < total) {
            res.addLast(arr[i][j]);
            i++;
            c++;
         }
         j--;
         i--;
         rcc++;
         System.out.println(
               String.format("c: %d, m: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, m, n, lcc, rcc,
                     trc, brc, i, j));
         while (j >= lcc && c < total) {
            res.addLast(arr[i][j]);
            j--;
            c++;
         }
         i--;
         j++;
         brc++;
         System.out.println(
               String.format("c: %d, m: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, m, n, lcc, rcc,
                     trc, brc, i, j));
         while (i >= trc && c < total) {
            res.addLast(arr[i][j]);
            i--;
            c++;
         }
         j++;
         i++;
         lcc++;
         System.out.println(
               String.format("c: %d, m: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, m, n, lcc, rcc,
                     trc, brc, i, j));
      }
      return res;
   }

}
