package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SortColors {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(0,2,1,0,2,0,1,1,2,0));
        new SortColors().sortColors(list);
        PrinterUtils.printList(list);
    }

    public void sortColors(ArrayList<Integer> a) {
        int left = 0, right = a.size() - 1;
        int itr = left;
        while(itr <= right) {
            if(a.get(itr) == 0) {
                PrinterUtils.print("Swapping " + itr + " " + left);
                Collections.swap(a, left, itr);
                left++;
                itr++;
            } else if(a.get(itr) == 2) {
                PrinterUtils.print("Swapping " + itr + " " + right);
                Collections.swap(a, itr, right);
                right--;
            } else {
                itr++;
            }
            PrinterUtils.printList(a);
        }
    }

}
