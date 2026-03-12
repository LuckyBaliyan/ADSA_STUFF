package CodeForces.SegmentTrees.D_DistinctCharacter_Queries;

import java.util.Scanner;

public class Main {
    static String s;
    static long [] seg;

    public static void build_st(int idx,int l,int r){
        if(l==r){
            seg[idx] = 1 << s.charAt(l) - 'a'; 
            //left shift the char to the no of bits according to its postion in a-z
            return;
        }

        int mid = l+(r-l)/2;
        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        //check wheather 2 different chars are having same bits or diff 
        seg[idx] = seg[2*idx+1] | seg[2*idx+2];
    }

    public static void update(int qi,char ch,int idx,int l,int r){
        if(l == r){
            seg[idx] = 1 << ch - 'a';
            return;
        }

        int  mid = l+(r-l)/2;
        if(qi<=mid)update(qi, ch, 2*idx+1, l, mid);
        else update(qi, ch, 2*idx+2, mid+1, r);

        seg[idx] = seg[2*idx+1] | seg[2*idx+2];
    }

    public static long query(int ql,int qr,int idx,int l,int r){
        if(r < ql || l > qr)return 0;
        if(ql<= l && r <= qr)return seg[idx];

        int mid = l+(r-l)/2;

        long left  = query(ql, qr, 2*idx+1, l, mid);
        long right = query(ql, qr, 2*idx+2, mid+1, r);

        return left | right;
    }
    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);

        s = sc.nextLine();
        int q = sc.nextInt();

        int n = s.length();
        seg = new long[4*n];

        build_st(0, 0, n-1);

        StringBuilder sb = new StringBuilder();

        while(q--> 0){

        int type = sc.nextInt();

        if(type == 1){

        int qi = sc.nextInt();
        char ch = sc.next().charAt(0);

        update(qi-1, ch, 0, 0, n-1);

        }
        else{

            int l = sc.nextInt();
            int r = sc.nextInt();
    
            long mask = query(l-1, r-1, 0, 0, n-1);
            sb.append(Long.bitCount(mask)+"\n");
        }
    }
        
        System.out.println(sb.toString().trim());
        sc.close();
    }
}
