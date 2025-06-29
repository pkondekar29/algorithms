package com.prometheous.coding.intervals;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms {

    public static int minRooms(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        for(int[] arr : intervals) {
            if(pq.isEmpty()) {
                pq.offer(arr);
            } else {
                if(pq.peek()[1] <= arr[0]) {
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        PrinterUtils.print(minRooms(new int[][] {
                {9,10},{4,9},{4,17}
        }));
    }
}
