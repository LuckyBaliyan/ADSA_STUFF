import java.util.Scanner;

public class Main {

    public static int giveCoins(int[] arr,int target){
        int n = arr.length;

        int [] prev = new int [target+1];
        int [] curr = new int [target + 1];

        for(int i = 0;i<=target;i++){
           if(i % arr[0] == 0)
           prev[i] = i / arr[0];
           else
           prev[i] = Integer.MAX_VALUE;
        }

        for(int i = 1;i<n;i++){
            curr[0] = 0;
            for(int j = 1;j<=target;j++){
                int take = Integer.MAX_VALUE;
                if(j >= arr[i] && curr[j - arr[i]] != Integer.MAX_VALUE)take = 1 + curr[j - arr[i]];
                curr[j] = Math.min(take,prev[j]);
            }

            int [] temp = prev;
            prev = curr;
            curr = temp;

        }

        return prev[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  n = sc.nextInt();
        int x = sc.nextInt();

        int [] arr = new int[n];

        for(int i = 0;i<n;i++){
           arr[i] = sc.nextInt();
        }

        //int [][] dp = new int [n][x+1];
        //for(int [] a:dp)Arrays.fill(a,-1);

        System.out.println(giveCoins(arr,x) == Integer.MAX_VALUE?-1:giveCoins(arr, x));
    }
}