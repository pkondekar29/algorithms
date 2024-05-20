package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class SquareRootOfNum {

   public static void main(String[] args) {

      PrinterUtils.print(squareRoot(2147483647));
   }

   public static int squareRoot(int num) {

      if (num < 2)
         return num;
      if (num < 4)
         return 1;
      int low = 0, high = num / 2;   /** The high can be taken as half of num */
      int mid = low + (high - low) / 2;
      while (low <= high) {
         mid = low + (high - low) / 2;
         long square = (long) mid * mid;

         if (square == num)
            return mid;
         else if (square < num)
            low = mid + 1;
         else
            high = mid - 1;
      }
      return mid * mid < num ? mid : mid - 1;
   }

}
