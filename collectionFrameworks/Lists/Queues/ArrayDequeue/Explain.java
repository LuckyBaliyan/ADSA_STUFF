package collectionFrameworks.Lists.Queues.ArrayDequeue;

import java.util.ArrayDeque;

public class Explain {
    public static void main(String[] args) {
        ArrayDeque<Integer> ad = new ArrayDeque<>();

        ad.offer(1);

        //gives the flexibility to add elements at first and last..
        ad.offerFirst(2);
        ad.offerLast(3);

        System.out.println(ad);

        ad.pollFirst();
        
        System.out.println(ad);

        ad.pollLast();

        System.out.println(ad);
    }
}
