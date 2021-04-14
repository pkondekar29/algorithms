package com.prometheous.coding.array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(solve(arr, target));
    }

    public static int solve(int[] a, int target) {
        int low = 0, high = a.length - 1, mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(a[mid] == target) {
                return mid;
            } else if(a[mid] > a[high]) {
                if (target >= a[low] && target <= a[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if(a[mid] <= target && target >= a[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int solveC(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (nums[mid] > nums[high]) {
                if (target >= nums[low] && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (target >= nums[mid] && target <= nums[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
