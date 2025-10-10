package leetcode.BasicRecursion;

class LeetCode509{
    static int fibo(int n){
        if(n<=1)return n;
        return fibo(n-1)+fibo(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fibo(5));
        System.out.println(fibo(4));
        System.out.println(fibo(30));
    }
}