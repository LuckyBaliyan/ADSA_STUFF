package gfg.Recursion;

import java.util.ArrayList;

/*
Given an array of integers arr[]. You have to find the Inversion Count of the array. 
Note : Inversion count is the number of pairs of elements (i, j) such that i < j and arr[i] > arr[j].

Examples:

Input: arr[] = [2, 4, 1, 3, 5]
Output: 3
Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
Input: arr[] = [2, 3, 4, 5, 6]
Output: 0
Explanation: As the sequence is already sorted so there is no inversion count.
Input: arr[] = [10, 10, 10]
Output: 0
Explanation: As all the elements of array are

*/


public class Solution {
    static int coutInversions(int [] nums){
        int n = nums.length;
        return mergeSortInversion(nums,0,n-1);
    }

    static int mergeSortInversion(int [] nums,int l,int h){
        if(l>=h)return 0;
        int count  = 0;
        int mid = l+(h-l)/2;
        count += mergeSortInversion(nums, l, mid);
        count += mergeSortInversion(nums, mid+1, h);
        count += merge(nums,l,mid,h);

        return count;
    }

    static int merge(int [] nums,int l,int mid,int h){
        ArrayList<Integer> temp = new ArrayList<>();
        int count  = 0;

        int left = l;
        int right = mid+1;

        while (left <= mid && right<= h) {
            if(nums[left]>nums[right]){
                count += (mid - left + 1);
                temp.add(nums[right++]);
            }
            else{
                temp.add(nums[left++]);
            }
        }

        while (left <= mid) {
           temp.add(nums[left++]); 
        }
        
        while (right<=h) {
            temp.add(nums[right++]);
        }

        for(int i = 0;i<temp.size();i++){
            nums[l+i] = temp.get(i);
        }

        return count;
    }

    public static void main(String[] args) {
        int [] arr = {2,4,1,3,5};
        System.out.println(coutInversions(arr));
    }
}
