package leetcode.Sorting.Insertion_Sort;

public class Solution {
    static void insertionSort(int [] arr ,int n){
        if(n == 0)return;

        for(int i = 0;i<n;i++){
            int j = i;
            while (j>0 && arr[j]<arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;

                j--;
            }
        }
    }

    public static void main(String[] args) {
        int [] arr = {13,46,52,24,20,9};
        insertionSort(arr, 6);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
