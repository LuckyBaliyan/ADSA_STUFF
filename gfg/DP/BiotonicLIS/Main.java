package gfg.DP.BiotonicLIS;

public class Main {
    public static int solve(int [] arr){
        int n = arr.length;

        int [] lis = new int[n+1];
        int [] lds = new int[n+1];

        for(int i = 0;i<n;i++){
            lis[i] = 1;
            for(int j = 0;j<i;j++){
                if(arr[i] > arr[j]){
                   lis[i] = Math.max(lis[i],lis[j] + 1); 
                }
            }
        }

        for(int i = n-1;i>=0;i--){
            lds[i] = 1;
            for(int j = n-1;j > i;j--){
              if(arr[i] > arr[j]){
                lds[i] = Math.max(lds[i],lds[j]+1);
              }
            }
        }

        int ans = 0;

        for(int i = 0;i<n;i++){
            if(lis[i] > 1 && lds[i] > 1){
                ans = Math.max(ans,(lis[i] + lds[i] - 1));
            }
        }

        return ans;

    }
    public static void main(String[] args) {
       System.out.println(solve(new int [] {1,2,5,3,2}));
    }
}
