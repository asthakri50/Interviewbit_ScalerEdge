public class Solution {
    public int solve(int[] A) {
        int n = A.length ;
        if(n == 1)
            return A[0] ;
        if(A[0] >= A[1])
            return A[0] ;
        if(A[n-1] >= A[n-2] )
            return A[n-1] ;
            
        int low = 0 , high = n-1 ;
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(A[mid] > A[mid-1] && A[mid] > A[mid+1])
                return A[mid] ;
            
            if(A[mid] < A[mid-1])
                high = mid - 1;
            else
                low = mid + 1;
        }
    return -1;    
    }
}
