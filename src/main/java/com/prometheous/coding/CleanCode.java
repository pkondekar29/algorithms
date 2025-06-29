package com.prometheous.coding;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CleanCode {

   /**
    *
    * Long code is not good code.
    *
    * A function should be small.
    *
    * A function should do only 1 thing
    *
    * Max 2-3 Arguments in function
    *
    * Avoid switch/ if else statements
    *
    * No side effects in a function
    *
    * DRI (Don't repeat yourself)
    *
    * SOLID => Single responsibility, Open closed, Liskov substitution, Interface segregation, Dependency injection
    */

   public static class Song {
       Integer songId;
       String title;

       Song(String title) {
           this.title = title;
       }
   }

    public static class SongPlayed {
        Integer songId;
        Integer userId;

        SongPlayed(Integer songId, Integer userId) {
            this.songId = songId;
            this.userId = userId;
        }

        Integer getSongId() {
            return this.songId;
        }

        @Override
        public boolean equals(Object other) {
            if(other == null) return false;
            if(other == this) return true;
            if(!(other instanceof SongPlayed)) return false;
            SongPlayed otherSongPlayed = (SongPlayed) other;
            return this.songId.equals(otherSongPlayed.songId) && this.userId.equals(otherSongPlayed.userId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(songId, userId);
        }

    }

    public static class SongRepo {
       Map<Integer, Song> songs = new HashMap<>();
       AtomicInteger atomicInteger = new AtomicInteger();

       Song add(Song song) {
           song.songId = (Integer) atomicInteger.incrementAndGet();
           this.songs.put(song.songId, song);
           return song;
       }

    }

    public static class SongPlayedRepo {
        Set<SongPlayed> songPlayedMap = new HashSet<>();

        boolean add(Integer songId, Integer userId) {
            SongPlayed songPlayed = new SongPlayed(songId, userId);
            if(!songPlayedMap.contains(songPlayed)) {
                songPlayedMap.add(songPlayed);
                return true;
            }
            return false;
        }

    }

    public static class Library {

       private SongRepo songRepo;
       private SongPlayedRepo songPlayedRepo;

       public Library() {
           this.songRepo = new SongRepo();
           this.songPlayedRepo = new SongPlayedRepo();
       }

       Song addSong(String title) {
           return this.songRepo.add(new Song(title));
       }

        boolean playSong(Integer songId, Integer userId) {
           return this.songPlayedRepo.add(songId, userId);
        }

        public void printAnalytics() {

           this.songPlayedRepo.songPlayedMap
                   .stream()
                   .collect(Collectors.groupingBy(SongPlayed::getSongId, Collectors.mapping(SongPlayed::getSongId, Collectors.counting())))
                   .entrySet()
                   .stream()
                   .sorted(Comparator.comparingLong(Map.Entry::getValue))
                   .forEach(entry -> System.out.println("SongId: " + entry.getKey() + " Played: " + entry.getValue() + " times"));
        }

    }

   public static void main(String[] args) {
       Library library = new Library();
       library.addSong("Hello");
       library.addSong("Bean");
       library.addSong("three");
       library.addSong("four");
       library.addSong("five");

       library.playSong(1, 1);
       library.playSong(2, 1);
       library.playSong(3, 1);
       library.playSong(1, 1);
       library.playSong(3, 1);
       library.playSong(3, 2);

       library.printAnalytics();
   }

}
