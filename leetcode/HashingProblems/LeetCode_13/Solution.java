package leetcode.HashingProblems.LeetCode_13;

import java.util.HashMap;

public class Solution {
    static int romantoInt(String s){
        int num = 0;
        HashMap<String,Integer> mp = new HashMap<>();

        mp.put("I",1);
        mp.put("IV",4);
        mp.put("V",5);
        mp.put("IX",9);
        mp.put("X",10);
        mp.put("XL",40);
        mp.put("L",50);
        mp.put("XC",90);
        mp.put("C",100);
        mp.put("CD",400);
        mp.put("D",500);
        mp.put("CM",900);
        mp.put("M",1000);

        int i =0;
        while(i<s.length()){
            if(i+1<s.length() && mp.containsKey(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)))){
               num += mp.get(String.valueOf(s.charAt(i))+String.valueOf(s.charAt(i+1)));
               i+=2;
            }
            else{
                num += mp.get(String.valueOf(s.charAt(i)));
                i++;
            }

        }

        return num;
    }

    public static void main(String[] args) {
        int res = romantoInt("MMMDCCXLIX");
        System.out.println(res);
    }
}
