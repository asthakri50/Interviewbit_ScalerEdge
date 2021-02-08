public class Solution {
    public int searchMatrix(int[][] A, int B) {
        int N = A.length ;
        int M = A[0].length ;
        if(B < A[0][0])
            return 0;
        if(B == A[0][0])
            return 1;
        if(B > A[N-1][M-1] )
            return 0;
        if(B == A[N-1][M-1] )
            return 1;
        
        int j = 0;
        int low = 0 ;
        int high = M-1 ;
        
        while(j < N){
            if( A[j][M-1] > B)
             break;
             if(A[j][M-1] == B)
             return 1;
        j++;     
        }
        
        while(low <= high){
            int mid = low + (high - low) / 2 ;
            if(B == A[j][mid])
                return 1; 
            if(B > A[j][mid] )
                low = mid + 1;
            else
                high = mid - 1;
        }
      return 0;  
    }
}
