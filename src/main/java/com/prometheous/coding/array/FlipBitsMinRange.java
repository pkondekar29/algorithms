package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.List;

public class FlipBitsMinRange {

    public static void main(String[] args) {
        PrinterUtils.printList(findMinRange("1101"));
    }

    // TODO - Fix it
    public static List<Integer> findMinRange(String str) {
        int n = str.length();
        int[] zeros = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(str.charAt(i) == '0')
                sum++;
            zeros[i] = sum;
        }
        if(sum == 0) return new ArrayList<>();

        int p = 0, q = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int diff;
                if(i == j) {
                    if(zeros[i] != 0) {
                        diff = zeros[i];
                    } else {
                        diff = Integer.MAX_VALUE;
                    }
                } else {
                    if(zeros[j] - zeros[i] != 0) {
                        diff = zeros[j] - zeros[i];
                    } else {
                        diff = Integer.MAX_VALUE;
                    }
                }
                if(diff < min) {
                    p = i + 1; q = j + 1;
                    min = zeros[i] - zeros[j];
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(p);
        res.add(q);
        return res;
    }

}