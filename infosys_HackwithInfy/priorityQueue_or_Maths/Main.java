package infosys_HackwithInfy.priorityQueue_or_Maths;

import java.util.*;

public class Main {
      // This question made me loose my chance to get specialist programmer role
      // interview from infosys
      // and this is the most ovbvious solution a normal human specially student can
      // think of
      // it was the first question of my set (easy level) usaully the 1st questions
      // are very easy
      // but this question was tricky

      public static long getArrangments(int[] arr, int n, int k) {

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                  if (a[0] != b[0])
                        return Integer.compare(b[0], a[0]);

                  return Integer.compare(a[1], b[1]);
            });

            for (int i = 0; i < n; i++) {
                  pq.offer(new int[] { arr[i], i });
            }

            long operations = 0;

            // This loop is keep running until the all the values are equal s.t
            // value % k == 0
            while (true) {

                  /*
                   * Pick the maximum element.
                   * This element will remain unchanged.
                   */
                  int[] curr = pq.poll();

                  /*
                   * Increment every element except curr.
                   */
                  List<int[]> temp = new ArrayList<>();

                  while (!pq.isEmpty()) {

                        int[] x = pq.poll();

                        x[0]++;

                        temp.add(x);
                  }

                  /*
                   * Put the unchanged maximum back.
                   */
                  pq.offer(curr);

                  /*
                   * Put all incremented elements back.
                   */
                  for (int[] x : temp) {
                        pq.offer(x);
                  }

                  operations++;

                  /*
                   * Check whether all elements are equal.
                   */
                  HashSet<Integer> st = new HashSet<>();

                  for (int[] x : pq) {
                        st.add(x[0]);
                  }

                  /*
                   * All elements are equal.
                   */
                  if (st.size() == 1) {

                        int value = pq.peek()[0];

                        if (value % k == 0) {
                              return operations;
                        }
                  }
            }
      }

      public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] arr = new int[n];

            for (int i = 0; i < n; i++) {
                  arr[i] = sc.nextInt();
            }

            System.out.println(getArrangments(arr, n, k));

            sc.close();
      }
}