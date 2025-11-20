package leetcode.Recursion.LeetCode_704;

public class Solution {
    static int BinarySearch(int [] nums,int l,int h,int target){
        if(l > h) return -1;

        int mid = l+(h-l)/2;

        if(nums[mid] == target)return mid;

        else if(nums[mid] > target){
            return BinarySearch(nums, l, mid-1, target);
        }
        else{
            return BinarySearch(nums, mid+1, h, target);
        }
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,9,12};
        System.out.println(BinarySearch(arr, 0, arr.length-1, 9));
        System.out.println(BinarySearch(arr, 0, arr.length-1, 12));
        System.out.println(BinarySearch(arr, 0, arr.length-1, 1));
        System.out.println(BinarySearch(arr, 0, arr.length-1, 0));
    }
}
