package ClassTests.Recursion_BackTracking.q2;

import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> generateValidSequences(int n){
        ArrayList<String> res = new ArrayList<>();
        if(n==1){
            res.add("L");
            res.add("H");
            return res;
        }

        solve(0,"", n, res);
        return res;
    
    }

    public static void solve(int i,String curr,int n,ArrayList<String> res){
        if(i == n){
            res.add(curr);
            return;
        }

        if(curr.length() > 0 && curr.charAt(curr.length()-1) == 'L'){
            solve(i+1, curr+"H", n, res);
        }
        else{
        solve(i+1,curr+"L",n,res);
        solve(i+1, curr+"H", n, res);
        }

    }
    public static void main(String[] args) {
        System.out.println(generateValidSequences(3));
    }
}
