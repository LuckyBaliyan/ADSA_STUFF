//package CodeForces.ConceptsRevision;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [][] beauty = new int [5][5];

        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                beauty[i][j] = sc.nextInt();
            }
        }

        //finding the initial position of 1
        int posi = 0;
        int posj = 0;

        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(beauty[i][j] == 1){
                    posi = i;
                    posj = j;
                    break;
                }
            }
        }

        int opr =  Math.abs(2 - posi) + Math.abs(2 - posj);
        System.out.println(opr);

        sc.close();
    }
}
