package gfg.DP.PrintLIS;

import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> getLIS(int arr[]) {
        // Code here
        int n = arr.length;
        ArrayList<Integer> res =  new ArrayList<>();
        solve(arr,res);
        
        return res;
    }
    
    public static void solve(int [] arr,ArrayList<Integer> res){
        
        int n = arr.length;
        
        //int [][] dp = new int [n+1][n+1];

        int [] curr = new int [n+1];
        int [] next =  new int [n+1];
        
        for(int i = n-1;i>=0;i--){
            for(int prev = -1;prev <= i- 1;prev++){
                int take = 0;
                if(prev == -1 || arr[i] > arr[prev]){
                    take = 1 + next[i+1];
                    
                }
                
                int notTake = next[prev + 1];
                curr[prev+1] = Math.max(take,notTake);
            }

            next = curr.clone();
        }   

        
       /*  for(int i = 0;i<n;i++){
            System.out.print(next[i]+" ");
        }
        */
    
        //System.out.println();

        int prev = -1;
        for(int i = 0;i<n;i++){
            if(prev == -1 || arr[i] > arr[prev]){
                if(next[i+1]+1 == next[prev+1]){
                    res.add(arr[i]);
                    prev = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(getLIS(new int [] {10,22,9,33,21,50,41,60,80}));
    }
}
