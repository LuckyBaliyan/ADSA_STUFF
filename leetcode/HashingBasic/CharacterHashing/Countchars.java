package leetcode.HashingBasic.CharacterHashing;

import java.util.Arrays;

public class Countchars {
    public static void main(String[] args) {
        String s = "abcdaaedczpa";
        int n = s.length();

        //Make an frequency array.
        int [] freq = new int [26];
        Arrays.fill(freq,0);

        //store every characetr frequency
        for(int i = 0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }

        for (int i : freq) {
            System.out.print("["+i+"]");
        }

        System.out.println();

        System.out.println(freq['a'-'a']);
        System.out.println(freq['d'-'a']);
    }
}
