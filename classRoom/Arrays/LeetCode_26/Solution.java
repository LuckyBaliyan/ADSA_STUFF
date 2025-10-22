package classRoom.Arrays.LeetCode_26;

/**
 * Remove Duplicates inPlace and return the length of uniue elements subarray from the start after those 
 * other elements can be in any order
 */

public class Solution {
    static int removeDuplicates(int [] arr){
        int n = arr.length;

        if(n == 0) return 0;

        int i = 0;
        int curr = 1;
        int j;

        for(j = 1;j<n;j++){
            if(arr[i] != arr[j]){
                arr[curr] = arr[j];
                i++;
                curr++;
            }
        }

        return curr;
    }

    public static void main(String[] args) {
        int [] arr = {0,0,1,1,1,3,3,2,2,4};

        System.out.println(removeDuplicates(arr));
    }
}
