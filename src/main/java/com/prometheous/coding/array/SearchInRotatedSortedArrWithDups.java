package com.prometheous.coding.array;

public class SearchInRotatedSortedArrWithDups {

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,6,6,7,8,8,9,3};
        System.out.println(solve(arr, 7));
    }

    private static boolean solve(int[] arr, int k) {
        int lo = 0, hi = arr.length - 1;
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if(arr[mid] == k) return true;


        }
        return false;
    }

}
