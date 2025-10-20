package leetcode.Sorting.Quick_Sort;

public class Solution {
    static void quickSort(int [] arr,int low,int high){
        if(low<high){
            int partitionIndx = Partion(arr,low,high);
            quickSort(arr, low, partitionIndx - 1);
            quickSort(arr, partitionIndx + 1, high);
        }
    }

    static int Partion(int [] arr,int low,int high){
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j) {
            //Seeking for bigger values than pivot
            while(arr[i]<= pivot && i<=high-1){
                i++;
            }

            while(arr[j] > pivot && j>=low+1) j--;

            if(i<j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            };
        }
        
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }

    public static void main(String[] args) {
        int [] arr = {4,6,2,5,7,9,1,4};

        quickSort(arr, 0, arr.length - 1);

        for(int a : arr){
            System.out.print(a+" ");
        }
    }
}
