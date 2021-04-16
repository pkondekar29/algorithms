package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutationsDup {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};
        find(arr).stream()
                .map(list -> list.stream().map(Object::toString).collect(Collectors.joining(",")))
                .forEach(System.out::println);
    }

    public static List<List<Integer>> find(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] vis = new boolean[arr.length];
        List<Integer> temp = new ArrayList<>();
        dfs(arr, vis, res, temp);
        return res;
    }

    private static void dfs(int[] arr, boolean[] vis, List<List<Integer>> res, List<Integer> temp) {
        if(temp.size() == arr.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i = 0; i < arr.length; i++) {
            if(vis[i]) continue;
            if(i > 0 && arr[i] == arr[i - 1] && !vis[i - 1]) continue;       // If the prev elem is not vis, we should visit that first

            vis[i] = true;
            temp.add(arr[i]);
            dfs(arr, vis, res, temp);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

}
