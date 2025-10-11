package leetcode.HashingBasic.MapsHashing;

import java.util.HashMap;
import java.util.Map;

public class Strings {
    public static void main(String[] args) {
        String s = "qaaqdjwkhwqh";
        int n = s.length();

        HashMap<Character,Integer> mp = new HashMap<>();

        for(int i = 0;i<n;i++){
            char key = s.charAt(i);
            int freq = 0;

            if(mp.containsKey(key)) freq = mp.get(key);

            freq++;
            mp.put(key,freq);
        }

        for(Map.Entry<Character,Integer> e: mp.entrySet()){
            System.out.println(e.getKey()+" --> "+e.getValue());
        }

        if(mp.containsKey('a')) System.out.println(mp.get('a'));
    }
}
