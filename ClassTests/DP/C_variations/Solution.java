package ClassTests.DP.C_variations;

import java.util.Arrays;

/**
 * 
 * C - Vacation  / 
Time Limit: 2 sec / Memory Limit: 1024 MiB

Score : 
100 points

Problem Statement
Taro's summer vacation starts tomorrow, and he has decided to make plans for it now.

The vacation consists of 
N days. For each 
i (
1≤i≤N), Taro will choose one of the following activities and do it on the 
i-th day:

A: Swim in the sea. Gain 
a 
i
​
  points of happiness.
B: Catch bugs in the mountains. Gain 
b 
i
​
  points of happiness.
C: Do homework at home. Gain 
c 
i
​
  points of happiness.
As Taro gets bored easily, he cannot do the same activities for two or more consecutive days.

Find the maximum possible total points of happiness that Taro gains.

Constraints
All values in input are integers.
1≤N≤10 
5
 
1≤a 
i
​
 ,b 
i
​
 ,c 
i
​
 ≤10 
4
 
Input
Input is given from Standard Input in the following format:

N
a 
1
​
  
b 
1
​
  
c 
1
​
 
a 
2
​
  
b 
2
​
  
c 
2
​
 
:
a 
N
​
  
b 
N
​
  
c 
N
​
 
Output
Print the maximum possible total points of happiness that Taro gains.

Sample Input 1
Copy
3
10 40 70
20 50 80
30 60 90
Sample Output 1
Copy
210
If Taro does activities in the order C, B, C, he will gain 
70+50+90=210 points of happiness.

Sample Input 2
Copy
1
100 10 1
Sample Output 2
Copy
100
Sample Input 3
Copy
7
6 7 8
8 8 3
2 5 2
7 8 6
4 6 8
2 3 4
7 5 1
Sample Output 3
Copy
46
Taro should do activities in the order C, A, B, A, C, B, A.
 * 
 */

public class Solution {

    public static int N = 3;
    public static int [][] arr = {{10,40,70},{20,50,80},{30,60,90}};

    public static int [][] dp = new int[N][3];

    public static int happyPoints(){
        //return solve(0,0);
        for(int [] ar:dp){
        Arrays.fill(ar,-1);
        }
        //return solve(0, 0, dp);
        return solveTab();
    };

    public static int solveTab(){
        int [][] dp = new int [N][3];

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i =1;i<N;i++){
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][2])+arr[i][0];
            dp[i][1] = Math.max(dp[i-1][0],dp[i-1][2])+arr[i][1];
            dp[i][2] = Math.max(dp[i-1][0],dp[i-1][1])+arr[i][2];
        }

        return Math.max(Math.max(dp[N-1][0], dp[N-1][1]),dp[N-1][2]);
    }


    public static int solve(int days,int last,int [][] dp){
        if(days == N)return 0;

        if(dp[days][last] != -1)return dp[days][last];

        
        int max = 0;

        if(last != 0){
            max = Math.max(max,arr[days][0]+solve(days+1, 0,dp));
        }
        if(last != 1){
            max = Math.max(max, arr[days][1]+solve(days+1, 1,dp));
        }
        if(last != 2){
            max = Math.max(max,arr[days][2] + solve(days+1,2,dp));
        }

        return dp[days][last] = max;

    }

    /* Plalin Recursive 
    public static int solve(int days, int last){
        if(days == N)return 0;

        int max = 0;

        if(last != 0){
            max = Math.max(max,arr[days][0]+solve(days+1, 0));
        }
        if(last != 1){
            max = Math.max(max, arr[days][1]+solve(days+1, 1));
        }
        if(last != 2){
            max = Math.max(max,arr[days][2] + solve(days+1,2));
        }

        return max;
    }
    */

    public static void main(String[] args) {
        System.out.println(happyPoints());
    }
}
