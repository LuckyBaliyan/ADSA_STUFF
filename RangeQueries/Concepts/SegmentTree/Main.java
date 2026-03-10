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
    public static void main(String[] args) {
        int n = 6;
        seg = new long [4*n];

        build_st(0, 0, n-1);

        for(long s:seg)System.out.print(s+" ");

    }
}
