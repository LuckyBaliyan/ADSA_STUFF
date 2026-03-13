package CodeForces.SegmentTrees.C_Sreejla_And_Brackets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static String s;
    static Pair [] seg;

    static class  Pair {
    
        long open,close,valid;

        Pair(long open,long close,long valid){
            this.open = open;
            this.close = close;
            this.valid = valid;
        }
        
    }

    public static Pair merge(Pair p1,Pair p2){
        long cnt1open = p1.open;
        long cnt2closed  = p2.close;

        long cnt1valid = p1.valid;
        long cnt2valid = p2.valid;

        //logic will resolve around how to get maximum valid
        long match = Math.min(cnt1open , cnt2closed);
        long finalValid = cnt1valid + cnt2valid + match;

        long finalOpen  = p1.open + p2.open - match;
         //subtarct the consumed open or closed brackets in valid;
        long finalclose = p1.close + p2.close - match;

        return new Pair(finalOpen, finalclose, finalValid);

    }

    public static void build_st(int idx,int l,int r){
        if(l == r){
            if(s.charAt(l) == '(')seg[idx] = new Pair(1, 0, 0);
            else seg[idx] = new Pair(0, 1, 0);

            return;
        }

        int mid = l+(r-l)/2;
        build_st(2*idx+1, l, mid);
        build_st(2*idx+2, mid+1, r);

        //we always need this step when we are comming from child's to parent node 
        //in first deep call we process both left and right leaf in baseCase then when 
        //callStack unwiend then we set parent here
        seg[idx] = merge(seg[2*idx+1],seg[2*idx+2]);
    }

    public static Pair query(int ql,int qr,int idx,int l,int r){
        if(r<ql || l>qr)return new Pair(0, 0, 0);
        if(ql<=l && r <=qr)return seg[idx];

        int mid = l+(r-l)/2;
        Pair left = query(ql, qr, 2*idx+1, l, mid);
        Pair right = query(ql, qr, 2*idx+2, mid+1, r);

        return merge(left, right);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        int m = Integer.parseInt(br.readLine());

        int n = s.length();
        seg  = new Pair[4*n];

        build_st(0, 0, n-1);

        StringBuilder sb = new StringBuilder();

        while(m--> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            Pair res = query(l-1, r-1, 0, 0, n-1);
            sb.append((res.valid*2)+"\n"); //one valid pair length() := always 2 i.e ()
        }

        System.out.println(sb.toString().trim());
    }
}
