package RangeQueries.Concepts.SegmentTree;

public class Main {
    static long [] seg;
    static long [] arr = {10,20,30,40,50,60};
    public static void build_st(int indx,int l,int r){
        //base case;
        if(l == r){
            seg[indx] = arr[l];
            return;
        }

        int mid = l + (r - l)/2;

        //left side
        build_st(2*indx+1, l, mid);
        //right side
        build_st(2*indx+2, mid+1, r);

        seg[indx] = seg[2*indx+1] + seg[2*indx+2];
    }

    public static long sumQuery(int ql,int qr,int idx,int l,int r){
        //if query range  completely outside the given range
        if(r < ql || l > qr)return 0;

        //if completely inside in the queryRange
        if(l >= ql && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;
        long left = sumQuery(ql, qr, 2*idx+1, l, mid);
        long right = sumQuery(ql, qr, 2*idx+2, mid+1, r);

        return left + right;
    }
    public static void main(String[] args) {
        int n = 6;
        /*
        4n is always an upperBound for all sizes so we just use it to work for every 
        given i/p
        */
        seg = new long [4*n];

        build_st(0, 0, n-1);

        for(long s:seg)System.out.print(s+" ");

        System.out.println();

        //passing a range sume query
        long res = sumQuery(2, 4, 0, 0, n-1);
        System.out.println(res);
    }
}
