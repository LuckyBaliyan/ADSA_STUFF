package CodeForces.Graphs.Ice_Skating;

import java.util.Scanner;

public class Main {
    static int [] x,y;
    static boolean [] visited;

    public static void dfs(int i,int n){
        visited[i] = true;

        for(int j = 0;j<n;j++){
           if(j == i)continue; // avoid checking same point to itself

           if(!visited[j] && (x[i] == x[j] || y[i] == y[j])){
             dfs(j,n);
           }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // No of snow drifts given 

        // if there are 2 drifts n == 2 given so there must 2 xi and yi's to 
        // represent its coordinates

        x = new int [n];
        y = new int [n];

        visited = new boolean[n];

        for(int i = 0;i<n;i++){
           x[i] = sc.nextInt();
           y[i] = sc.nextInt();
        }

        int drifts = 0;

        for(int i =0;i<n;i++){
            if(!visited[i]){
                dfs(i,n);
                drifts++;
            }
        }

        System.out.println(drifts - 1);

    }
}
