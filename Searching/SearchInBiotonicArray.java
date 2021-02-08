public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length ;
        int max = 0 ;
        int max_idx = 0;
        for(int i = 0 ; i < n ; i++){
            if(A[i] > max){
                max = A[i];
                max_idx = i;
            }
            
        }
       
        int low = 0 , high = max_idx ;
        while(low <= high){
            int mid = low + ( high - low) / 2;
            if( A[mid] == B)
                return mid ;
            if(A[mid] > B)
                high = mid - 1;
            else    
                low = mid + 1;
        }
         low = max_idx+1 ; 
         high = n - 1;
       
        while(low <= high){
            int mid = low + ( high - low) / 2;
            
            if( A[mid] == B)
                return mid ;
            if(A[mid] < B)
                high = mid - 1;
            else    
                low = mid + 1;
        }
    return -1 ;    
    }
}
