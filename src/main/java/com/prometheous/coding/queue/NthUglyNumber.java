package com.prometheous.coding.queue;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(findNthUglyNumber(39));
    }

    public static int findNthUglyNumberEff(int n) {
        int count = 0;
        long val = 0l;
        PriorityQueue<Long> possible = new PriorityQueue<>();
        possible.add(1l);

        while(count != n){
            long uglyNumber = possible.remove();
            count++;
            val = uglyNumber;
            if(!possible.contains(2*uglyNumber)) possible.add(2*uglyNumber);
            if(!possible.contains(3*uglyNumber)) possible.add(3*uglyNumber);
            if(!possible.contains(5*uglyNumber)) possible.add(5*uglyNumber);
        }

        return (int)val;
    }

    // This is wrong
    public static int findNthUglyNumber(int n) {
        if(n == 1) return 1;
        TreeSet<Long> q2 = new TreeSet<>();
        TreeSet<Long> q3= new TreeSet<>();
        TreeSet<Long> q5 = new TreeSet<>();
        HashSet<Long> set = new HashSet<>();
        q2.add(2L);
        q3.add(3L);
        q5.add(5L);
        Long num = 0L;
        int count = 1;
        while(count < n) {
            Long n2, n3, n5;

            n2 = q2.first();
            n3 = q3.first();
            n5 = q5.first();

            Long min = Math.min(Math.min(n2, n3), n5);
            TreeSet<Long> q = null;
            if(min == n2) {
                q = q2;
            } else if(min == n3) {
                q = q3;
            } else {
                q = q5;
            }

            if(!set.contains(q.pollFirst())) {      // New nth Ugly number
                q.add(min * 2L);
                q.add(min * 3L);
                q.add(min * 5L);
                count++;
                num = min;
                set.add(min);
            }
        }
        return num.intValue();
    }

}
