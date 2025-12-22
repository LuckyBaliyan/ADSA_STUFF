package ClassTests.DP.Cut_Ribbons;

import java.util.Arrays;
import java.util.Scanner;

public class sollusan {
  
    public static int cutRibbons(int [] arr,int target){
        int n = arr.length;
        int [][] dp = new int [n][target+1];
        for(int [] a:dp) Arrays.fill(a,-1);
        return solveTab(arr,target);
    }

    /* Plain Recursion */
    public static int solve(int [] arr,int target,int i){
        if(target == 0)return 0;
        if(i < 0)return Integer.MIN_VALUE;

        int notSkip = Integer.MIN_VALUE;
        if(arr[i] <= target){
            notSkip = 1+solve(arr,target - arr[i],i);
        }
        int skip = solve(arr,target,i-1);

        return Math.max(notSkip, skip);
    }

    /* Memoization */
     public static int solveMemo(int [] arr,int target,int i,int [][] dp){
        if(target == 0)return 0;
        if(i < 0)return Integer.MIN_VALUE;

        if(dp[i][target] != -1)return dp[i][target];

        int notSkip = Integer.MIN_VALUE;
        if(arr[i] <= target){
            notSkip = 1+solve(arr,target - arr[i],i);
        }
        int skip = solve(arr,target,i-1);

        return dp[i][target] =  Math.max(notSkip, skip);
    }

    /* Tabulation */
    public static int solveTab(int [] arr,int target){
        int n = arr.length;
        int [][] dp = new int [n][target+1];

        for(int i = 0;i<n;i++){
            dp[i][0] = 0;
        }

        for(int j = 0;j<= target;j++){
            if(j % arr[0] == 0)dp[0][j] = j / arr[0];
            else dp[0][j] = Integer.MIN_VALUE;
        }

        for(int i = 1;i<n;i++){
            for(int j = 1;j<=target;j++){
                int notSkip = Integer.MIN_VALUE;
                if(j >= arr[i]){
                    notSkip = dp[i][j - arr[i]] + 1;
                }
                int skip = dp[i-1][j];
                dp[i][j] = Math.max(notSkip, skip);
            }
        }

        return dp[n-1][target];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        System.out.println(cutRibbons(new int[] {a,b,c}, n));
        sc.close();
    }
}
