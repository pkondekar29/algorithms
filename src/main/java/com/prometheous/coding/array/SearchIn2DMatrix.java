package com.prometheous.coding.array;

public class SearchIn2DMatrix {

    public static void main(String[] args) {
        int [][] a = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 11;
        System.out.println(SearchIn2DMatrix.search(a, target));
    }

    public static boolean search(int[][] a, int target) {
        int m = a.length, n = a[0].length, lo = 0, hi = m - 1, mid = 0;
        while(lo < hi) {
            mid = lo + (hi - lo) / 2;
            if(a[mid][0] == target) return true;
            else if(a[mid][0] < target) lo = mid + 1;
            else hi = mid;
        }
        if(!(a[mid][0] < target && target <= a[mid][n - 1])) {
            if (mid < m - 1 && a[mid + 1][0] < target && target <= a[mid + 1][n - 1]) mid++;
            else if (mid > 0 && a[mid - 1][0] < target && target <= a[mid - 1][n - 1]) mid--;
        }
        int i = mid;
        lo = 0; hi = n - 1;
        while(lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if(a[i][mid] == target) return true;
            else if(a[i][mid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return false;
    }

    public static boolean bSearch(int[][] a, int target) {
        int rows = a.length, cols = a[0].length;
        int begin = 0, end = rows * cols - 1;
        while(begin <= end) {
            int midI = (begin + end) / 2;
            int mid = a[midI / cols][midI % cols];
            if(mid == target) {
                return true;
            } else if(mid < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

}
