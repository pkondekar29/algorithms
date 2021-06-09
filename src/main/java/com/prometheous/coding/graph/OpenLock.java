package com.prometheous.coding.graph;

import com.prometheous.coding.utils.PrinterUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OpenLock {

    public static void main(String[] args) {
        PrinterUtils.print(new OpenLock().openLock(new String[] {"0201"}, "0202"));
    }

    /**
     *  2 end BFS solution
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLockEff(String[] deadends, String target) {
        String s = "0000";
        if(s.equals(target)) return 0;
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toCollection(HashSet::new));
        Set<String> start = new HashSet<>();
        Set<String> tail = new HashSet<>();

        if (deadSet.add(s))
            start.add(s);
        if (deadSet.add(target))
            tail.add(target);

        int step = 0;
        while (!start.isEmpty() && !tail.isEmpty()) {
            Set<String> tmp = new HashSet<>();
            for (String curr : start) {
                char[] cs = curr.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char tc = cs[i];

                    cs[i] = (char)((tc-'0'+1)%10+'0');
                    String next = new String(cs);
                    if (tail.contains(next))
                        return step+1;
                    if (deadSet.add(next))
                        tmp.add(next);

                    cs[i] = (char)((tc-'0'+9)%10+'0');
                    next = new String(cs);
                    if (tail.contains(next))
                        return step+1;
                    if (deadSet.add(next))
                        tmp.add(next);

                    cs[i] = tc;
                }
            }
            start = tail;
            tail = tmp;
            step++;
        }
        return -1;
    }

    public int openLock(String[] deadends, String target) {
        HashSet<String> deadEnds = Arrays.stream(deadends).collect(Collectors.toCollection(() -> new HashSet<String>()));
        String s = "0000";
        int n = 4;

        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(s);
        visited.add(s);

        int level = 0;
        while(!queue.isEmpty()) {
            // The next level count
            int levelCount = queue.size();

            // For all the level count which we need to visit
            while(levelCount-- > 0) {
                // Get the current
                String curr = queue.poll();
                if(deadEnds.contains(curr)) continue;
                if(target.equals(curr)) return level;

                // For all the characters, increment or decrement by 1
                for(int i = 0; i < n; i++) {
                    char c = curr.charAt(i);
                    String childUp = curr.substring(0, i) + (c == '9' ? 0 : c - '0' - 1) + curr.substring(i + 1);//getNextCombination(curr, i, -1);
                    if(!deadEnds.contains(childUp) && !visited.contains(childUp)) {
                        queue.offer(childUp);
                        visited.add(childUp);
                    }
                    String childDown = curr.substring(0, i) + (c == '9' ? 0 : c - '0' + 1) + curr.substring(i + 1);// getNextCombination(curr, i, 1);
                    if(!deadEnds.contains(childDown) && !visited.contains(childDown)) {
                        queue.offer(childDown);
                        visited.add(childDown);
                    }
                }
            }
            level++;
        }
        return -1;
    }
}
