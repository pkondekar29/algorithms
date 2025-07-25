package com.prometheous.coding.design;

/**
 *
 * Focuses on bucketing
 */
public class HitCounter {
    int FIVE_MINS = 300;
    int[] timestamps = new int[FIVE_MINS];
    int[] hits = new int[FIVE_MINS];

    public HitCounter() {
    }

    public void hit(int timestamp) {
        int idx = timestamp % FIVE_MINS;

        if(timestamps[idx] != timestamp) {
            timestamps[idx] = timestamp;
            hits[idx] = 1;
        } else {
            hits[idx]++;
        }
    }

    public int getHits(int timestamp) {
        int total = 0;
        for(int i = 0; i < FIVE_MINS; i++) {
            if(timestamp - FIVE_MINS < timestamps[i]) {
                total += hits[i];
            }
        }
        return total;
    }
}
