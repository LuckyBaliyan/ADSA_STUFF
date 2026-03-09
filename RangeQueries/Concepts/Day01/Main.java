package RangeQueries.Concepts.Day01;

public class Main {
    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};

        int [] prefixSum = new int [arr.length];
        prefixSum[0] = arr[0];

        for(int i = 1;i<arr.length;i++){
           prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for(int i:prefixSum)System.out.print(i+" ");

        System.out.println();

        int [][] Sumqueries = {{1,3},{0,1},{2,4},{1,4}};
        
        for(int [] q:Sumqueries){
            int l = q[0];
            int r = q[1];

            if(l==0)System.out.println(prefixSum[r]+" ");
            else
            System.out.println(prefixSum[r] - prefixSum[l-1]+" ");
        }
    }
}
