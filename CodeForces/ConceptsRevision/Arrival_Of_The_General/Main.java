package CodeForces.ConceptsRevision.Arrival_Of_The_General;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] soilders = new int [n];

        for(int i = 0;i<n;i++)soilders[i] = sc.nextInt();

        //im thinking instead of swapping calculating the distance of maxElem from 0
        // and min elem from n-1

        int maxElem = Integer.MIN_VALUE;
        int maxIdx = -1;

        int minElem = Integer.MAX_VALUE;
        int minIdx = -1;

        for(int i = 0;i<n;i++){
            if(maxElem < soilders[i]){
               maxElem = soilders[i];
               maxIdx = i;
            }
        }

        for(int i = 0;i<n;i++){
            if(soilders[i] <= minElem){
                minElem = soilders[i];
                minIdx = i;
            }
        }

        int time = (maxIdx - 0) + (n - 1 - minIdx);

        //if we found minelem early then it will cost an extra left shift to maxElem 
        if(maxIdx > minIdx)time--;

        System.out.println(time);
        
        sc.close();
    }
}
