package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

public class PowerFunction {

   public static void main(String[] args) {

      PrinterUtils.print(new PowerFunction().pow(2, 3));
   }

   // Divide and conquer approach
   // x^n
   public double pow(double x, int n) {

      if (n == 0)
         return 1;
      if (n < 0)
         return 1 / x * pow(1 / x, -(n + 1));

      return (n % 2 == 0) ?
            // Even
            pow(x * x, n / 2) :
            // Odd
            x * pow(x * x, n / 2);
   }

}
