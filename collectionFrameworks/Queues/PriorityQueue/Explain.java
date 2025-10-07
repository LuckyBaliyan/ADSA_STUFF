package collectionFrameworks.Queues.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Explain {
    public static void main(String[] args) {

        //by default the priority is set for the smallest element on peek
        Queue<Integer> q = new PriorityQueue<>();

        //Change the priority to make it maxHeap
        Queue<Integer> mq = new PriorityQueue<>(Comparator.reverseOrder());

        Queue<Character> ch = new PriorityQueue<>();
        char[] chars =  {'a','b','d','a','c','e'};

        q.offer(200);
        q.offer(36);
        q.offer(2);
        q.offer(100);
        q.offer(1);

        System.out.println(q);

        
        mq.offer(200);
        mq.offer(36);
        mq.offer(2);
        mq.offer(100);
        mq.offer(1);

        System.out.println(mq);

        for (char c : chars) {
            ch.offer(c);
        }

        System.out.println(ch);

        ch.poll();
        System.out.println(ch);

        ch.poll();

        System.out.println(ch+" "+ch.peek());
    }
}
