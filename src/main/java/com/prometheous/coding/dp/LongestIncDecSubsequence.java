package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;

public class LongestIncDecSubsequence {

   public static void main(String[] args) {

      PrinterUtils.print(new LongestIncDecSubsequence()
            .findLongestIncreasingThenDecreasingSubsequence(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }));
   }

   public int findLongestIncreasingThenDecreasingSubsequence(int[] arr) {

      int[] incRightDP = new int[arr.length];
      int[] incLeftDP = new int[arr.length];

      Arrays.fill(incRightDP, 1);
      Arrays.fill(incLeftDP, 1);

      for (int i = 1; i < arr.length; i++) {
         for (int j = 0; j < i; j++) {
            if (arr[i] > arr[j]) {
               incRightDP[i] = Math.max(incRightDP[i], incRightDP[j] + 1);
            }
         }
      }

      for (int i = arr.length - 2; i >= 0; i--) {
         for (int j = arr.length - 1; j > i; j--) {
            if (arr[i] > arr[j]) {
               incLeftDP[i] = Math.max(incLeftDP[i], incLeftDP[j] + 1);
            }
         }
      }

      int max = 1;
      for (int i = 0; i < incLeftDP.length; i++) {
         max = Math.max(max, incLeftDP[i] + incRightDP[i]);
      }
      return max - 1;
   }

}
