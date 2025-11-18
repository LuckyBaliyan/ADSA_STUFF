package CodeForces.Recursion.Factorial;

public class Solutiuon {
    static int facRec(int n){
        if(n <=1) return 1;
        return n* facRec(n-1);
    }

    public static void main(String[] args) {
       System.out.println(facRec(4));
    }
}
