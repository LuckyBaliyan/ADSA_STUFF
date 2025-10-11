package leetcode.HashingBasic.MapsHashing;

import java.util.Map;
import java.util.HashMap;

public class Numbers {
    public static void main(String[] args) {
        int [] nums = {1,2,1,1,1,1,5,62,3,2,2,1};
        int n = nums.length;

        //Map will store the numbers as keys and their frequencies as value
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            int key = nums[i];
            int freq = 0;

            if(map.containsKey(key)) freq = map.get(key);

            //Overriding the frequecy every time if we found we increment and if not that's first time so 0 to 1
            freq++;
            map.put(key, freq);
        }

        //Iterate over map
        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            System.out.println(e.getKey()+" --> "+e.getValue());
        }

        if(map.containsKey(1)) System.out.println(map.get(1));
    }
}
