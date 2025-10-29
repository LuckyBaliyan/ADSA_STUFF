package leetcode.Arrays2.LeetCode_31;

/**
 * 31. Next Permutation
Solved
Medium
Topics
premium lock icon
Companies
A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).

For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.

The replacement must be in place and use only constant extra memory.

 

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
 

Constraints:

1 <= nums.length <= 100
0 <= nums[i] <= 100
 

 */

public class Solution {
    public static void nextPermutationOptimal(int [] nums){
        int n = nums.length;
        if(n <= 1) return;

        int indx = -1;

        for(int i =n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
              indx = i;
              break;
            }
        }

        if(indx == -1){
            reverse(nums, 0, n-1);
            return;
        }

        for(int i = n-1;i>=indx;i--){
            if(nums[i] > nums[indx]){
                swap(nums,i,indx);
                break;
            }
        }

        reverse(nums,indx+1,n-1);
    }

    public static void reverse(int [] arr,int start,int end){
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    public static void swap(int [] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    public static void main(String[] args) {
        int [] arr = {1,1,5};

        nextPermutationOptimal(arr);

        for(int n: arr){
            System.out.print(n+" ");
        }
    }
}
