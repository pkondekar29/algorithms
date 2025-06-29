package com.prometheous.coding.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> res = new ArrayList<>();
        int i = 0;
        while(i < n && intervals[i][1] <= newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }
        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);
        while(i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        int[][] inserted = insert(new int[][]{{1, 3}, {5, 6}}, new int[]{2, 4});
        Arrays.stream(inserted).forEach(ints -> {
            Arrays.stream(ints).asDoubleStream().forEach(System.out::print);
            System.out.println();
        });
    }

}
