package leetcode.Arrays.LeetCode_189;

/**
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

 */

public class Solution {

    //TC:- O(k*N)
    static void rotateBruteForce(int [] arr, int k){
        int n = arr.length;

        if(n== 0) return;

        while(k>0){
            int temp = arr[n - 1];
            for(int i = n-1;i>0;i--){
                arr[i] = arr[i-1];
            }

            arr[0] =  temp;
            k--;
        }
    }

    static void rotateOptimal(int [] arr, int k){
        int n = arr.length;
        if(n == 0) return;

        //Handinling size to make it dynamically logical for cases like K>n

        k = k%n;

        rev(arr,0,n-1);

        //initial reverse
        for(int a:arr) System.out.print(a+" ");

        rev(arr,0,k-1);
        //Reverse the previous half
        for(int j:arr) System.out.print(j+" ");


        rev(arr,k,n-1);
        //Remaining half reverse
        for(int y:arr) System.out.print(y+" ");

    }

    static void rev(int [] arr, int start, int end){
        while(start<end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2};
        int [] arr2 = {1,2,3,4,5,6,7};
        rotateBruteForce(arr2, 3);

        for(int a:arr2){
            System.out.print(a+" ");
        }

        rotateOptimal(arr2, 3);
    }
}
