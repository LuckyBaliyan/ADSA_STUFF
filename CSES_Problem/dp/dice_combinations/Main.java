package CSES_Problem.dp.dice_combinations;

import java.util.Scanner;

public class Main {
    public static int MOD = 1000000007;
    public static long giveWays(int n){

        long [] dp = new long[n+1];

        dp[n] = 1;

        for(int i = n - 1;i>=0;i--){
           long ways = 0;
           for(int j = 1;j<=6;j++){
             if(i + j <= n)ways = (ways+dp[i+j])%MOD;
           }

           dp[i] = ways;
        }

        return dp[0];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();

        System.out.println(giveWays(n));
    }
}
