package leetcode.DP.FrogJump;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    static int [][] dp;
    static HashMap<Integer,Integer> map;
    public static boolean solveTab(int [] arr){
        int n = arr.length;

        dp[0][0] = 1; //first stone is reachable

        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){

                if(dp[i][j] == 0)continue; // expand only reachable states

                int f = j - 1;
                int s = j;
                int t = j + 1;

                if(f >= 0 && f < n && map.containsKey(f + arr[i]))
                    dp[map.get(f + arr[i])][f] = 1;
                if(s >= 0 && s < n && map.containsKey(s + arr[i]))
                    dp[map.get(s + arr[i])][s] = 1;
                if(t >= 0 && t < n && map.containsKey(t + arr[i]))
                    dp[map.get(t + arr[i])][t] = 1;
            }
        }

        //at last check if the last n-1 position is reachable from any value of j 
        for(int i = 0;i<n;i++){
            if(dp[n-1][i] == 1)return true;
        }

        return false;
    }
    public static void main(String[] args) {
        dp = new int[8][8];

        map = new HashMap<>();

        int [] stones = {0,1,3,5,6,8,12,17};
       //int [] stones = {0,1,2,3,4,8,9,11};

        for(int i = 0;i<stones.length;i++)map.put(stones[i], i);

        System.out.println(solveTab(stones));

        for(int [] ar:dp){
            for(int i: ar)System.out.print(i+" ");

            System.out.println();
        }
    }
}
