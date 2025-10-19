package leetcode.Sorting.Questions.leetcode_242;

import java.util.HashMap;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.

 

Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false

 
 */

public class Solution {

    //Brute Force O(N^2)
    static boolean areAnagrams(String s, String t){
        if(s.length() != t.length()) return false;

        for(int i =0;i<s.length();i++){
            int countS = 0;
            int countT = 0;

            char ch = s.charAt(i);

            for(int j = 0;j<s.length();j++){
                if(s.charAt(j) == ch) countS++;
                if(t.charAt(j) == ch) countT++;
            }

            if(countS != countT) return false;
        }

        return true;
    }

    //Optimal O(N)
    static boolean areAnagramsOptimal(String s,String t){
        if(s.length() != t.length()) return false;

        int [] count = new int [26];

        for(int i =0;i<s.length();i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        //Check wheather the array is nutral or not if not 
        //that means we have some characters different int both the strings

        for(int i:count){
            if(i!=0) return false;
        }

        return true;
    }

    //HashMap Approach O(N);

    static boolean areAnagramsHash(String s, String t){
        if(s.length() != t.length()) return false;

        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(char ch:t.toCharArray()){
            if(!map.containsKey(ch)){
                return false;
            }

            map.put(ch,map.get(ch)-1);
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(areAnagrams("anagram", "nagaram"));
        System.out.println(areAnagrams("aacc", "cacc"));

        System.out.println(areAnagramsOptimal("aacc", "cacc"));
        System.out.println(areAnagramsHash("aacc", "cacc"));
    }
    
}
