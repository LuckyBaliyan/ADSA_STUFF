package leetcode.HashingBasic.MapsHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostandLeastFreaquent {
    static List<List<Integer>> mostAndLeastFrequnet(int [] nums){
        //Brutre Force 
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int max_elem = 0;
        int min_elem = Integer.MAX_VALUE;

        for(int i = 0;i<nums.length;i++){
            int count = 0;
            for(int j = 0;j<nums.length;j++){
                if(nums[i] == nums[j]) count++;

                if(count>max){
                    max = count;
                    max_elem = nums[i];
                }

                if(count<min){
                    min = count;
                    min_elem = nums[i];
                }

            }
        }

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> pair = new ArrayList<>();
        pair.add(max_elem);
        pair.add(min_elem);
        list.add(pair);

        return list;
    }

    static List<List<Integer>> optimalCount(int [] nums){
        //Optimal Using HashMap
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();

        for (int num: nums) {
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Map.Entry<Integer,Integer> e:mp.entrySet()){
            min = Math.min(min, e.getValue());
            max = Math.max(max, e.getValue());

        }

        List<Integer> pair = new ArrayList<>();
      
        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            if(e.getValue() == min){
                pair.add(e.getKey());
            }

            if(e.getValue() == max){
                pair.add(e.getKey());
            }
        }
        
        list.add(pair);
        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list2 = new ArrayList<>();
        list2.addAll(mostAndLeastFrequnet(new int [] {1,1,1,2,3,3}));

        System.out.println(list2);


        List<List<Integer>> list3 = new ArrayList<>();
        list3.addAll(optimalCount(new int [] {1,1,1,2,3,3}));

        System.out.println(list3);
    }
}
