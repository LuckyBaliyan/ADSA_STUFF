package leetcode.Sorting.Selection_Sort;

public class Solution {
    static void selectionSort(int [] arr,int n){
        if(n == 0) return;

        for(int i = 0;i<=n-2;i++){
            int min = i;
            for(int j = i;j<=n-1;j++){
               if(arr[min]>arr[j]) min = j;
            }

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int [] arr = {13,46,24,52,20,9};
        selectionSort(arr, 6);

        for (int e: arr) {
            System.out.println(e);
        }
    }
}
