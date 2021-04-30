import java.util.*;
import java.lang.*;

public class RemoveElements {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in) ;
        int n = scan.nextInt();
        int[] A  = new int[n] ;
        for(int i = 0 ; i < n ; i++)
            A[i] = scan.nextInt();
        scan.close();
        int ans = solve(A);
        System.out.println(ans);
    }

    public static int solve(int[] A){
        Arrays.sort(A) ;
        int cost = 0 ;
        int sum = 0;
        int n = A.length;
        if(n == 1)
            return A[0];
        for(int i = 0 ; i < n ; i++)
            sum = sum + A[i];
        for(int i = 0 ; i < n ; i++)
            cost = cost + sum - A[n-1-i];
        return cost;
    }
}
