package classRoom.Graphs.Representation.adjList;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Number Of Vertices:");
        int V = sc.nextInt();
        System.out.println("Enter Number Of Edges:");
        int E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<E;i++){
            System.out.println("Enter the Edge i.e Pairs Of Vertices Connecting An Edge:");
            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0;i<=V;i++){
            System.out.print(i+"-->");
            for(int node: adj.get(i))System.out.print(node+" ");

            System.out.println();
        }

        sc.close();
    }
}
