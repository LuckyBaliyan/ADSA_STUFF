package infosys_HackwithInfy.Graphs.General_Ali_Army;

import java.util.*;

public class q5{

   static int [] dr = {-1,1,0,0};
   static int [] dc = {0,0,-1,1};
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int m = sc.nextInt();
      
      char[][] grid = new char[n][m];
      Queue<int []> q = new LinkedList<>();
      int enemy = 0;

      for(int i = 0;i<n;i++){
        String Q = sc.next();
        for(int j = 0;j<m;j++){
           char e = Q.charAt(j);
           if(e == 'E')enemy++;
           if(e == 'A'){
             q.offer(new int [] {i,j,0});
           }
           grid[i][j] = e;
        }
      }
      
      int maxtime = 0;

     System.out.println(bfs(q,grid,enemy,maxtime,n,m));
  }

  public static int bfs(Queue<int []> q,char [][] grid,
  int enemy,int maxTime,int n,int m){

     while(!q.isEmpty()){
       int [] curr = q.poll();
       int r = curr[0];
       int c = curr[1];
       int time = curr[2];
       
       maxTime = Math.max(maxTime,time);
       
       for(int i = 0;i<4;i++){
         int nr = r + dr[i];
         int nc = c + dc[i];
         
         if(nr >=0 && nr < n && nc >=0 && nc < m  && grid[nr][nc] == 'E'){
            grid[nr][nc] = 'A';
            enemy--;
            
            q.offer(new int [] {nr,nc,time + 1});
         }
       }
     }

    return (enemy != 0)? -1:maxTime;
  }
}
