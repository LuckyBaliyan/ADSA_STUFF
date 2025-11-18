package leetcode.Arrays2.LeetCode_493;

import java.util.ArrayList;

public class Solution {
    static void merge(int [] nums,int low,int mid,int high){
        int left = low;
        int right = mid+1;

        ArrayList<Integer> temp = new ArrayList<>();

        while (left <= mid && right<=high) {
            if(nums[left] > nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }

        while(left<=mid){
            temp.add(nums[left]);
            left++;
        }

        while (right<=high) {
            temp.add(nums[right]);
            right++;
        }

        for(int i = low;i<=high;i++){
            nums[i] = temp.get(i-low);
        }
    }

    static int countPairs(int [] nums,int low,int mid,int high){
        int right = mid+1;
        int left = low;
        int count = 0;

        for(int i = left;i<=mid;i++){
           while (right<=high && nums[i] > (long) nums[right]*2) {
            right++;
           }
           count += (right - (mid+1));
        }

        return count;
    }

    static int meregSort(int [] nums,int low ,int high){
        int cnt = 0;
        if(low>=high) return cnt;
        int mid = (low+high)/2;
        cnt+= meregSort(nums, low, mid);
        cnt+= meregSort(nums, mid+1, high);
        cnt+= countPairs(nums,low,mid,high);
        merge(nums, low, mid, high);
        return cnt;
    }
    static int reversePairs(int [] nums){
        return meregSort(nums,0,nums.length-1);
    }

    public static void main(String[] args) {
       System.out.println(reversePairs(new int [] {40,25,19,12,9,6,2})); // 18
    }
}
