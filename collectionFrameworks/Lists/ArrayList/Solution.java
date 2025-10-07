package collectionFrameworks.Lists.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) {

        //Creating an Array List instance
        ArrayList<Integer> list  = new ArrayList<>();

        //using Another list this time with values field from scratch
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("apple","banana","Kiwi"));

        ArrayList<String> list3 = new ArrayList<>();

        String[] strings = {"A","B","C","D"};

        for (String string : strings) {
            list3.add(string);
        }

        //Using add functions 
        list.add(1);
        list.add(11);
        list.add(0);

        //This is calling the arrayList toString method by default arrays dont have any so we need to iterate there
        System.out.println(list);

        //using addAll
        //list.addAll(list2); we cant add the List of different dataTypes !important 
        list2.addAll(list3);

        System.out.println(list2);

        //Removing Values
        for(int i = 0;i<=20;i++){
            list.add(i);
        }

        list.add(2);

        System.out.println(list);

        list.remove(3);

        System.out.println(list);

        list.remove(Integer.valueOf(1)); //only removes the first founded value 

        System.out.println(list);

        //to remove all we can use removeAll

        list.removeAll(Arrays.asList(Integer.valueOf(2)));

        System.out.println(list);


        list2.remove("apple");

        System.out.println(list2);

        //Getter functions
        int result = list.get(1);
        System.out.println(result);

        //Updation or setters 

        list2.set(1,"apple");
        System.out.println(list2);  // we have apple instead of kiwi in that place 

        //boolean contains function and size function
        int size = list2.size() + list.size() + list3.size();
        boolean isContains = list.contains(111);

        System.out.println(size+" and "+isContains);

        //Sort functions 

        //Acending/decending

        Collections.sort(list); // inplace O(n log n)
        System.out.println(list); 

        //Comaring wise ex:- length and ASCII wise if strings

        list2.sort((a,b)-> a.length() - b.length());
        System.out.println(list2);

    }
}
