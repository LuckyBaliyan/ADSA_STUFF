package CodeForces.Implementation.FOX_AND_SNAKE;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int n = sc.nextInt();
        int m = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        boolean right = true;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(i%2 == 0){
                    sb.append('#');
                }
                else{
                    if(right){
                        if(j<m-1){
                            sb.append('.');
                        }
                        if(j == m-1){
                            sb.append('#');
                        }
                    }
                    else{
                        if(j  == 0){
                           sb.append('#');
                        }
                        if(j>0 && j < m){
                            sb.append('.');
                        }
                    }
                }
            }

            if(i % 2 != 0){
                right = !right;
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());

        sc.close();
    }
}
