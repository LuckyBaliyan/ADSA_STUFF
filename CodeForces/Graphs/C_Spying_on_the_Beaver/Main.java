package CodeForces.Graphs.C_Spying_on_the_Beaver;

import java.util.Arrays;

/*C. Spying on the Beaver
time limit per test2 seconds
memory limit per test256 megabytes

You are given a rooted tree∗
 with n
 vertices, numbered from 1
 to n
. The vertex numbered 1
 is the root of the tree. The Beaver, initially located at the root, travels through the tree to one of the beaver dams located at the vertices numbered a1,…,am
.

You need to determine which of these m
 vertices the Beaver went to. To do this, you can place cameras on any edges of the tree. If the Beaver traverses an edge with a camera on it, you will see this. For clarity, we assume that after all the Beaver's movements, you will receive a sequence of edges with cameras in which the Beaver was observed passing through the corresponding edge.

Since cameras are expensive, it is necessary to use the minimum number of them sufficient to uniquely determine the Beaver's destination. You are required to state the minimum necessary number of cameras k
 and the edges on which they should be placed.

∗
A rooted tree is a tree where one vertex is special and called the root.

Input
Each test contains multiple test cases. The first line contains the number of test cases t
 (1≤t≤2⋅104
). The description of the test cases follows.

In the first line of each test case, there is a single integer n
 (2≤n≤105
).

The second line contains n−1
 integers p2,…,pn
 — the parents of the vertices from the 2
nd to the n
th (1≤pi<i
; 2≤i≤n
).

The third line contains a single integer m
 — the number of vertices containing beaver dams (1≤m≤n
).

In the fourth line, there are m
 integers a1,…,am
 — the numbers of these vertices (1≤ai≤n
; 1≤i≤m
). All ai
 are distinct.

It is guaranteed that the sum of n
 across all test cases does not exceed 105
.

Output
For each test case, output exactly one line. First, output the number k
 — the minimum required number of cameras, and then, in the same line, for each of the k
 edges connecting the vertices u
 and pu
, where cameras need to be installed, output the vertex number u
.

If there are multiple answers, you can output any one of them.

Example
InputCopy
4
2
1
1
1
3
1 1
3
2 3 1
3
1 2
2
2 3
6
1 2 2 1 1
3
5 3 1
OutputCopy
0
2 2 3
1 3
2 2 5
Note
In the first test case, we do not need to install any cameras because there is only one dam in the tree, and the Beaver will definitely go there.

In the second test case, it is necessary to place a camera on each edge because there is a dam located at each vertex.

In the third test case, the dams are located in two adjacent vertices, so by placing a camera on the edge between these vertices, we can uniquely determine which one the Beaver went to. */

import java.util.Scanner;

public class Main {
      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int t = sc.nextInt();

            while (t-- > 0) {

                  int n = sc.nextInt();

                  int[] par = new int[n + 1];
                  int[] depth = new int[n + 1];

                  for (int i = 2; i <= n; i++) {

                        par[i] = sc.nextInt();

                        depth[i] = depth[par[i]] + 1;
                  }

                  System.out.println(Arrays.toString(par));
                  System.out.println(Arrays.toString(depth));

                  int m = sc.nextInt();

                  int[] dams = new int[m];

                  int keep = -1;

                  // Find the dam closest to root
                  for (int i = 0; i < m; i++) {

                        dams[i] = sc.nextInt();

                        if (keep == -1 ||
                                    depth[dams[i]] < depth[keep]) {

                              keep = dams[i];
                        }
                  }

                  // Number of cameras
                  System.out.print(m - 1);

                  // Put camera on parent edge of every
                  // dam except the one closest to root
                  for (int v : dams) {

                        if (v != keep) {
                              System.out.print(" " + v);
                        }
                  }

                  System.out.println();
            }

            sc.close();
      }
}
