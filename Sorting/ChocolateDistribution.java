public class Solution {
    public int solve(int[] A, int B) {
        if(B==0 || A.length == 0 )
        return 0 ;
        Arrays.sort(A) ; 
        int min = Integer.MAX_VALUE ; 
        for(int i= 0 ; i+B-1 < A.length ; i++){
            min = Math.min( min , A[i+B-1] - A[i] );
        }
        return min  ;
    }
}

