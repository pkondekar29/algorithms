package com.prometheous.coding.model;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Node {

   public int val;
   public List<Node> neighbors;

   public Node() {

   }

   public Node(int _val) {

      val = _val;
      neighbors = new ArrayList<>();
   }

   public Node(int _val, List<Node> _neighbors) {

      val = _val;
      neighbors = _neighbors;
   }
};