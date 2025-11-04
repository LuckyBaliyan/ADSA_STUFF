package leetcode.Arrays2.Leetcode_118;

import java.util.ArrayList;

/**
 * 
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:

Example 1:

Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:

Input: numRows = 1
Output: [[1]]
 

Constraints:

1 <= numRows <= 30
 */

public class Solution {
    public static int nCr(int n,int k){
        int res = 1;
        for(int  i = 0;i<k;i++){
            res *= (n-i);
            res = res/(i+1);
        }

        return res;
    }
    public static ArrayList<ArrayList<Integer>> pascleTriangle(int rowCounts){
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for(int n = 0;n<rowCounts;n++){
            ArrayList<Integer> list = new ArrayList<>();
            for(int k =0;k<= n;k++){
              list.add(nCr(n,k));
            }

            res.add(list);
        }

        return res;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = pascleTriangle(5);

        System.out.println(res);
    }
}
