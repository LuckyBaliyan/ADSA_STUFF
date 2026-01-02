package CSES_Problem.dp.Removing_Digits;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int solve(int n,int [] dp){
        if(n == 0)return 0;

        if(dp[n] != -1)return dp[n];

        int temp = n;
        int ans = Integer.MAX_VALUE;

        while(temp > 0){
            int d = temp % 10;
            temp /= 10;

            if(d != 0){
                ans = Math.min(ans,1 + solve(n - d, dp));
            }
        }

        return dp[n] =  ans;
    }

    public static int solveTab(int n){
        int [] dp = new int [n+1];

        dp[0] = 0;

        for(int i = 1;i<=n;i++){
            int temp = i;
            dp[i] = Integer.MAX_VALUE;

            while (temp > 0) {
                int dig = temp % 10;
                temp = temp / 10;

                if(dig != 0){
                    dp[i] = Math.min(dp[i], 1 + dp[i - dig]);
                }
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        //int copy = n;
        //int ways = 0;

        /* 
        while(copy > 0){
           int lastNum = 0;
           if(copy % 10 != 0){
            lastNum = copy % 10; 
            copy = copy - lastNum;
            ways++;
           }
           else{
            int sec = copy / 10;
            lastNum = sec % 10;
            copy = copy - lastNum;
            ways++;
           }
        }
        */

        /* 
        while( n > 0){
            int temp = n;
            int max = 0;

            while(temp > 0){
                int d = temp % 10;
                max = Math.max(max,d);
                temp /= 10; 
            }

            n -= max;
            ways++;
        }
        */
        
        //int [] dp = new int [n + 1];
        //Arrays.fill(dp,-1);

        System.out.println(solveTab(n));
    }
}
