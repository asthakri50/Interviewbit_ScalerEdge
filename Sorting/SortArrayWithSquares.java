public class Solution {
    public int[] solve(int[] A) {
        int[] sol = new int[A.length] ;
        int left = 0 ; 
        int right = A.length-1;
        for(int i = A.length-1 ; i >=0 ; i--){
            if(Math.abs(A[left] ) > A[right] ){
                sol[i] = A[left] * A[left] ;
                left++ ;
            }
            else{
            sol[i] = A[right] * A[right] ;
            right-- ;
            }
        }
        
        return sol ;
    }
}

