package com.prometheous.coding.dp;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        PrinterUtils.print(new Triangle().minimumTotalDP(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3,4),
                        Arrays.asList(6,5,7),
                        Arrays.asList(4,1,8,3)
                )
//                Arrays.asList(
//                        Arrays.asList(-10)
//                )
        ));
        PrinterUtils.print(new Triangle().minimumTotalDPSpaceOptON(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3,4),
                        Arrays.asList(6,5,7),
                        Arrays.asList(4,1,8,3)
                )
//                Arrays.asList(
//                        Arrays.asList(-10)
//                )
        ));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        List<List<Integer>> memo = new ArrayList<>();
        for(int k = 0; k < triangle.size(); k++) {
            memo.add(new ArrayList<>(k));
        }
        for(int i = 0; i < triangle.size(); i++) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dfs(triangle, i, j, memo);
            }
        }
        return memo.get(0).get(0);
    }

    private Integer dfs(List<List<Integer>> triangle, int level, int vertex, List<List<Integer>> memo) {
        // Base condition on leaf node
        if(level == triangle.size() - 1) return triangle.get(level).get(vertex);
        // memo look up
        if(vertex < memo.get(level).size()
                && memo.get(level).get(vertex) != null) return memo.get(level).get(vertex);

        int minPath = triangle.get(level).get(vertex);
        minPath = Math.min(
                minPath + dfs(triangle, level + 1, vertex, memo),   // Left subtree on next level and same vertex
                minPath + dfs(triangle, level + 1, vertex + 1, memo));   // Right subtree on next level and next vertex

        memo.get(level).add(vertex, minPath);
        return minPath;
    }

    public int minimumTotalDP(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int levels = triangle.size();
        List<List<Integer>> dp = new ArrayList<>(levels);
        for(int i = 0; i < levels; i++)
            dp.add(new ArrayList<>());

        // Base conditions
        for(int i = 0; i < levels; i++) {
            dp.get(0).add(triangle.get(levels - 1).get(i));
        }
        for(int i = 1; i <= levels; i++) {
            for(int j = 0; j < levels - i; j++) {
                int currWeight = triangle.get(levels - i - 1).get(j);
                // Min path weight at j
                int minPathWeight = Math.min(
                        dp.get(i - 1).get(j) + currWeight,
                        dp.get(i - 1).get(j + 1) + currWeight);

                dp.get(i).add(minPathWeight);
            }
        }
        return dp.get(levels - 1).get(0);
    }

    public int minimumTotalDPSpaceOptON(List<List<Integer>> triangle) {
        if(triangle.size() == 1) return triangle.get(0).get(0);
        int levels = triangle.size();
        // Store each path information in a single array element since what we need is just the i & i + 1 element
        int[] dp = new int[levels];

        // Base condition
        for(int i = 0; i < levels; i++)
            dp[i] = triangle.get(levels - 1).get(i);

        for(int i = levels - 2; i >= 0; i--) {
            List<Integer> level = triangle.get(i);
            int levelSize = i + 1;
            for(int j = 0; j < levelSize; j++) {
                int currWeight = level.get(j);
                // Min path weight at j
                dp[j] = Math.min(
                        dp[j] + currWeight,
                        dp[j + 1] + currWeight);
            }
        }
        return dp[0];
    }

    public int minimumTotalDPSpaceOptO1(List<List<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }

}
