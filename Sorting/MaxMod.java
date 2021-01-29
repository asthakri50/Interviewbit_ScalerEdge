public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A) ; 
        int n = A.length ; 
        int max =  0;
        for(int i = 0 ; i < n-1 ; i++)
        max = Math.max(max , A[i] % A[n-1] ) ;
        return max ;
    }
}

