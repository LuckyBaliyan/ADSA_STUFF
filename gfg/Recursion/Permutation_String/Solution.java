package gfg.Recursion.Permutation_String;

import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    public static ArrayList<String> findPermutation(String s) {
        HashSet<String> st = new HashSet<>();
        solve(s,"",st);
        return new ArrayList<>(st);
    }
    
    public static void solve(String s,String curr,HashSet<String> st){
        if(s.length() == 0){
            st.add(curr);
            return;
        }
        
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            String rem = s.substring(0,i)+s.substring(i+1);
            //Carefully check the String extraction Methods 
            
            solve(rem,curr + ch,st);
        }
    }

    public static void main(String[] args) {
        System.out.println(findPermutation("ABC"));
    }
}
