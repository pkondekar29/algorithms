package com.prometheous.coding.string;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
            if (freq.get(ch) > (n + 1) / 2) return "";
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> b[0] - a[0]
        );
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.add(new int[]{entry.getValue(), entry.getKey()});
        }
        char[] res = new char[n];
        int i = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int count = curr[0];
            char ch = (char) curr[1];
            while (count-- > 0) {
                if (i >= n) i = 1;
                res[i] = ch;
                i += 2;
            }
        }
        return new String(res);
    }
}
