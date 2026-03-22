//package CodeForces.SegmentTrees.E_enemy_is_weak;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long [] seg;
    static long [] arr;

    public static long query(int idx,int l,int r,long ql,long qr){
        if(r < ql || l > qr)return 0;
        if(ql<= l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx,l,mid,ql,qr) + query(2*idx+1, mid + 1, r, ql, qr);
    }

    public static void  update_St(int idx,int l,int r,long pos){
        if(l == r){
            seg[idx] += 1;
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
        seg = new long [4*n + 5];

        for(int i = 0;i<n;i++){
            arr[i] = sc.nextLong();
        }

        long [] leftGreater = new long [n];
        long [] rightSmall = new long [n];

        long [] temp = arr.clone();
        Arrays.sort(temp);

       long [] comp = new long [n+1];
       for(int i = 0;i<n;i++){
        comp[i] = Arrays.binarySearch(temp, arr[i]) + 1;//make 1 based indexed
       }

       //computing for left first 
       for(int i =0;i<n;i++){
          long val = comp[i];

          if(val < n){
            leftGreater[i] = query(1,1,n,val + 1,n);
          }

          update_St(1,1,n,val);
       }

       //Reset the segment Tree now
       seg = new long [4*n+5];

       for(int i = n-1;i>=0;i--){
          long val = comp[i];
          
          if(val > 1){
            rightSmall[i] = query(1, 1, n, 1, val - 1);
          }

          update_St(1, 1, n, val);

       }

       //finally compute all the possible pairs values
       long weakness = 0;

       for(int i = 0;i<n;i++){
           weakness += (rightSmall[i] * leftGreater[i]);
       }

       System.out.println(weakness);

       sc.close();
    }
}
