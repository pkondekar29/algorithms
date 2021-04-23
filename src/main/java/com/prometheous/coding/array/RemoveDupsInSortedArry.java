package com.prometheous.coding.array;

public class RemoveDupsInSortedArry {

    public static void main(String[] args) {
        int[] arr = new int[] {1,1,1,2,3,4,4,4,5};
        System.out.println(removeDuplicatesInSortedArr(arr));
    }

    public static int removeDuplicatesInSortedArr(int[] a) {
        int i = 0, j = -1;
        while(i < a.length) {
            a[++j] = a[i++];

            while(i < a.length && a[i] == a[i - 1]) i++;
        }
        return j + 1;
    }

}
