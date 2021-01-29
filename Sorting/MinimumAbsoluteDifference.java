public class Solution {
    public int solve(int[] A) {
        int min = Integer.MAX_VALUE ; 
        Arrays.sort(A) ;
        for(int i = 0 ; i < A.length-1 ; i++){
            min = Math.min( min , Math.abs(A[i] - A[i+1]) ) ;
        }
        return min ;
    }
}
