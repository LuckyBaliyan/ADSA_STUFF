package CodeForces.Graphs.Fox_Names;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static String getNames(int V,String [] names){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

 
        for (int i = 0; i < V - 1; i++) {

            String s1 = names[i];
            String s2 = names[i + 1];

            int len = Math.min(s1.length(), s2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if (c1 != c2) {

                    int u = c1 - 'a';
                    int v = c2 - 'a';

                    if (!adj.get(u).contains(v)) {
                        adj.get(u).add(v);
                    }

                    found = true;
                    break;
                }
            }

            if(!found && s1.length() > s2.length()){
                return "Impossible";
            }
        }

        int [] inDegree = new int [26];
        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < 26; i++){
           for(int ne : adj.get(i)){
              inDegree[ne]++;
           }
        }

        for(int i = 0;i<26;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        String str = bfs(adj,inDegree,q);
        return str.length() == 26?str:"Impossible";
    }

    public static String bfs(ArrayList<ArrayList<Integer>> adj,int [] inDegree,Queue<Integer> q){
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append((char) (curr + 'a'));
            
            for(int ne:adj.get(curr)){
                inDegree[ne]--;

                if(inDegree[ne] == 0)q.offer(ne);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String [] names = new String [n];

        for(int i = 0;i<n;i++){
           names[i] = sc.next();
        }

        System.out.println(getNames(n,names));
    }
}
