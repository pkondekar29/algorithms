package com.prometheous.coding.array;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,7,9,1,2};
        int target = 0;
        System.out.println(findInRotatedSortedArray(arr, target));
    }

    public static int findInRotatedSortedArray(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];
            if (target == midValue) {
                return mid;
            }
            boolean am_big = midValue >= nums[0];      // This means that midValue is greater than first element
            boolean target_big = target >= nums[0]; // The target is also greater than the first element

            if(am_big == target_big) {  // If both are bigger than first element, then that mean we are in the sorted subarray
                if(midValue >= target) {       // So, this is normal binary search
                    high = mid;
                } else {
                    low = mid + 1;
                }
            } else {
                // This mean that target is not big since the above condition is not met.
                // That is we are in the unsorted subarray.
                if(am_big) {    // If we are big and the target is not big, then we need to move to right.
                    low = mid + 1;
                } else {    // Else left
                    high = mid;
                }
            }
        }
        return -1;
    }

    public static int solve(int[] a, int target) {
        int low = 0, high = a.length - 1, mid;
        while(low <= high) {
            mid = (low + high) / 2;
            if(a[mid] == target) {
                return mid;
            }
            if(a[mid] > a[high]) {
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
