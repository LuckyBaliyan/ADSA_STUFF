package classRoom.PriorityQeues.leetCode_973;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]

*/

public class Solution {
    static int [][] closestKDistances(int [][] points,int k){
        int n = points.length;
        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        //we will be storing every disatnce form center and its relative index from points

        for(int i =0;i<n;i++){
            int x = points[i][0];
            int y = points[i][1];

            int dis = x*x+y*y;
            minHeap.offer(new int [] {dis,i});
        }

        //Now we are calling the kth closest distances from minHeap which are already sorted

        int [][] res = new int [k][2];
        for(int i =0;i<k;i++){
            int index = minHeap.poll()[1];
            res[i] = points[index];
        }

        return res;
    }

    public static void main(String[] args) {
        int [][] points = {{1,3},{-2,2}};
        int [][] res = closestKDistances(points, 1);

        for(int i = 0;i<res.length;i++){
            System.out.print(Arrays.toString(res[i])+" ");
        }
    }
}
