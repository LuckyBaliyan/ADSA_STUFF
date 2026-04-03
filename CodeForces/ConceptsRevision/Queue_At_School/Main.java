//package CodeForces.ConceptsRevision.Queue_At_School;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int t = sc.nextInt();

        String s = sc.next();
        char [] queue = new char[n];

        for(int i = 0;i<n;i++)queue[i] = s.charAt(i);

        for(int i = 1;i<=t;i++){
            int prev = 0;
            int next = 1;

            while (next < n) {
                if(queue[prev] == 'B' && queue[next] == 'G'){
                    char temp = queue[prev];
                    queue[prev] = queue[next];
                    queue[next] = temp;

                    prev+=2;
                    next+=2;
                }
                else{
                prev++;
                next++;
                }
            }
        }

        for(int i = 0;i<n;i++){
            System.out.print(queue[i]);
        }

        sc.close();
    }
}
