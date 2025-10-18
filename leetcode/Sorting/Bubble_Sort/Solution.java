package leetcode.Sorting.Bubble_Sort;

public class Solution {
    static void bubbleSort(int [] arr,int n){
        if(n == 0) return;

        boolean flag;

        for(int i = 0;i<n-1;i++){
           flag = true;
           for(int j = 0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
                flag = false;
            }
           }

           if(flag) break;
        }
    }

    public static void main(String[] args) {
        int [] arr = {13,46,52,24,20,9};
        bubbleSort(arr, 6);

        System.out.print("["+" ");
        for (int i : arr) {
            System.out.print(i+ " ");
        }
        System.out.print("]");
    }
}
