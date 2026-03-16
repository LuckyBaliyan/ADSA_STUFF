package CodeForces.SegmentTrees.C_Nested_Segments;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static long [] seg;
    static long [] arr;
    static long [] firstAcc;
    static long [] ans;

    static class Interval{
        long l,r,id;

        Interval(long l,long r,long id){
           this.l = l;
           this.r = r;
           this.id = id;
        }
    }

    public static void update_St(int idx,int l,int r,long pos){
        if(l==r){
            seg[idx] = 1;
            return;
        }

        int mid = l+(r-l)/2;
        if(pos <= mid)update_St(2*idx, l, mid, pos);
        else update_St(2*idx+1, mid+1, r, pos);

        seg[idx] = seg[2*idx] + seg[2*idx+1];
    };

    public static long query(int idx,int l,int r,long ql,long r2){
        if(r<ql || l >r2)return 0;
        if(ql<=l && r <= r2)return seg[idx];

        int mid = l+(r-l)/2;
        return query(2*idx, l, mid, ql, r2) + query(2*idx+1, mid + 1, r, ql, r2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = 2*n;


        arr = new long[m+1];
        firstAcc = new long [n+1];
        seg = new long[4*(m+5)];
        ans = new long[n+1];

        for(int i = 1;i<=m;i++)arr[i] = sc.nextLong();

        Interval [] intervals = new Interval[n];

        for(int i = 1;i<=m;i++){
            long x = arr[i];

            if(firstAcc[(int) x] == 0){
                firstAcc[(int) x] = i;
            }
            else{   
               intervals[(int) (x-1)] = new Interval(firstAcc[(int) x], i, x);
            }
        }

        //sort based on ending index of a segment i.e r in asc
        Arrays.sort(intervals,(a,b)->Long.compare(a.r, b.r));

        for(Interval in:intervals){
            ans[(int) in.id] = query(1, 1, m, in.l, in.r);

            update_St(1, 1, m, in.l);
        }

        for(int i = 1;i<=n;i++){
            System.out.print(ans[i]+" ");
        }

        sc.close();
    }
}
