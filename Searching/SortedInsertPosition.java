public class Solution {
    public int searchInsert(int[] A, int B) {
        int n = A.length ; 
        if(A[0] == B || A[0] > B)
            return 0 ;
        if(A[n-1] == B || A[n-1] < B)
            return n ;
        int low = 0 , high = n - 1 ;
        
        while( low <= high ){
            int mid = low + (high - low) / 2 ;
            if (A[mid] == B)
                return mid ;
            else if(A[mid] > B && A[mid-1] < B)
                return mid ;
            else if(A[mid] < B )
                low = mid + 1 ;
            else if(A[mid] > B)
                high = mid - 1 ;
        }
        return -1 ;
    }
}
