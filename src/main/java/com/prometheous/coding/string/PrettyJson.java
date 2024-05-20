package com.prometheous.coding.string;

import java.util.ArrayList;
import java.util.List;

public class PrettyJson {

   public static void main(String[] args) {

      String[] strs = new PrettyJson().toPrettyJson("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]");
      for (String str : strs) {
         System.out.println(str);
      }
   }

   public String[] toPrettyJson(String str) {

      List<String> res = new ArrayList<>();
      int i = 0, indent = 0;
      while (i < str.length()) {
         if (str.charAt(i) == '{' || str.charAt(i) == '[') {
            res.add(getIndent(indent) + str.charAt(i));
            indent++;
            i++;
         } else if (str.charAt(i) == '}' || str.charAt(i) == ']') {
            indent--;
            String closingBracket = getIndent(indent) + str.charAt(i);
            i++;
            if (str.charAt(i) == ',') {
               closingBracket += ',';
               i++;
            }
            res.add(closingBracket);
         } else {
            String vars = "";
            while (i < str.length() && str.charAt(i) != '{' && str.charAt(i) != '[' && str.charAt(i) != '}'
                  && str.charAt(i) != ']' && str.charAt(i) != ',' && str.charAt(i) != ':') {
               vars += str.charAt(i);
               i++;
            }
            while (i < str.length() && str.charAt(i) != '{' && str.charAt(i) != '[' && str.charAt(i) != '}'
                  && str.charAt(i) != ']' && str.charAt(i) != ',') {
               vars += str.charAt(i);
               i++;
            }
            if (i < str.length() && (str.charAt(i) == ',' || str.charAt(i) == ':')) {
               vars += str.charAt(i);
               i++;
            }
            res.add(getIndent(indent) + vars);
         }
      }
      return res.toArray(new String[res.size()]);
   }

   private String getIndent(int tabs) {

      String indent = "";
      for (int i = 0; i < tabs; i++) {
         indent += "\t";
      }
      return indent;
   }

}
