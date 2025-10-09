package leetcode.BasicMath;

public class PrimeNumber {
    public static boolean isPrime(int n){
        if( n == 0 || n == 1 || n==2) return true;

        int primeFlag = 0;
        for(int i = 1;i*i<=n;i++){
            if(n%i == 0){
                primeFlag++;

                if((n/i)!=i) primeFlag++;
            };
        }

        return primeFlag>2?false:true;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(3));
        System.out.println(isPrime(5));
        System.out.println(isPrime(15));
        System.out.println(isPrime(7));
        System.out.println(isPrime(59));
        System.out.println(isPrime(69));
    }
}
