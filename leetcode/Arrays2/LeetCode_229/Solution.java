package leetcode.Arrays2.LeetCode_229;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 *  Majority Element 3
 */

public class Solution {
    static HashSet<Integer> majorityElem(int [] arr){
        HashSet<Integer> res = new HashSet<>();

        int n = arr.length;
        if(n<=1) return null;

        for(int i = 0;i<n;i++){
            int count  = 0;
            for(int j = i;j<n;j++){
                if(arr[i] == arr[j]){
                    count++;
                }

                if(count > n/3) break;
            }
            if(count > n/3) res.add(arr[i]);
        }

        return res;
    }


    //Better Approach using Hashing

    static ArrayList<Integer> majorityElemsBetter(int [] nums){
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
           map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> e:map.entrySet()){
            if(e.getValue() > n/3){
              res.add(e.getKey());
            }
        }

        return res;
    }

    //Optimal using voting algorith of koi aadmi

    static ArrayList<Integer> majorityElementOptimal(int [] nums){
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<>();

        int cnt1 = 0;int cnt2 = 0;
        int el1 = 0;int el2 = 0;

        for(int i = 0;i<n;i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1  = 1;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            }
            else if(el1 == nums[i])cnt1++;
            else if(el2 == nums[i])cnt2++;
            else{
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;cnt2 = 0;
        for(int i =0;i<n;i++){
            if(nums[i] == el1){
                cnt1++;
            }
            else if(nums[i] == el2){
                cnt2++;
            }
        }

        if(cnt1 > n/3)res.add(el1);
        if(cnt2 > n/3)res.add(el2);

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {1,1,1,1,2,2,2,2,2,2,2,2,2,4,4,4,4,4,4,4};
        HashSet<Integer> list = majorityElem(arr);

        System.out.println(list);

        ArrayList<Integer> res = majorityElemsBetter(arr);
        System.out.println(res);

        ArrayList<Integer> res2 = majorityElementOptimal(arr);
        System.out.println(res2);
    }
}
