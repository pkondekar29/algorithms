package com.prometheous.coding.dp;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class JumpGameIII {

    public static void main(String[] args) {
        int a[] = {0,1};
        int start = 1;

        System.out.println(isPossible(a, start));
    }

    // Gave TLE
    public static boolean isPossible(int[] a, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[a.length];
        Arrays.fill(visited, false);
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()) {
            int idx = q.poll();

            if(a[idx] == 0) return true;
            if(idx + a[idx] < visited.length && !visited[idx + a[idx]])
                q.add(idx + a[idx]);
            if(idx - a[idx] >= 0 && !visited[idx - a[idx]])
                q.add(idx - a[idx]);
        }
        return false;
    }

    public static boolean canReachEff(int[] arr, int start) {
        if(start<0 || start>=arr.length || arr[start]<0) return false;
        if(arr[start] == 0) return true;        // Return true if found

        arr[start] = -arr[start];       // Mark visited
        return canReachEff(arr, start + arr[start]) || canReachEff(arr, start - arr[start]);
    }

}
