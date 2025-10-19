package leetcode.Sorting.Merge_Sort;

public class Solution {
    static void mergeSort(int [] arr,int low,int high){
        if(low>=high)return;
        int mid = low+(high - low)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);

        merge(arr,low,mid,high);
    }

    static void merge(int [] arr,int low,int mid,int high){
       int n = high - low +1;
       int [] temp = new int[n];

       for(int i = low;i<= high;i++){
        temp[i - low] = arr[i];
       }

       int left = 0;
       int right = mid - low+1;
       int k = low;

       while(left<=mid - low && right<= high - low){
        if(temp[left]<=temp[right]){
            arr[k++] = temp[left++];
        }
        else{
            arr[k++] = temp[right++];
        }
       }

       while(left<=mid - low){
        arr[k++] = temp[left++];
       }

       while(right<=high - low){
        arr[k++] = temp[right++];
       }

    }

    public static void main(String[] args) {
        int [] arr = {3,1,2,4,1,5,6,4,2};

        mergeSort(arr, 0, arr.length - 1);

        for (int i : arr) {
            System.out.println(i);
        }
    }
}
