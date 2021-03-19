package com.prometheous.coding.array;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int [][] a = new int[2][3];
        int target = 3;
        SearchIn2DMatrix.search(a, target);
    }

    public static boolean search(int[][] a, int t) {
        boolean found = false;

        int low = 0, high = a.length, mid = (low + high) / 2;
        while(low < high) {
            if(a[mid][0] > t) {
                break;
            }


        }

        return found;
    }

}
