package gfg.Arrays.CountSubarrayWithGivenXor;

import java.util.HashMap;

/*
 * Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.
Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
Input: arr[] = [1, 1, 1, 1], k = 0
Output: 4
Explanation: The subarrays are [1, 1], [1, 1], [1, 1] and [1, 1, 1, 1].
 */

public class Solution {

    static int CountXor(int [] arr,int k){
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int prefixXor = 0;int count = 0;
        for(int i = 0;i<n;i++){
            prefixXor ^= arr[i];
            int target = prefixXor ^ k;
            count += map.getOrDefault(target, 0);
            map.put(prefixXor,map.getOrDefault(prefixXor, 0)+1);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(CountXor(new int [] {4,2,2,6,4}, 6));
    }
    
}
