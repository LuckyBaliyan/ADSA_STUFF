package leetcode.BasicRecursion;

public class PalindromeString {
    static boolean isPalindrome(String name,int i){
        if(i>=name.length()/2) return true;

        if(name.charAt(i) != name.charAt(name.length()-i-1)){
            return false;
        }

        return isPalindrome(name, i+1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("MADAM", 0));
    }
}
