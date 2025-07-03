package com.prometheous.coding.design;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class AuthenticationManager {

    int ttl;
    Map<String, Integer> tokenMap;

    public AuthenticationManager(int timeToLive) {
        ttl = timeToLive;
        tokenMap = new ConcurrentHashMap<>();
    }

    public void generate(String tokenId, int currentTime) {
        tokenMap.put(tokenId, currentTime + ttl);
    }

    public void renew(String tokenId, int currentTime) {
        if(tokenMap.containsKey(tokenId) && tokenMap.get(tokenId) > currentTime - ttl) {
            tokenMap.put(tokenId, currentTime + ttl);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        return (int) tokenMap.entrySet()
                .stream()
                .peek(System.out::println)
                .filter(entry -> entry.getValue() > currentTime - ttl)
                .count();
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */