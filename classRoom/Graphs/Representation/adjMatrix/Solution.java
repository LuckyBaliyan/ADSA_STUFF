package classRoom.Graphs.Representation.adjMatrix;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Number Of vertices:");
        int n = sc.nextInt();

        System.out.println("Enter The Number Of Edges give n+1:");
        int m = sc.nextInt();

        int [][] graph = new int [n+1][n+1];

        for(int i = 0;i<m;i++){
            System.out.println("Enter A piar of Connecting Vertices:");
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        System.out.println("The Required Graph is:");

        for(int i = 0;i<=n;i++){
           for(int j = 0;j<=n;j++){
            System.out.print(graph[i][j]+" ");
           }
           System.out.println();
        }

        sc.close();
    }
}
