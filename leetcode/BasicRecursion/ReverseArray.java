package leetcode.BasicRecursion;

/**
 * Reverse an array via recursion
 */

public class ReverseArray {
    static void reverseArray(int [] arr,int left,int right){
        if(left>=right) return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverseArray(arr, left+1, right-1);
    }

    /**
     * More optimized way
     */

    static void reverseArray(int [] arr,int i){
        if(i>=arr.length/2) return;

        int temp = arr[i];
        arr[i] = arr[arr.length-i-1];
        arr[arr.length-i-1] = temp;

        reverseArray(arr, i+1);
    }

    public static void main(String[] args) {
        int [] array = {1,2,3,4,5};
        int [] array2 = {1,2,4};
        reverseArray(array, 0, 4);
        reverseArray(array2, 0);

        for (int i : array) {
            System.out.print(i+",");
        }

        System.out.println();

        for (int i : array2) {
            System.out.print(i+",");
        }
    }
}
