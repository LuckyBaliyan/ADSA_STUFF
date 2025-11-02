package classRoom.PriorityQeues.leetcode_658;

import java.util.ArrayList;
import java.util.PriorityQueue;

/*

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
    static ArrayList<Integer> giveAbsoluteClosestKElems(int [] nums,int k,int x){
        int n = nums.length;

        if(n == 0) return null;

        PriorityQueue<int []> minHeap = new PriorityQueue<>((a,b)->{
            if(a[0] != b[0]) return a[0] - b[0];
            else return b[0] - a[0];
        });

        for(int num:nums){
            minHeap.offer(new int []{(num - x),num});
        }

        ArrayList<Integer> res = new ArrayList<>();
        for(int i =0;i<k;i++){
            res.add(minHeap.poll()[1]);
        }

        return res;

    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,9,5,6,7,8};
        int k = 4;
        int x = 3;

        ArrayList<Integer> res = giveAbsoluteClosestKElems(arr, k, x);
        System.out.println(res);
    }
}
