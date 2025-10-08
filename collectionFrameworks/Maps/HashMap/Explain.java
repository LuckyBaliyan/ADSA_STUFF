package collectionFrameworks.Maps.HashMap;

import java.util.HashMap;
import java.util.Map;

public class Explain {
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();

        map.put("one", 1);
        map.put("two",2);
        map.put("three",3);

        System.out.println(map.containsKey("one")+"\n"+map.containsValue(1));

        System.out.println(map.getOrDefault("five", 0)+1);

        for(Map.Entry<String,Integer> e: map.entrySet()){
            System.out.println(e);

            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        map.putIfAbsent("three", 3);
        map.remove("one");
        System.out.println(map);
        map.putIfAbsent("one", 1);
        System.out.println(map);
    }
}
