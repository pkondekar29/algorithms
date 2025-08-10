package com.prometheous.coding.design;

import java.util.TreeSet;

public class SeatManager {

    int n;
    boolean[] seats;
    public SeatManager(int n) {
        this.n = n;
        this.seats = new boolean[n + 1];
    }

    public int reserve() {
        for(int i = 1; i <= this.n; i++) {
            if(!seats[i]) {
                seats[i] = true;
                return i;
            }
        }
        return -1;
    }

    public void unreserve(int seatNumber) {
        this.seats[seatNumber - 1] = false;
        TreeSet<Integer> set = new TreeSet<>();
    }
}
