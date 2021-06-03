package com.prometheous.coding.queue;

import java.util.PriorityQueue;

public class NthUglyNumber {

    public static void main(String[] args) {
        System.out.println(findNthUglyNumberEff(39));
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

}
