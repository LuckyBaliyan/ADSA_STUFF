package leetcode.Arrays2.LeetCode_56;

import java.util.Arrays;

/***
 * 
56. Merge Intervals
Solved
Medium
Topics
premium lock icon
Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
Example 3:

Input: intervals = [[4,7],[1,4]]
Output: [[1,7]]
Explanation: Intervals [1,4] and [4,7] are considered overlapping.
 
 */

public class Solution {
    static int[][] mergeIntervals(int [][] intervals){
        int n = intervals.length;
        int [][] ans = new int[n][2];
        int index = 0;

        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);

        for(int i = 0;i<n;i++){
            int start = intervals[i][0];
            int end  = intervals[i][1];

            if(index > 0 && ans[index-1][1] >= start) continue;

            for(int j = i+1;j<n;j++){
                if(intervals[j][0] <= end){
                    end = Math.max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }

            ans[index][0] = start;
            ans[index][1] = end;
            index++;
        }

        return Arrays.copyOf(ans, index);
    }

    static int[][] mergeIntervalsOptimal(int [][] intervals){
        int n = intervals.length;
        int index = 0;

        Arrays.sort(intervals,(a,b)-> a[0] - b[0]);
        int [][] ans = new int[n][2];

        for(int i= 0;i<n;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if(index == 0 || ans[index-1][1] < start){
                ans[index][0] = start;
                ans[index][1] = end;
                index++;
            }
            else{
                ans[index-1][1] = Math.max(end,ans[index-1][1]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int [][] ans = mergeIntervals(new int [][] {{1,3},{2,6},{8,10},{15,18}});
        for(int i = 0;i<ans.length;i++){
            for(int j = 0;j<2;j++){
                System.out.print(ans[i][j]+" ");
            }
        }

        System.out.println();

        int [][] ans2 = mergeIntervalsOptimal(new int [][] {{1,3},{2,6},{8,10},{15,18}});
        for(int i = 0;i<ans2.length;i++){
            for(int j = 0;j<2;j++){
                System.out.print(ans2[i][j]+" ");
            }
        }
    }
}
