package gfg.Stacks.Sort_a_Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Solution {
     public static void sortStack(Stack<Integer> st) {
        // code here
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(!st.isEmpty()){
            temp.add(st.pop());
        }
        
        Collections.sort(temp); // O(nlogn)
       
        for(int i = 0;i<temp.size();i++){
            st.push(temp.get(i));
        }
    }

    public static void mergedSortStack(Stack<Integer> st){
        int h = st.size();
        mergeSort(st,0,h);

    }

    public static void mergeSort(Stack<Integer> st,int l,int h){
        if(l>=h) return;
        int mid = l+((h-l)/2);
        mergeSort(st, l, mid);
        mergeSort(st, mid+1, h);
        merge(st,l,mid,h);
    }

    static void merge(Stack<Integer> st,int l,int mid,int h){
      ArrayList<Integer> temp = new ArrayList<>();
      
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for(int i =5;i>0;i--)st.push(i);

        System.out.println(st);

        sortStack(st);

        System.out.println(st);
    }
}
