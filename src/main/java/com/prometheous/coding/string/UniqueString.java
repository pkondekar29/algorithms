package com.prometheous.coding.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class UniqueString<T, E> {

   public static void main(String[] args) throws Exception {
      //        List<String> dupList = Arrays.asList("orange", "apple", "banana", "apple");
      //        deDuplicate(dupList).forEach(System.out::println);

      Arrays.stream(new UniqueString<Integer, Integer>().identifyClasses(1, 2)).iterator()
            .forEachRemaining(System.out::println);
   }

   public String[] identifyClasses(T parameterOne, E parameterTwo) throws Exception {

      String[] classTypes = new String[2];
      classTypes[0] = parameterOne.getClass().getName();
      classTypes[1] = parameterTwo.getClass().getName();
      return classTypes;
   }

   private static List<String> deDuplicate(List<String> dupList) {

      HashSet<String> uniques = new HashSet<>();
      List<String> unqiueList = new ArrayList<>();
      for (String word : dupList) {
         if (!uniques.contains(word)) {
            unqiueList.add(word);
            uniques.add(word);
         }
      }
      return unqiueList;
   }

}
