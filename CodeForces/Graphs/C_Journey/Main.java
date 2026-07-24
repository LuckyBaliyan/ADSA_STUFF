package CodeForces.Graphs.C_Journey;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
      static ArrayList<ArrayList<Integer>> adj;
      static double ans;

      public static void dfs(int node, int par, int depth, double prob) {
            int childrens = 0;

            // basically we are counting childrens correspond to each node for a level do
            // divide the
            // overall probablity to navigate to that children at that level
            // basically the question is saying that each edge has equal probablity to
            // navigate from one node to another

            for (int ne : adj.get(node)) {
                  if (ne != par) {
                        childrens++;
                  }
            }

            if (childrens == 0) {
                  ans += prob * depth;
                  return;
            }

            for (int ne : adj.get(node)) {
                  if (ne != par) {
                        dfs(ne, node, depth + 1, prob / childrens);
                  }
            }
      }

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();

            adj = new ArrayList<>();

            for (int i = 0; i <= n; i++)
                  adj.add(new ArrayList<>());

            for (int i = 0; i < n - 1; i++) {
                  int u = sc.nextInt();
                  int v = sc.nextInt();

                  adj.get(u).add(v);
                  adj.get(v).add(u);
            }

            dfs(1, -1, 0, 1);

            System.out.println(ans);

            sc.close();
      }
}
