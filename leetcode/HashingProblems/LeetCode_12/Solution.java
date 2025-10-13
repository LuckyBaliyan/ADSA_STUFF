package leetcode.HashingProblems.LeetCode_12;

/** Integer To ROman Number */

public class Solution {
    static String giveRoman(int num){
        String s = new String();
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] romans  = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        int i = 0;

        while(num>0){
            if(num>=nums[i]){
                s += romans[i];
                num -= nums[i];
            }
            else{
                i++;
            }
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(giveRoman(12));
    }
    
}
