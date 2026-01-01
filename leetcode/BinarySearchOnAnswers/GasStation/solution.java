package leetcode.BinarySearchOnAnswers.GasStation;

import java.util.PriorityQueue;

public class solution {
    //approach 1
    public static double minDis(int [] arr,int k){
        int n = arr.length;

        int [] howMany = new int [n-1];
        
        for(int gas = 1;gas<=k;gas++){
            double max = -1;
            int maxIn = -1;
            for(int i = 0;i<n-1;i++){
                double sectionLength = (double) (arr[i+1] - arr[i]) / (howMany[i]+1);

                if(max < sectionLength){
                    max = sectionLength;
                    maxIn = i;
                }
            }

            howMany[maxIn]++;
        }

        //finally return the max secLength
        double ans = -1;
        for(int i = 0;i<n-1;i++){
            double secLength = (double)  (arr[i+1] - arr[i])/(howMany[i]+1);
            ans = Math.max(ans, secLength);
        }

        return ans;
    }

    //Approach 2
    public static double minDis2(int [] arr,int k){
        int n = arr.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.val, a.val));

        int [] howMany = new int [n-1];

        for(int i = 0;i<n-1;i++){
            pq.offer(new Pair((arr[i+1] - arr[i]), i));
        }

        for(int gas = 1;gas <= k;gas++){
            Pair tp = pq.peek();
            pq.poll();

            int secInd = tp.idx;

            howMany[secInd]++;

            double secLength = (double) (arr[secInd+1] - arr[secInd]) / (howMany[secInd]+1);
            pq.offer(new Pair(secLength, secInd));
        }
        return pq.peek().val;
    }

    //Approach 3
    public static double minDis3(int [] arr,int k){
        int n = arr.length;
        double diff = 1e-6;

        double high = 0;
        for(int i = 1;i<n;i++){
           high = Math.max(high, (arr[i] - arr[i-1]));
        }

        double low = 0;

        while (high - low > diff) {
            double mid = (low + high)/2.0;
            int cnt = helper(arr,mid);
            if(cnt > k)low = mid;
            else high = mid;
        }

        return high;
    }

    public static int helper(int [] arr,double dis){
        int cnt = 0;
        for(int i = 1;i<arr.length;i++){
           int numbersBtween = (int) ((arr[i] - arr[i-1])/dis);
           if((arr[i] - arr[i-1]/dis) == (numbersBtween*dis)){
            numbersBtween--;
           }

           cnt += numbersBtween;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(minDis(new int [] {1,13,17,23}, 5));
        System.out.println(minDis(new int [] {1, 2, 3, 4, 5, 6 ,7, 8, 9, 10}, 10));

        System.out.println("Using Approach 2 priorityQueue: "+minDis2(new int [] {1,13,17,23}, 5));
        System.out.println("Using Approach 3 BinarySearch: "+minDis3(new int [] {1,13,17,23}, 5));
    }
}
