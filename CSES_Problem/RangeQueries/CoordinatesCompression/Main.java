package CSES_Problem.RangeQueries.CoordinatesCompression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void compress(long [] arr, ArrayList<Long> cords){
        long [] temp = arr.clone();

        Arrays.sort(temp);

        cords.add(temp[0]);

        for(int i = 1;i<arr.length;i++){
            if(temp[i-1] != temp[i])cords.add(temp[i]);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long [] arr = new long [n];
        
        for(int i = 0;i<n;i++)arr[i] = sc.nextInt();

        ArrayList<Long> cords = new ArrayList<>();

        compress(arr,cords);

        for(long i:cords)System.out.print(i+" ");

        sc.close();
    }
}
