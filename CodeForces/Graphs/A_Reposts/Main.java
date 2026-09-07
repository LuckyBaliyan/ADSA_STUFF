package CodeForces.Graphs.A_Reposts;

/*
A. Reposts
time limit per test1 second
memory limit per test256 megabytes
One day Polycarp published a funny picture in a social network making a poll about the color of his handle. Many of his friends started reposting Polycarp's joke to their news feed. Some of them reposted the reposts and so on.

These events are given as a sequence of strings "name1 reposted name2", where name1 is the name of the person who reposted the joke, and name2 is the name of the person from whose news feed the joke was reposted. It is guaranteed that for each string "name1 reposted name2" user "name1" didn't have the joke in his feed yet, and "name2" already had it in his feed by the moment of repost. Polycarp was registered as "Polycarp" and initially the joke was only in his feed.

Polycarp measures the popularity of the joke as the length of the largest repost chain. Print the popularity of Polycarp's joke.

Input
The first line of the input contains integer n (1 ≤ n ≤ 200) — the number of reposts. Next follow the reposts in the order they were made. Each of them is written on a single line and looks as "name1 reposted name2". All the names in the input consist of lowercase or uppercase English letters and/or digits and have lengths from 2 to 24 characters, inclusive.

We know that the user names are case-insensitive, that is, two names that only differ in the letter case correspond to the same social network user.

Output
Print a single integer — the maximum length of a repost chain.

Examples
InputCopy
5
tourist reposted Polycarp
Petr reposted Tourist
WJMZBMR reposted Petr
sdya reposted wjmzbmr
vepifanov reposted sdya
OutputCopy
6
InputCopy
6
Mike reposted Polycarp
Max reposted Polycarp
EveryOne reposted Polycarp
111 reposted Polycarp
VkCup reposted Polycarp
Codeforces reposted Polycarp
OutputCopy
2
InputCopy
1
SoMeStRaNgEgUe reposted PoLyCaRp
OutputCopy
2
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
      static ArrayList<ArrayList<Integer>> adj;
      static HashMap<String, Integer> id;
      static boolean[] visited;
      static int maxDepth;

      public static void dfs(int u, int depth) {
            visited[u] = true;
            maxDepth = Math.max(maxDepth, depth);

            for (int ne : adj.get(u)) {
                  if (!visited[ne]) {
                        dfs(ne, depth + 1);
                  }
            }
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();

            adj = new ArrayList<>();
            id = new HashMap<>();

            for (int i = 0; i <= n; i++)
                  adj.add(new ArrayList<>());

            int idCnt = 0;
            maxDepth = 0;
            visited = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                  String s = sc.nextLine();
                  String[] nodes = s.split("\\s+");

                  if (!id.containsKey(nodes[0].toLowerCase()))
                        id.put(nodes[0].toLowerCase(), idCnt++);
                  if (!id.containsKey(nodes[2].toLowerCase()))
                        id.put(nodes[2].toLowerCase(), idCnt++);

                  // make the dependency
                  int u = id.get(nodes[2].toLowerCase());
                  int v = id.get(nodes[0].toLowerCase());

                  adj.get(u).add(v);
            }

            // make a dfs call from source and count a max depth
            int src = id.get("polycarp");
            // have to use everything one based due to our mapping of Strings with hashMap
            dfs(src, 1);

            System.out.println(maxDepth);
      }
}
