//package CodeForces.DP.C_Yet_Another_Broken_Keyboard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static long [] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        dp = new long [n];
        Arrays.fill(dp, -1);

        String s = sc.next();
        Set<Character> st = new HashSet<>();

       for(int i = 0; i<k; i++){
         char ch = sc.next().charAt(0);
         st.add(ch);
       }

        long ans =  0;
        for(int i = 0;i<n;i++){
           ans += solve(s,i,st); // start with the next letter always
        }

        System.out.println(ans);
        sc.close(); 
    }

    public static long solve(String sb, int i, Set<Character> st){
        int n = sb.length();

        if(i >= n)return 0;

        if(dp[i] != -1)return dp[i];

        if(!st.contains(sb.charAt(i))){
            return 0;
        }

        return dp[i] =  1 + solve(sb, i+1, st);
    }
}
