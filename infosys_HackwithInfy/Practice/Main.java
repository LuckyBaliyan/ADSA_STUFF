package infosys_HackwithInfy.Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class Main {
    static class Food {
        long currentV;
        long d;

        Food(long v, long d){
            this.currentV = v;
            this.d = d;
        }
        
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String firstLine = br.readLine();
        int n = Integer.parseInt(firstLine.trim());

        String SecLine = br.readLine();
        long m = Long.parseLong(SecLine.trim());

        long [] v = new long[n];
        for(int  i = 0;i<n;i++){
            v[i] = Long.parseLong(br.readLine());
        }

        long [] d = new long[n];
        for(int i = 0;i<n;i++){
            d[i] = Long.parseLong(br.readLine().trim());
        }

        PriorityQueue<Food> pq = new PriorityQueue<>((a,b)-> Long.compare(b.currentV, a.currentV));

        for(int i = 0;i<n;i++){
           if(v[i] > 0 )pq.offer(new Food(v[i], d[i]));
        }

        long totalTastePoints = 0;
        long mealsLeft = m;

        while(mealsLeft > 0 && !pq.isEmpty()){
            Food best = pq.poll();
            long nextV = pq.isEmpty() ? 0 : pq.peek().currentV;

            long canEat;

            if(best.d == 0){
                canEat = mealsLeft;
            }
            else{
                canEat = (best.currentV - nextV) / best.d  + 1;
            }

            long take = Math.min(canEat, mealsLeft);

            if(best.d > 0){
                long maxPos = (best.currentV - 1)/best.d + 1;
                take = Math.min(take,maxPos);
            }

            if(take <= 0)continue;

            long lastV = best.currentV - (take - 1) * best.d;
            totalTastePoints += (take*(best.currentV + lastV)) / 2;

            mealsLeft -= take;
            best.currentV = lastV - best.d;

            if(best.currentV  > 0 && mealsLeft > 0)pq.add(best);
        }

        System.out.println(totalTastePoints);
    }
}
