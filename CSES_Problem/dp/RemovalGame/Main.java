

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long [][] dp;

    //Recursive  + Memo solution
    public static long solve(long [] arr,int l,int r){
        if(l == r)return arr[l];

        if(dp[l][r] != -1)return  dp[l][r];

        long takeLeft =  (arr[l] - solve(arr, l+1, r));
        long takeRight =  (arr[r] - solve(arr, l, r-1));

        return dp[l][r] = Math.max(takeLeft,takeRight);

    }

    //Space optimized tabulation approach
    public static long solveTab(long [] arr){
        int n = arr.length;

        long [] curr = new long[n];
        long [] next = new long[n];

       for(int i = 0;i<n;i++)next[i] = arr[i];

       for(int i = 1;i<n;i++){
        curr[i] = arr[i];
        for(int j = i-1;j>=0;j--){
            curr[j] = Math.max((arr[j] - curr[j+1]), arr[i] - next[j]);
        }
        next = curr.clone();
       }

    //top right corner
       return next[0];
    }

    //just for checking the dp fillUp
    public static void solveTab2(long [] arr){
        int n = arr.length;

        long [][] dp  = new long [n][n];

       for(int i = 0;i<n;i++)dp[i][i] = arr[i];

       for(int i = 1;i<n;i++){
        for(int j = i-1;j>=0;j--){
            dp[j][i] = Math.max((arr[j] - dp[j+1][i]), arr[i] - dp[j][i - 1]);
        }
       }

      //top right corner
       for(int i = 0;i<n;i++){
        for(int j = 0;j<n;j++)System.out.print(dp[i][j]+" ");
        System.out.println();
       }
    }
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int n = sc.nextInt();

        long [] arr = new long [n];
        long totalSum = 0;


        for(int i = 0;i<n;i++){
           arr[i] = sc.nextLong();
           totalSum += arr[i];
        }

        /*dp = new long [n][n];
        for(long[] a:dp)Arrays.fill(a,-1);*/

        long diff = solveTab(arr);
    

        long ans = (totalSum + diff )/2;

        System.out.println(ans);
    }
}
