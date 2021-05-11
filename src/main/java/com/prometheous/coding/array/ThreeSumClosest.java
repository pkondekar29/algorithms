package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
        int minDiff = Integer.MAX_VALUE, n = a.length, minSum = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    int currSum = a[i] + a[j] + a[k];
                    System.out.println(currSum);
                    if(Math.abs(target - currSum) < Math.abs(minDiff)) {
                        minDiff = Math.abs(target - currSum);
                        minSum = currSum;
                    }
                }
            }
        }
        return minSum;
    }

    // O(n2)
    public int threeSumClosest(int[] a, int target) {
        int minDiff = Integer.MAX_VALUE;
        int minSum = 0;
        Arrays.sort(a);
        for(int i = 0; i < a.length - 2; i++) {
            int sum = target - a[i];
            int low = i + 1, high = a.length - 1;

            while(low < high) {
                if(Math.abs(a[low] + a[high] - sum) < Math.abs(minDiff)) {
                    minDiff = Math.abs(a[low] + a[high] - sum);
                    minSum = a[low] + a[high] + a[i];
                }
                if(a[low] + a[high] < sum) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        return minSum;
    }
}