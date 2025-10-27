package classRoom.Arrays.LeetCode_121;

/**
 * Best Timw to buy and sell a stock
 */

public class Solution {
    //Brute Force 
    static int bestTimetosellStock(int [] nums){
        int n = nums.length;

        int maxProfit = 0;

        for(int i = 0;i<n-1;i++){
            int computedProfit = 0;
            for(int j = i+1;j<n;j++){
                computedProfit = nums[j] - nums[i];
                maxProfit = Math.max(maxProfit,computedProfit);
            }
        }

        return maxProfit > 0?maxProfit:0;
    }

    //Optimal (DP)
    static int bestTimetosellStockOptimal(int [] nums){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int num:nums){
            if(num < minPrice){
                minPrice = num;
            }
            else{
                maxProfit = Math.max(maxProfit,num - minPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int [] arr = {7,1,2,5,6,4};
        System.out.println(bestTimetosellStock(arr));

        System.out.println(bestTimetosellStockOptimal(arr));
    }
}
