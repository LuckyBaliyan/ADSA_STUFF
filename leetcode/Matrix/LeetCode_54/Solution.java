package leetcode.Matrix.LeetCode_54;

import java.util.ArrayList;

/**
 * Spiral Matrix
 */

public class Solution {
    static ArrayList<Integer> SpiralMatrix(int [][] matrix){
        int n = matrix[0].length;
        int m = matrix.length;

        ArrayList<Integer> list  = new ArrayList<>();

        int top = 0;
        int left = 0;
        int right = n-1;
        int bottom = m-1;

        int totalElems = m*n;

        while(totalElems > 0){
            for(int i =left;i<=right;i++){
                list.add(matrix[top][i]);
                totalElems--;
            }

            top++;

            for(int i = top;i<=bottom;i++){
                list.add(matrix[i][right]);
                totalElems--;
            }

            right--;

            if(top <= bottom){
                for(int i = right;i>=left;i--){
                    list.add(matrix[bottom][i]);
                    totalElems--;
                }

                bottom--;
            }

            if(left<=right){
                for(int i =bottom;i>=top;i--){
                    list.add(matrix[i][left]);
                    totalElems--;
                }

                left++;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        ArrayList<Integer> res = SpiralMatrix(matrix);

        System.out.println(res);
    }
}
