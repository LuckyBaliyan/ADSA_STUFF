package classRoom.Arrays.Second_Max;

class Solution {
    public static int secondLargestElement(int[] nums) {
       int n = nums.length;

       int max = nums[0];
       int secmax = Integer.MIN_VALUE;

       for(int i = 1;i<n;i++){
        if(nums[i] > max){
            secmax = max;
            max = nums[i];
        }
        else if(nums[i] != max && nums[i] > secmax) secmax = nums[i];
        else continue;
       }

       if(secmax == Integer.MIN_VALUE) return -1;
       return secmax;
    }

    public static void main(String[] args) {
        System.out.println(secondLargestElement(new int [] {1,2,3,4,5,6,7,8,8}));
    }
}
