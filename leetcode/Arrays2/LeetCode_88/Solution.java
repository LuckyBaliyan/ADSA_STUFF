package leetcode.Arrays2.LeetCode_88;

public class Solution {
    static void mergeSortedArray(int [] nums1, int m,int [] nums2,int n){
        if( m == 0 || n == 0) return;

        int i = m-1;
        int j = n-1;
        int k = (m+n) - 1;

        while(i>=0 && j>= 0){
            if(nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }
            else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        //Filling remaining elems

        while(j>=0){
            nums1[k] = nums2[j];
            j--; 
        }
    }

    public static void main(String[] args) {
        int [] nums1 = {1,2,3,0,0,0};
        int [] nums2 = {2,5,6};

        mergeSortedArray(nums1, 3, nums2, 3);

        for (int i : nums1) {
            System.out.print(i+" ");
        }
    }
}
