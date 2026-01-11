package CSES_Problem.dp.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;


//Its is going Out of memeory in CSES constarits because its passing the dp[][] array limit of 
// java for big values so the most opimal approach of binarySearch + dp will works here

public class Main {
    public static int lisOptimal(long [] arr){
        int n = arr.length;
        long [] dp = new long[n];
        

        dp[0] = arr[0]; 
        //first element has to be there if we intented to find the greates length

        int len = 1; 

        for(int i = 1;i<n;i++){
            if(arr[i] > dp[len - 1]){
                dp[len] = arr[i];
                len++;
            }
            else{
                int idx = lb(0,len - 1,arr[i],dp);
                dp[idx] = arr[i];
            }
        }

        return len;

    }

    public static int lb(int l,int h,long elem,long [] dp){
        int res = 0;

        while (l<=h) {
            int mid = l + (h - l)/2;

            if(dp[mid] >= elem){
                res = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }

        return res;
    }


    public static long getLis(long [] arr){
        int n = arr.length;

        long [] curr = new long[n+1];
        long [] next = new long[n+1];

        for(int i = n-1;i>=0;i--){
            for(int prev = -1;prev<= i-1;prev++){
                long take = 0;
                if(prev == -1 || arr[i] > arr[prev]){
                    take = 1 + next[i+1];
                }

                long notTake = next[prev + 1];
                curr[prev+1] = Math.max(take,notTake);
            }
            next = curr.clone();
        }

        return next[0];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());
        long[] arr = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        System.out.println(lisOptimal(arr));
    }
}
