package com.prometheous.coding.model;

import java.util.Objects;

public class Person {

   String name;
   int number;

   Person(String name, int number) {

      this.name = name;
      this.number = number;
   }

   @Override
   public boolean equals(Object o) {

      if (this == o)
         return true;
      if (o == null || getClass() != o.getClass())
         return false;
      Person person = (Person) o;
      return number == person.number && name.equals(person.name);
   }

   @Override
   public int hashCode() {

      return Objects.hash(name, number);
   }
}
