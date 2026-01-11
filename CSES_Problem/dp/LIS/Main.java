package CSES_Problem.dp.LIS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.StringTokenizer;


//Its is going Out of memeory in CSES constarits because its passing the dp[][] array limit of 
// java for big values so the most opimal approach of binarySearch + dp will works here

public class Main {
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

        System.out.println(getLis(arr));
    }
}
