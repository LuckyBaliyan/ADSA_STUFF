package leetcode.String.leetcode_14;

/**
 * Lonest comman Prefix
 */

public class Solution {
   static String longestPrefix(String[] strs){
      if(strs.length == 0)return "";

      int n = strs.length;

      //Take out first String and compare all by it letter by letter
      String Prefix = strs[0];

      for(int i = 0;i<Prefix.length();i++){
        char ch = Prefix.charAt(i);
        for(int j = 1;j<n;j++){
           if(strs[j].charAt(i) != ch || strs[j].length() <= i) 
           return Prefix.substring(0, i);
        }
      }

      return "";
   }
   
   public static void main(String[] args) {
     System.out.println(longestPrefix(new String[] {"Flower","Flow","Flight"}));
   }
}
