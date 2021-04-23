package com.prometheous.coding.array;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,7,9,10,12};
        System.out.println(findMinInRotatedSortedArr(arr));
    }

    public static int findMinInRotatedSortedArr(int[] nums) {
        int low = 0, high = nums.length - 1;
        while(low < high) {
            int mid = low + (high - low) / 2;
            int midValue = nums[mid];

            if(mid > 0 && midValue < nums[mid - 1]) {
                return mid;
            } else if(nums[mid] >= nums[low] && nums[mid] > nums[high]) {
                // Mid value is greater that left => which means that left side is sorted.
                // And mid > high, i.e. the right is not sorted.
                // Which is were we want to go. Since the minimum element would be in the unsorted part.
                low = mid + 1;
            } else {
                // Else we want to move to left
                high = mid - 1;
            }
        }
        return low;
    }

}
