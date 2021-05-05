package com.prometheous.coding.array;

public class MedianOfSortedArray {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;
        // Total number of elements combined
        int total = (x + y + 1) / 2;
        /**
         * This denotes the points in nums1 and nums2 where both the arrays are partitioned
         *      The number elements on left of partitions of both array are same as on right
         */
        int partitionX, partitionY;
        while(low <= high){
            // We find the partition in lower element array
            partitionX = (low + high) / 2;
            // We need to partition it on larger array such that left elements are same as on right
            // considering both arrays
            partitionY = total - partitionX;

            // If there is nothing on the left, then max on Left of nums1 will be -Infinity
            int maxLeftX = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX - 1];
            // Same goes for finding numbers on right side of partition of Nums1
            int minRightX = partitionX == x ? Integer.MAX_VALUE : nums1[partitionX];

            // Same as above on nums2 array
            int maxLeftY = partitionY == 0 ? Integer.MIN_VALUE: nums2[partitionY - 1];
            int minRightY = partitionY == y ? Integer.MAX_VALUE : nums2[partitionY];

            // If the max element in 1st array(just before the partition) is smaller than min element in 2nd array(just after the partition)
            // AND
            // Same for the leftMax of Nums2 and rightMin of Nums1
            // Then all the elements on the left partitions of both array are less than all elements on right partition
            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y) % 2 == 0) { // even number of elements
                    return ((double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY))) / 2;
                } else {
                    return (double) Math.max(maxLeftX, maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }

}
