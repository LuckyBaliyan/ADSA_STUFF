package CSES_Problem.dP_on_graphs.Dijkastra.Swim_in_Rising_water;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1}; 
    static class Pair{
        int cost;
        int r;
        int c;

        Pair(int cost,int r,int c){
            this.cost = cost;
            this.r = r;
            this.c = c;
        }
    }
    public static  int[][] swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<Pair> pq = 
        new PriorityQueue<>((a,b)->Integer.compare(a.cost,b.cost));

        int [][] time = new int [n][n];
        for(int [] arr:time)Arrays.fill(arr,Integer.MAX_VALUE);

       // not necessarly to start with zero time[0][0] = grid[0][0];
       time[0][0] = grid[0][0];
        pq.offer(new Pair(grid[0][0],0,0));

        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int cost = p.cost;
            int r = p.r;
            int c = p.c;

            if(cost > time[r][c])continue;
            //if(r == n-1 && c == m-1)break;

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nr >= n || nc < 0 || nc >= m)continue;
                int newCost = Math.max(cost, grid[nr][nc]);
                
                if(newCost < time[nr][nc]){
                    pq.offer(new Pair(newCost,nr,nc));
                    time[nr][nc] = newCost;
                }
            }
        }
        
        return time;
    }

    public static void main(String[] args) {
        int [][] ans = swimInWater(new int [][] {{0,1,2,3,4},{24,23,22,21,5},
            {12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}});

        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<ans.length;j++){
                System.out.print(ans[i][j] < 10?"0"+ans[i][j]+" ":ans[i][j]+" ");
            }

            System.out.println();
        }

        System.out.println();

        System.out.println("ans: "+ans[ans.length-1][ans.length-1]);
    }
}