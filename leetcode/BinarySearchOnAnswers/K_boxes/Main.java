package leetcode.BinarySearchOnAnswers.K_boxes;

import java.util.Scanner;

public class Main {
    public static int solve(int [] arr,int k){
       int ans = 1;
       int l =  1;
       int h = sum(arr);

       while (l<=h) {
        int mid = l + (h - l)/2;
        ans = mid;
        if(helper(arr,mid,k)) h = mid - 1;
        else l = mid + 1;
       }

       return ans;
    }

    public static boolean helper(int [] arr,int mid,int k){
        int sum = 0;
        int parts = 1;

        for(int w : arr){
            if( w  > mid)return false;

            if(sum + w <= mid){
                sum += w;
            }
            else{
                parts++;
                sum = w;
            }
        }

        return parts<=k;
    }

    public static int sum(int [] arr){
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int[n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(solve(arr, k));
    }
}
