import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        Scanner s = new Scanner(System.in) ;
        String str = s.next();
        int n = str.length() ;
        String rev = reverse(str , n-1);
        System.out.println(rev) ;
    }
    
    public static String reverse(String str, int i){
        String rev = "";
        if(i < 0)
            return rev;
            
        return rev + str.charAt(i) + reverse(str , i-1) ;   
    }
}