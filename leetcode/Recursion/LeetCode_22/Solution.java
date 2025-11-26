package leetcode.Recursion.LeetCode_22;

import java.util.ArrayList;

/**
 * 22. Generate Parentheses
Solved
Medium
Topics
premium lock icon
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

1 <= n <= 8
 */

public class Solution {
    static ArrayList<String> generateParenthesis(int n){
        ArrayList<String> res = new ArrayList<>();
        solve(res,"",n,0,0);
        return res;
    }
    static void solve(ArrayList<String> list,String curr,int n, int open,int close){
        if(curr.length() == 2*n){
            list.add(curr);
            return;
        }

        if(open < n) solve(list, curr+"(", n, open+1, close);
        if(close < open) solve(list, curr+")", n, open, close+1);
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
