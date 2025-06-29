package com.prometheous.coding.bitwise;

public class NumberOf1Bit {

    public int hammingWeight(int n) {
        int res = 0;
        while(n > 0) {
            res += (n & 1) == 0 ? 0 : 1;
            n >>= 1;
        }
        return res;
    }

    public int hammingWeightO(int n) {
        return Integer.bitCount(n);
    }
}
