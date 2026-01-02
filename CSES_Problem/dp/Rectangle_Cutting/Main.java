package CSES_Problem.dp.Rectangle_Cutting;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an a \times b rectangle, your task is to cut it into squares. On each move you can select a rectangle and cut it into two rectangles in such a way that all side lengths remain integers. What is the minimum possible number of moves?
Input
The only input line has two integers a and b.
Output
Print one integer: the minimum number of moves.
Constraints

1 \le a,b \le 500

Example
Input:
3 5

Output:
3
*/

public class Main {
    public static int solve(int a ,int b,int [][] dp){

        if(a == b)return 0;

        if(dp[a][b] != -1)return dp[a][b];

        int ans = Integer.MAX_VALUE;

        for(int i = 1;i<a;i++){
          ans = Math.min(
            ans,
            1 + solve(i, b, dp) + solve(a - i, b, dp)
          );
        }

        for(int j = 1;j<b;j++){
          ans = Math.min(
            ans,
            1 + solve(a, j, dp) + solve(a, b - j, dp)
          );
        }

        return dp[a][b] = ans;
    }

    public static int solveTab(int a,int b){
        int [][] dp = new int[a+1][b+1];

        for(int i = 1;i<=a;i++){
            for(int j = 1;j<=b;j++){
                if(i == j) dp[i][j] = 0;
                else{
                    dp[i][j] = Integer.MAX_VALUE;

                    for(int k = 1;k<j;k++){
                        dp[i][j] = Math.min(dp[i][j],
                            1+dp[i][k]+dp[i][j - k]
                        );
                    }

                    for(int k = 1;k<i;k++){
                        dp[i][j] = Math.min(dp[i][j], 
                            1+dp[k][j]+dp[i-k][j]
                        );
                    }
                }
            }
        }

        return dp[a][b];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        //int [][]  dp  = new int [a+1][b+1];
        //for(int [] arr:dp)Arrays.fill(arr,-1);

        System.out.println(solveTab(a, b));
    }
}
