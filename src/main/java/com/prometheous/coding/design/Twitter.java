package com.prometheous.coding.design;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
class Twitter {

    private static final AtomicLong TIMESTAMP_GENERATOR = new AtomicLong(0);

    private static class Tweet {
        final int tweetId;
        final int userId;
        final long timestamp;

        public Tweet(int tweetId, int userId, long timestamp) {
            this.tweetId = tweetId;
            this.userId = userId;
            this.timestamp = timestamp;
        }

        public int getTweetId() {
            return tweetId;
        }

        public int getUserId() {
            return userId;
        }

        public long getTimestamp() {
            return timestamp;
        }
    }

    private static class User {
        final int userId;
        final Set<Integer> followedUsers;

        public User(int userId) {
            this.userId = userId;
            this.followedUsers = new HashSet<>();
            this.followedUsers.add(userId);
        }

        public void follow(int followeeId) {
            followedUsers.add(followeeId);
        }

        public void unfollow(int followeeId) {
            if (followeeId != userId) {
                followedUsers.remove(followeeId);
            }
        }

        public Set<Integer> getFollowedUsers() {
            return followedUsers;
        }
    }

    private final Map<Integer, User> users;
    private final List<Tweet> allTweets;

    public Twitter() {
        users = new HashMap<>();
        allTweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        users.putIfAbsent(userId, new User(userId));
        long timestamp = TIMESTAMP_GENERATOR.incrementAndGet();
        Tweet newTweet = new Tweet(tweetId, userId, timestamp);
        allTweets.add(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        User currentUser = users.get(userId);
        if (currentUser == null) {
            return Collections.emptyList();
        }
        Set<Integer> followedUsers = currentUser.getFollowedUsers();
        return allTweets.stream()
                .filter(tweet -> followedUsers.contains(tweet.getUserId()))
                .sorted(Comparator.comparingLong(Tweet::getTimestamp).reversed())
                .limit(10)
                .map(Tweet::getTweetId)
                .collect(Collectors.toList());
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        users.putIfAbsent(followerId, new User(followerId));
        users.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }

        User follower = users.get(followerId);
        if (follower != null) {
            follower.unfollow(followeeId);
        }
    }
}
