package leetcode.BasicMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllDivisors {
    public static List<Integer> allDivisors(int n){
        List<Integer> list  = new ArrayList<>();
        for(int i=1;i*i<=n;i++){
           if(n%i == 0){
              list.add(i);
              if((n/i)!=i){
                list.add(n/i);
              }
           }
        }

        Collections.sort(list);

        return list;
    }
    public static void main(String[] args) {
        List<Integer> newList = new ArrayList<>(allDivisors(36));
        System.out.println(newList);
    }
}
