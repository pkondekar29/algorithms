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
        int idx = timestamp % FIVE_MINS;            // modulo for 5 mins

        if(timestamps[idx] != timestamp) {  // keep the current timestamp from last 5 minutes to keep track of modulo
            timestamps[idx] = timestamp;        // If not, then we have passed 5 mins and update it
            hits[idx] = 1;      // reset counter
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
