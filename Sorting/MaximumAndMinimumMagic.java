public class Solution {
    public int[] solve(int[] A) {
        int n = A.length ;
        Arrays.sort(A) ;
        int[] ans = new int[2] ;
        int M = 1000000007;
        int min = 0 ;
        int max = 0 ;
        for(int i = 0 ; i < n-1 ; i=i+2){
            min =( min % M +( Math.abs( A[i] - A[i+1] ) ) % M ) % M;
        }
        
        for(int i = 0 ; i < n/2 ; i++){
            max = ( max % M + ( Math.abs(A[i] - A[n-1-i] ) ) % M ) % M;
        }
        ans[0] = max;
        ans[1] = min ;
        return ans;
    }
}
