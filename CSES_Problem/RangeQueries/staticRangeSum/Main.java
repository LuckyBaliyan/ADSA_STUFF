package CSES_Problem.RangeQueries.staticRangeSum;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long [] arr;
    static long [] prefix;

    public static long sumQuery(int ql,int qr){
        return prefix[qr] - prefix[ql-1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        arr = new long [n+1];

        st = new StringTokenizer(br.readLine());

        for(int i = 1;i<=n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        prefix = new long [n+1];
        prefix[1] = arr[1];

        for(int i = 2;i<=n;i++)prefix[i] = prefix[i-1] + arr[i];

        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<=q;i++){
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            sb.append(sumQuery(l,r)+"\n");
        }

        System.out.println(sb.toString().trim()); //to avoid last \n
    }
}
