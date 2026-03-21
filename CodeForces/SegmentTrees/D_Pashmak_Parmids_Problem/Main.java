//package CodeForces.SegmentTrees.D_Pashmak_Parmids_Problem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static long [] seg;
    static long [] arr;

    public static long query(int idx,int l,int r,int ql,int qr){
        if(r < ql || l > qr)return 0;
        if(ql<=l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx, l, mid, ql, qr) + query(2*idx+1, mid + 1, r, ql, qr);
    }

    public static void update_St(int idx,int l,int r,int pos){
        if(l == r){
            seg[idx]++;
            return;
        }

        int mid = l+(r-l)/2;
        if(pos<= mid)update_St(2*idx, l, mid, pos);
        else update_St(2*idx+1, mid + 1, r, pos);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new long [n];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextInt();
        }

        seg = new long[4*n+5];

        long [] b = arr.clone();
        Arrays.sort(b);

        HashMap<Long,Integer> map = new HashMap<>();
        int id = 1;

        for(long x: b){
            if(!map.containsKey(x))map.put(x, id++);
        }

        for(int i = 0;i<n;i++){
           arr[i] = map.get(arr[i]);
        }

        int [] freq = new int [n + 1];
        int [] leftFreq = new int [n];

        for(int i = 0;i<n;i++){
            freq[(int) arr[i]]++;
            leftFreq[i] = freq[(int) arr[i]];
        }

        int [] rightFreq = new int [n];
        Arrays.fill(freq,0);
        
        for(int i = n-1;i>=0;i--){
            freq[(int) arr[i]]++;
            rightFreq[i] = freq[(int) arr[i]];
        }

        long ans = 0;

        for(int i = n-1;i>=0;i--){
           if(leftFreq[i] > 1){
            ans += query(1,1,n,1,leftFreq[i]-1);
           }

           update_St(1,1,n,rightFreq[i]);
        }

        System.out.println(ans);
        sc.close();
    }
}
