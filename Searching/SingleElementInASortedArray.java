public class Solution {
    public int solve(int[] A) {
        int n = A.length  ;
        int low = 0  , high = n-1 ;
        if(low == high)
            return A[low] ;
        else if(A[0] != A[1])
            return A[0];
        else if(A[high] != A[high-1] )
            return A[high];
            
        while(low <= high){
            int mid = low + (high - low)/ 2 ;
            if( A[mid] != A[mid-1] && A[mid] != A[mid+1] )
                return A[mid] ;
            //If we land on 2nd Occurrence , move to first occurrence index
            if( A[mid] == A[mid-1])
                mid = mid -1 ;
            //Using INDEX PAIR property , first occurence would be even index in left array and odd in right array
            if(mid % 2 == 0 )  //move right
                low = mid + 2;
            else     // move left
                high = mid -1;
        }
    return -1 ;    
    }
}
