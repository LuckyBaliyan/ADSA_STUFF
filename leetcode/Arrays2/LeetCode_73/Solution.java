package leetcode.Arrays2.LeetCode_73;

public class Solution {
  static void maxZeros(int [][] matrix){
    int m = matrix.length;
    int n = matrix[0].length;

    int [] rows = new int [m];
    int [] cols = new int [n];

    for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(matrix[i][j] == 0 ){
                rows[i] = -1;
                cols[j] = -1;
            }
        }
    }

    //Now we have the scan completes and values to cahnge in specific index inlace of 0 in rows and cols array
    for(int i = 0;i<m;i++){
        for(int j = 0;j<n;j++){
            if(rows[i] == -1 || cols[j] == -1){
                matrix[i][j] = 0;
            }
        }
    }

  }

  public static void main(String[] args) {
    int [][] matrix = {{1,1,1},{1,0,1},{1,1,1}};


    System.out.println("Before:-");

     for(int i = 0;i<matrix.length;i++){
        for(int j = 0;j<matrix[0].length;j++){
            System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }

    maxZeros(matrix);

    System.out.println("After:-");

    for(int i = 0;i<matrix.length;i++){
        for(int j = 0;j<matrix[0].length;j++){
            System.out.print(matrix[i][j]+" ");
        }
        System.out.println();
    }
  }
}
