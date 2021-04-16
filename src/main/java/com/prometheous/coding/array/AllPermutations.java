package com.prometheous.coding.array;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AllPermutations {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        find(a).stream()
                .map(l -> l.stream().map(i -> i + "").collect(Collectors.joining(", ")))
                .forEach(System.out::println);

    }

    private static List<List<Integer>> find(int[] a) {
        List<List<Integer>> res = new ArrayList<>();
        if(a.length == 0) return res;

        boolean[] visited = new boolean[a.length];
        all(a, new ArrayList<>(), visited, res);
        return res;
    }

    private static void all(int[] a, ArrayList<Integer> curr, boolean[] visited, List<List<Integer>> res) {
        if(a.length == curr.size()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int k = 0; k < a.length; k++) {
            if(!visited[k]) {
                curr.add(a[k]);
                visited[k] = true;
                all(a, curr, visited, res);
                visited[k] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }

}
