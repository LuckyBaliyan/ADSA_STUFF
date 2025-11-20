package CodeForces.Recursion.PalindromicArray;

public class Solution {
    static boolean isPalindromic(int [] nums,int n,int left,int right){
        if(n == 1) return true;

        if(left >= right) return true;

        if(nums[left] != nums[right]) return false;
        return isPalindromic(nums, n, left+1, right-1);
    }

    public static void main(String[] args) {
        int [] newArray  = {1,2,3,2,1};
        System.out.println(isPalindromic(newArray,newArray.length,0,newArray.length-1));
    }
}
