package com.prometheous.coding.array;

public class RemoveDuplicatedInSortedArrExactCountOf2 {

    public static void main(String[] args) {
        int[] arr = new int[] {};
        System.out.println(removeDuplicatedValuesInSortedArr(arr));
    }

    public static int removeDuplicatedValuesInSortedArr(int[] a) {
        int i = 2, j = 2;
        if(a.length <= 2) return a.length;
        while(i < a.length) {
            if(a[i] != a[j - 2]) {
                a[j] = a[i];
                j++;
            }
            i++;
        }
        return j;
    }

}
