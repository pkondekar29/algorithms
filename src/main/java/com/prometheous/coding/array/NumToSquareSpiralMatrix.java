package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class NumToSquareSpiralMatrix {

   public static void main(String[] args) {

      int n = 5;
      PrinterUtils.print(toSpiralMat(n));
   }

   private static int[][] toSpiralMat(int n) {

      int[][] res = new int[n][n];
      int c = 1, lcc = 0, rcc = 0, trc = 0, brc = 0, i = 0, j = 0, total = n * n;

      while (c <= total) {
         System.out.println(
               String.format("c: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, n, lcc, rcc, trc, brc,
                     i, j));
         while (j < n - rcc && c <= total) {
            res[i][j] = c;
            j++;
            c++;
         }
         i++;
         j--;
         trc++;
         System.out.println(
               String.format("c: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, n, lcc, rcc, trc, brc,
                     i, j));
         while (i < n - brc && c <= total) {
            res[i][j] = c;
            i++;
            c++;
         }
         j--;
         i--;
         rcc++;
         System.out.println(
               String.format("c: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, n, lcc, rcc, trc, brc,
                     i, j));
         while (j >= lcc && c <= total) {
            res[i][j] = c;
            j--;
            c++;
         }
         i--;
         j++;
         brc++;
         System.out.println(
               String.format("c: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, n, lcc, rcc, trc, brc,
                     i, j));
         while (i >= trc && c <= total) {
            res[i][j] = c;
            i--;
            c++;
         }
         j++;
         i++;
         lcc++;
         System.out.println(
               String.format("c: %d, n: %d, lcc: %d, rcc: %d, trc: %d, brc: %d, i: %d, j: %d", c, n, lcc, rcc, trc, brc,
                     i, j));
      }
      return res;
   }

}
