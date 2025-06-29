package com.prometheous.coding.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TumblingCountWindow {

    static class Event {
        private String id;
        private long timestamp;
        private String data;

        public Event(String id, String data) {
            this.id = id;
            this.data = data;
            this.timestamp = System.currentTimeMillis();
        }

        public String getId() { return id; }
        public String getData() { return data; }
        public long getTimestamp() { return timestamp; }

        @Override
        public String toString() {
            return "Event{id='" + id + "', data='" + data + "'}";
        }
    }

    /**
     * Processes a list of events into tumbling windows based on a fixed count.
     * Each window will contain 'windowSize' events, and windows do not overlap.
     *
     * @param events The list of input events.
     * @param windowSize The number of events in each window.
     * @return A list of lists, where each inner list represents a window of events.
     */
    public static List<List<Event>> processTumblingCountWindow(List<Event> events, int windowSize) {
        if (events == null || events.isEmpty() || windowSize <= 0) {
            return new ArrayList<>();
        }

        AtomicInteger counter = new AtomicInteger(0); // To keep track of the index for grouping

        // We use IntStream to generate indices and then map them to window groups.
        // GroupingBy with a custom key (index / windowSize) will create the tumbling windows.
        return new ArrayList<>(events.stream()
                .collect(Collectors.groupingBy(e -> counter.getAndIncrement() / windowSize))
                .values()); // Get the lists of events (the windows) from the map values
    }

    public static void main(String[] args) {
        // Simulate a stream of 10 events
        List<Event> eventStream = IntStream.range(0, 10)
                .mapToObj(i -> new Event("event-" + i, "data-" + i))
                .collect(Collectors.toList());

        System.out.println("Original Events: " + eventStream);

        int windowSize = 3;
        List<List<Event>> windows = processTumblingCountWindow(eventStream, windowSize);

        System.out.println("\n--- Tumbling Windows (Count-Based, size " + windowSize + ") ---");
        for (int i = 0; i < windows.size(); i++) {
            System.out.println("Window " + (i + 1) + ": " + windows.get(i));
        }
    }
}
