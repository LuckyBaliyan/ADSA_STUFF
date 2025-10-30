package leetcode.Arrays2.LeetCode_48;

/**
 *  rotate a matrix in clockwise to 90 deg in place
 * */

public class Solutio {
    static int [][] rotate90deg(int [][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        //We are just making a new matrix pf same size
        int [][] matrix2 = new int[m][n];

        //Key formula [i][j] = [j][n-1-i] // (row,col) --> (col,size-1-row)
        for(int i = 0;i<m;i++){
            for(int j= 0;j<n;j++){
                matrix2[j][n - 1 - i] = matrix[i][j];
            }
        }

        return matrix2;
    }

    static void rotate90degOptimal(int [][] matrix){
        int m = matrix.length;
        int n = matrix[0].length;

        //Finding the transpose of the matrix O(N/2*N/2)

        for(int i = 0;i<m;i++){
            for(int j = i+1;j<n;j++){
              transpose(matrix, i, j);
            }
        }

        //Reverse each row O(N*N/2)

        for(int i = 0;i<m;i++){
            reverse(matrix,i,n);
        }
    }

    static void reverse(int [][] arr,int i,int n){
        int j = 0;
        int k =n-1;

        while(j<k){
            int temp = arr[i][j];
            arr[i][j] = arr[i][k];
            arr[i][k] = temp;
            j++;
            k--;
        }
    }

    static void transpose(int[][] arr,int a,int b){
        int temp = arr[a][b];
        arr[a][b] = arr[b][a];
        arr[b][a] = temp;
    }

    public static void main(String[] args) {
        int [][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] res = rotate90deg(matrix);

        for(int i =0;i<res.length;i++){
            for(int j =0;j<res[0].length;j++){
                System.out.print(res[i][j]+" ");
            }

            System.out.println();
        }

        System.out.println();

        rotate90degOptimal(matrix);

         for(int i =0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                System.out.print(matrix[i][j]+" ");
            }

            System.out.println();
        }
        
    }
}
