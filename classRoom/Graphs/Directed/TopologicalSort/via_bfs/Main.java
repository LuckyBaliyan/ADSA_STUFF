package classRoom.Graphs.Directed.TopologicalSort.via_bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<Integer> q = new LinkedList<>();
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {//media.geeksforgeeks.org/img-practice/prod/addEditProblem/700255/Web/Other/blobid0_1744196747.jpg
        // code here
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        //boolean [] visited = new boolean [V];
        int [] ind = new int [V];
        
        for(int i  = 0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int [] e:edges){
            adj.get(e[0]).add(e[1]);
        }
        
        for(int i = 0;i<V;i++){
           for(int ne:adj.get(i)){
               ind[ne]++;
           }
        }
        
        for(int i = 0;i<V;i++){
            if(ind[i] == 0)q.offer(i);
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        BFS(adj,ind,ans);
        return ans;
    }
    
    public static void BFS(ArrayList<ArrayList<Integer>> adj,int [] ind,
    ArrayList<Integer> res){
        while(!q.isEmpty()){
            int s = q.poll();
            res.add(s);
            
            for(int ne:adj.get(s)){
                ind[ne]--;
                
                if(ind[ne] == 0)q.offer(ne);
            }
        }
        
    }

    public static void main(String[] args) {
        ArrayList<Integer> res = new ArrayList<>();

        res = topoSort(6,new int [][] {{1,3},{2,3},{4,1},{4,0},{5,0},{5,2}});
        System.err.println(res);
    }
}
