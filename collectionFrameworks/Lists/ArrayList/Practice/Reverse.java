package collectionFrameworks.Lists.ArrayList.Practice;

import java.util.ArrayList;
import java.util.Arrays;

/* Reverse an arrayList */

public class Reverse {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1,2,35,12,4,895,53,6));
   
        int left= 0;
        int right = list.size()-1;

        while(left<right){

          int temp = list.get(left);
          list.set(left,list.get(right));
          list.set(right,temp);

          left++;
          right--;
        }

        System.out.println(list);

    }
}
