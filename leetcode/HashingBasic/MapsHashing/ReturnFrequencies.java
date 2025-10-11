package leetcode.HashingBasic.MapsHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array nums of size n which may contain duplicate elements, 
 * return a list of pairs where each pair contains a 
 * unique element from the array and its frequency in the array.
You may return the result in any order, but each element must appear exactly 
once in the output.
*/

public class ReturnFrequencies {
    public static List<List<Integer>> countFrequencies(int [] nums){
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> mp = new HashMap<>();

        //Cehck if nums exisit and then increment the corresponding freqnecy
        for (int num: nums) {
            mp.put(num,mp.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            List<Integer> pair = new ArrayList<>();
            pair.add(e.getKey());
            pair.add(e.getValue());
            list.add(pair);
        }

        return list;
    }

    public static void main(String[] args) {
        List<List<Integer>> list2 = new ArrayList<>();
        list2.addAll(countFrequencies(new int [] {1,2,1,1,2,45,2,1}));

        System.out.println(list2);
    }
}
