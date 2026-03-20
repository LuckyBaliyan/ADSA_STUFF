

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;
    static long [] seg;
    static long M = 1000000007;

    public static void update_St(int idx,long l,long r,int pos,long res){
        if(l==r){
            seg[idx] = (seg[idx] + res) % M;
            return;
        }

        long mid = l+(r-l)/2;
        if(pos <= mid)update_St(2*idx + 1, l, mid, pos, res);
        else update_St(2*idx+2, mid + 1, r, pos, res);

        seg[idx] = (seg[2*idx+1] + seg[2*idx+2]) % M;

    }

    public static long query(int idx,long l,long r,long ql,long qr){
        if(r<ql || l >qr)return 0;
        if(ql<= l && r <= qr)return seg[idx];

        long mid = l+(r-l)/2;
        return (query(2*idx + 1, l, mid, ql, qr) + query(2*idx+2, mid +1 , r, ql, qr)) % M;
    }

    public static int getIdx(long x, ArrayList<Long> cord){
        int l = 0;
        int r = cord.size()-1;

        while(l<=r){
            int mid = l+(r-l)/2;

            if(cord.get(mid) == x)return mid;
            else if(cord.get(mid) > x)r = mid -1;
            else l = mid + 1;
        }

        return -1;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        arr = new long[n];
        long max = Long.MIN_VALUE;

        for(int i = 0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
            max = Math.max(max,arr[i]);
        }
        
        //seg = new long[(int)  max];
        ArrayList<Long> cord = new ArrayList<>();
        long [] temp = arr.clone();

        Arrays.sort(temp);

        cord.add(temp[0]);

        for(int i = 1;i<n;i++){
            //remove duplicates
            if(temp[i-1] != temp[i]){
                cord.add(temp[i]);
            }
        }

        int m = cord.size();
        seg = new long [4*m];

        for(int i = 0;i<n;i++){
            int idx = getIdx(arr[i], cord);
            long res = (idx > 0 ?query(0,0,m-1,0,idx-1):0);
            res = (res + 1)%M;
            
            update_St(0,0,m-1,idx,res);
        }


        System.out.println(seg[0]);
    }
}
