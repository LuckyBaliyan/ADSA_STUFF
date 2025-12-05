package leetcode.DP.Day_01.ClimbStairs;

public class Solution {
    static int  climbstairs(int n,int i){
       if(i > n)return 0;
       if(i == n) return 1;

       return climbstairs(n, i+1)+climbstairs(n, i+2);
    }

    static int climbStairsRec2(int n){
        if(n<=1)return 1;

        return climbStairsRec2(n-1)+climbStairsRec2(n-2);
    }

    static int climbStairsMemo(int n,int [] dp){
        if(n<=1)return 1;

        if(dp[n] != -1)return dp[n];

        dp[n] = climbStairsMemo(n-1, dp)+climbStairsMemo(n-2, dp);
        return dp[n];
    }

    static int climbStairsTab(int n,int [] dp){
        if(n<=1)return 1;

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }

        return dp[n];
    }

    static int climbStairsSpaceOptimzedDp(int n){
        int prev = 1;
        int prev2 = 1;

        for(int i = 2;i<=n;i++){
            int curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }

        return  prev;
    }

    public static void main(String[] args) {
        System.out.println(climbstairs(4, 0));
        System.out.println(climbStairsRec2(4));

        System.out.println(climbStairsMemo(4, new int [] {-1,-1,-1,-1,-1}));

        System.out.println(climbStairsTab(4, new int [] {-1,-1,-1,-1,-1}));

        System.out.println(climbStairsSpaceOptimzedDp(4));
    }
}
