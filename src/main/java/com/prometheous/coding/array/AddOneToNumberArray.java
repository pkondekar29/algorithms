package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOneToNumberArray {

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList(0, 0, 0, 9, 9, 9, 9, 9);
        PrinterUtils.printList(plusOne(num));
    }

    public static ArrayList<Integer> plusOne(List<Integer> num) {
        ArrayList<Integer> res = new ArrayList<>(num.size());
        int carry = 1, i = num.size() - 1;
        int limit = 0;
        while(limit < num.size() && num.get(limit) == 0) limit++;
        for(; i >= limit; i--) {
            res.add(0, (carry + num.get(i)) % 10);
            carry = (carry + num.get(i)) / 10;
        }
        if(carry == 1)
            res.add(0, 1);
        return res;
    }

}
