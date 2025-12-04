package ClassTests.DP.climbStairs;

public class Solution {
    public static int climbStairs(int n){
        int [] dp  = new int [n+1];
        //return climbRec(n);
        //return climbTd(n,dp);
        //return climbTab(n, dp);

        return climbOptimal(n);
    }

    public static int climbRec(int n){
      if(n <= 1)return 1;
      return climbRec(n-2)+climbRec(n-1);
    }

    public static int climbTd(int n,int [] dp){
        if(n<=1)return 1;

        dp[n] = climbTd(n-2, dp)+climbTd(n-1, dp);
        return dp[n];
    }

    public static int climbTab(int n,int [] dp){
        if(n<=1)return 1;

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
           dp[i] = dp[i-2]+dp[i-1];
        }

        return dp[n];
    }

    public static int climbOptimal(int n){
        if(n<=1)return 1;

        int first = 1;
        int second = 1;

        for(int i = 2;i<=n;i++){
            int curr = first + second;
            first = second;
            second = curr;
        }

        return second;
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
