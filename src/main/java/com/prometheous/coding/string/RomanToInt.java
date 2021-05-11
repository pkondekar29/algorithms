package com.prometheous.coding.string;

import com.prometheous.coding.utils.PrinterUtils;

public class RomanToInt {

    public static void main(String[] args) {
        PrinterUtils.print(new RomanToInt().toInt("CLX"));
    }

    public int toInt(String roman) {
        int res = 0;
        String[] romans = new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] values = new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        int i = 0, r = 0;
        while(i < roman.length()) {
            // Single char
            if(romans[r].length() == 1) {
                while (i < roman.length() && roman.substring(i, i + 1).equals(romans[r])) {
                    res += values[r];
                    i++;
                }
            } else {
                // Double char
                while (i < roman.length() - 1 && roman.substring(i, i + 2).equals(romans[r])) {
                    res += values[r];
                    i += 2;
                }
            }
            r++;
        }
        return res;
    }

}
