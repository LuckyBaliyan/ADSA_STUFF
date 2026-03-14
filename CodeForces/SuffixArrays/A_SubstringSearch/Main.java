package CodeForces.SuffixArrays.A_SubstringSearch;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static String s;
    static int [] p;

    static void buildSuffixArray(){

        int n = s.length();

        p = new int[n];
        int[] c = new int[n];

        Integer[] order = new Integer[n];
        for(int i=0;i<n;i++) order[i] = i;

        Arrays.sort(order,(a,b)->Character.compare(s.charAt(a),s.charAt(b)));

        for(int i=0;i<n;i++) p[i] = order[i];

        c[p[0]] = 0;

        for(int i=1;i<n;i++){
            if(s.charAt(p[i]) == s.charAt(p[i-1]))
                c[p[i]] = c[p[i-1]];
            else
                c[p[i]] = c[p[i-1]] + 1;
        }

        int k = 0;

        while((1<<k) < n){

            for(int i=0;i<n;i++)
                p[i] = (p[i] - (1<<k) + n) % n;

            countSort(p,c);

            int[] c_new = new int[n];
            c_new[p[0]] = 0;

            for(int i=1;i<n;i++){

                int prev1 = c[p[i-1]];
                int prev2 = c[(p[i-1] + (1<<k)) % n];

                int now1 = c[p[i]];
                int now2 = c[(p[i] + (1<<k)) % n];

                if(prev1 == now1 && prev2 == now2)
                    c_new[p[i]] = c_new[p[i-1]];
                else
                    c_new[p[i]] = c_new[p[i-1]] + 1;
            }

            c = c_new;
            k++;
        }
    }

    static void countSort(int[] p,int[] c){

        int n = p.length;

        int[] cnt = new int[n];
        for(int x:c) cnt[x]++;

        int[] pos = new int[n];
        for(int i=1;i<n;i++)
            pos[i] = pos[i-1] + cnt[i-1];

        int[] p_new = new int[n];

        for(int x:p){
            int i = c[x];
            p_new[pos[i]++] = x;
        }

        System.arraycopy(p_new,0,p,0,n);
    }

    static boolean exsist(String pattern){
        int r = p.length-1;
        int l = 0;

        while(l<=r){
            int mid = l+(r-l)/2;

            int start = p[mid];

            int comp = compare(pattern,start); // start is the starting idx of suffix string

            if(comp == 0)return true;
            else if(comp < 0)r = mid-1;
            else l = mid+1;
        }

        return false;
    }

    public static int compare(String pat,int start){
        int i = 0;
        int n = s.length();

        while(i < pat.length() && start + i < n){
           char a = pat.charAt(i);
           char b = s.charAt(start + i);

           if(a != b)return a - b;
           i++;
        }

        if(i == pat.length())return 0;
        return 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        s = sc.nextLine();
        s += '$';

        buildSuffixArray();

        int q = sc.nextInt();
        sc.nextLine();

        StringBuilder sb = new StringBuilder();

        while(q-->0){
            String t = sc.nextLine();

            if(exsist(t))sb.append("Yes"+"\n");
            else sb.append("No"+"\n");
        }

        System.out.println(sb.toString().trim());
        sc.close();
    }
}
