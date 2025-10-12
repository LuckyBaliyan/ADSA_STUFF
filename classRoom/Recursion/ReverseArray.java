package classRoom.Recursion;

public class ReverseArray {
    static void reverse(int [] arr,int left,int right){
        if(left>right) return;

        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        reverse(arr, left+1, right-1);
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        reverse(arr, 0, arr.length-1);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
