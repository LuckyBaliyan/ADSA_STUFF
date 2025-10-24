package classRoom.Arrays.UnionofTwoArrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

public class Solution {
    static int [] UnionofTwoArrays(int [] n1,int [] n2){
        HashSet<Integer> st = new HashSet<>();
        
        for(int i:n1){
            st.add(i);
        }

        for(int a:n2){
            st.add(a);
        }

        int [] unionArr = new int [st.size()];
        int i = 0;

        for(int val: st){
          unionArr[i++] = val;
        }

        Arrays.sort(unionArr);
        return unionArr;
    }

    static int [] unionOptimal(int [] n1,int [] n2){
        int l1 = n1.length;
        int l2 = n2.length;

        Stack<Integer> st = new Stack<>();

        int j = 0;
        int i = 0;

        while(i<l1 && j<l2){
            if(n1[i] <= n2[j]){
                if(st.size() == 0 || st.peek() != n1[i]){
                    st.push(n1[i]);
                }
                i++;
            }
            else{
                if(st.size() == 0 || st.peek() != n2[j]){
                    st.push(n2[j]);
                }
                j++;
            }
        }

        while(i<l1){
            if(st.size() == 0 || st.peek() != n1[i]){
                st.push(n1[i]);
            }
            i++;
        }

        while(j<l2){
            if(st.size() == 0 || st.peek() != n2[j]){
                st.push(n2[j]);
            }
            j++;
        }

        int [] arr = new int[st.size()];
        int k = st.size() - 1;

        while(!st.isEmpty()){
            arr[k--] = st.pop();
        }

        return arr;
    }

    public static void main(String[] args) {
        int [] n1 = {0,2,3,4,5,6};
        int [] n2 = {1,2,7};

        int [] nums1 = {3, 4, 6, 7, 9, 9}, nums2 = {1, 5, 7, 8, 8};

        int [] arr = UnionofTwoArrays(nums1,nums2);

        for(int e:arr){
            System.out.print(e+" ");
        }

        System.out.println();

        int [] arr2 = unionOptimal(n1, n2);
        
        for (int i : arr2) {
            System.out.print(i+" ");
        }
    }
}
