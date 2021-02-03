public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] searchRange(final int[] A, int B) {
        int n = A.length ; 
        int[] ans = {-1 , -1} ;
        
        int low = 0 , high = n-1 ;
        while(low <= high){
            int mid = low + high-low/2 ; 
            if(A[mid] < B)
                low = mid + 1 ; 
            else if(A[mid] > B)
                high = mid - 1 ;
            else if(A[mid] == B){
                ans[0] = mid ;
                high = mid - 1 ; 
            }    
        }
        
          low = 0 ; high = n-1 ;
        while(low <= high){
            int mid = low + high-low/2 ; 
            if(A[mid] < B)
                low = mid + 1 ; 
            else if(A[mid] > B)
                high = mid - 1 ;
            else if(A[mid] == B){
                ans[1] = mid ;
                low = mid + 1 ; 
            }    
        }
        
        return ans; 
        
    }
}
