package leetcode.DP.Russian_dolls;

import java.util.Arrays;

public class Main {
    public static int maxDolls(int [][] arr){
        int n = arr.length;
        int m = arr[0].length;

        // Sort Width wise asc if widths are equal sort height wise desc
        Arrays.sort(arr,(a,b)-> a[0] == b[0]?b[1] - a[1]:a[0] - b[0]);

        
        /*for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        */

        //Extarcting heights for the LIS

        int [] lis = new int [n];
        for(int i = 0;i<n;i++)lis[i] = arr[i][1];

        //for(int i = 0;i<n;i++)System.out.print(lis[i]+" ");

        return solveRec(lis,0,-1);
    }

    public static int solveRec(int [] lis,int i,int prev){
        int n = lis.length;

        if(i == n)return 0;

        int take = 0;
        if(prev == -1 || lis[i] > lis[prev]){
           take = 1 + solveRec(lis, i+1, i);
        }

        int notTake  = solveRec(lis, i+1, prev);

        return Math.max(take, notTake);
    }
    public static void main(String[] args) {
        int res = maxDolls(new int [][] {{5,4},{6,4},{6,7},{2,3}});
        System.out.println(res);
    }
}
