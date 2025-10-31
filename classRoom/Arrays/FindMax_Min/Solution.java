package classRoom.Arrays.FindMax_Min;

import java.util.ArrayList;

public class Solution {
    static ArrayList<Integer> fineMaxAndMin(int [] nums){
        int n = nums.length;
        if(n == 0) return null;
        ArrayList<Integer> list = new ArrayList<>();

        if(n == 1){
            list.add(nums[0]);
            list.add(nums[0]);

            return list;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i<n;i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }

        list.add(min);
        list.add(max);

        return list;
    }

    public static void main(String[] args) {
        int [] nums = {1,2,3,4,5,6,0,5};
        ArrayList<Integer> res = fineMaxAndMin(nums);

        System.out.println(res);
    }
}
