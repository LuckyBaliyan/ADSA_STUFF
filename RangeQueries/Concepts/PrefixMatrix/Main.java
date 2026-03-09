package RangeQueries.Concepts.PrefixMatrix;

public class Main {
    public static void main(String[] args) {
        int [][] matrix = {
            {1,3,4},
            {2,3,4},
            {2,5,1}
        };

        int [][] preCompute = new int[matrix.length + 1][matrix[0].length + 1];

        //Filling via dp style optimally  O(N*M)
        for(int i = 1;i<=matrix.length;i++){
            for(int j = 1;j<=matrix[0].length;j++){
               preCompute[i][j] = 
               matrix[i - 1][j - 1] + preCompute[i-1][j] + preCompute[i][j-1] - 
               preCompute[i-1][j-1];
                  
            }
        }

        for(int [] arr:preCompute){
            for(int a:arr){
                System.out.print(a+" ");
            }
            System.out.println();
        }
    }
}
