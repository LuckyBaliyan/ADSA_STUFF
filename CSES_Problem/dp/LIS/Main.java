package CSES_Problem.dp.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static long getLis(long [] arr){
        int n = arr.length;

        long [][] dp = new long[n+1][n+1];

        for(int i = n-1;i>=0;i--){
            for(int prev = -1;prev<= i-1;prev++){
                long take = 0;
                if(prev == -1 || arr[i] > arr[prev]){
                    take = 1 + dp[i+1][i+1];
                }

                long notTake = dp[i+1][prev + 1];
                dp[i][prev+1] = Math.max(take,notTake);
            }
        }

        return dp[0][0];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(getLis(arr));
    }
}
