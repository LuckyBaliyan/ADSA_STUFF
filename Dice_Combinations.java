//package CSES_Problem.dp.dice_combinations;

import java.util.Arrays;
import java.util.Scanner;

public class Dice_Combinations {
    public static int giveWays(int n,int sum,int [] dp){
        if(sum == n)return 1;
        if(sum > n)return 0;

        if(dp[sum] != -1)return dp[sum];

        int ways = 0;
        for(int i = 1;i<=6;i++){
            ways += giveWays(n, sum+i,dp);
        }

        return dp[sum] = ways;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();

        int [] dp = new int [n+1];

        Arrays.fill(dp,-1);

        System.out.println(giveWays(n, 0,dp));
    }
}