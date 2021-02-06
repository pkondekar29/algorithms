package com.prometheous.coding.array;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = sc.nextInt();
            if(n < 3) 
                throw new IllegalArgumentException();
            int[] nums = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int target = sc.nextInt();
    
            System.out.println(ThreeSumClosest.closest(nums, target));
        } finally {
            sc.close();
        }
    }

    public static int closest(int[] a, int target) {
        Arrays.sort(a);
        int minSum = Integer.MAX_VALUE;
        int currSum;
        for(int i = 0; i < a.length - 2; i++) {
            currSum = a[i] + a[i + 1] + a[i + 2];
            if(Math.abs(target - currSum) < Math.abs(target - minSum)) {
                minSum = currSum;
            }
        }
        return minSum;
    }
}