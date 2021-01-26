public class Solution {
    public int solve(int[] A) {
        Arrays.sort(A) ;
        int n = A.length ;
        int ans = 0 ;
        int M = 1000000007 ;
        long[] powerarr = new long[n] ; 
        powerarr[0] = 1 ;
        for(int i = 1 ; i < n ; i++)
        powerarr[i] =((powerarr[i-1] % M) * 2 ) % M ;
        
        for(int i = 0 ; i < n ; i++){
            // ans = ans + [pow(2 , i ) - pow ( 2 , n-1-i) ] *A[i] ;
          ans = (int)(ans % M + ( ( powerarr[i] - powerarr[n-1-i] ) % M * A[i] % M ) % M ) % M;    
        }
        return ans%M ;
    }
}
