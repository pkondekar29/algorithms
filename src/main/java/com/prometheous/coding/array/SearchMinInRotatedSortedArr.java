package com.prometheous.coding.array;

public class SearchMinInRotatedSortedArr {

   public static void main(String[] args) {
      //        int[] arr = new int[] {4,5,6,7,0,1,2};
      int[] arr = new int[] { 4, 5, 6, 7, 8, 9, 3 };
      System.out.println(solve(arr));
   }

   public static int solve(int[] a) {

      int lo = 0, hi = a.length - 1;
      while (lo < hi) {
         int mid = lo + (hi - lo) / 2;

         if (a[mid] < a[hi])
            hi = mid;
         else
            lo = mid + 1;
      }
      return a[lo];
   }

}
