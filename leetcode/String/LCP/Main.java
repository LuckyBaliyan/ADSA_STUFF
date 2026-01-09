package leetcode.String.LCP;

import java.util.Arrays;

public class Main {
    public static void lcp(String [] arr){
        int n = arr.length;

        Arrays.sort(arr);
        for(String i: arr)System.out.println(i);
    }
    public static void main(String[] args) {
        lcp(new String [] {"flower","flow","flight"});
    }
}
