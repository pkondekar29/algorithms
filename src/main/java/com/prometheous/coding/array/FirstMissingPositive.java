package com.prometheous.coding.array;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.HashSet;

public class FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = new int[] {1,2,0,100,3,5,4};
        PrinterUtils.print(findFirstMissingPositiveSpaceEff(nums));
    }

    private static int findFirstMissingPositiveSpaceEff(int[] nums) {
        /**
         *   To find 1st positive number, it has to lie in range (1,n).
         *
         *   So, somehow we should be able to distinguish b/w the numbers in this range.
          */
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) nums[i] = n + 1;
        }
        // Now we know that all the elements in the array are in range (0,N) or excluding that.

        /**
         *  2. mark each cell appearing in the array, by converting the index for that number to negative.
         *  This helps in distinguishing the numbers in array.
         */
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--; // -1 for zero index based array (so the number 1 will be at pos 0)
            if (nums[num] > 0) { // prevents double negative operations
                nums[num] = -1 * nums[num];
            }
        }
        /**
         * Now find the first negative number in array.
         *
         */
        for(int i = 0; i < n; i++) {
            if(nums[i] >= 0)
                return i + 1;
        }
        return n + 1;
    }

    private static int findFirstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (num > 0) set.add(num);
        }
        int num = 1;
        while(!set.isEmpty()) {
            if(set.contains(num)) {
                set.remove(num);
                num++;
            } else {
                break;
            }
        }
        return num;
    }
}
