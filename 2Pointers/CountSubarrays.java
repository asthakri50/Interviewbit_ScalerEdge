public class Solution {
    public int solve(int[] A) {
        int l = 0 ; 
        int r = 0 ;
        int n = A.length;
        long count = 0;
        int mod = 1000000007;
        Set<Integer> s = new HashSet<>(); 
        while(r < n && l <= r){
            int length = r-l+1 ;
            if(!s.contains(A[r]) ){
                s.add(A[r] );
                r++;
                count = (count + length) % mod ;
            }
            else{
                s.remove( A[l] );
                l++;
            }
        }
    return (int)count % mod ;    
    }
}
