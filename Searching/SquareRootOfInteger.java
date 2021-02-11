public class Solution {
    public int sqrt(int A) {
        int low = 1 ;
        int high = A ;
        int ans = 0 ;
        
        while(low <= high){
            int  mid = low + (high - low)/2 ;
            if( mid <= (A/mid) ){
                ans = mid ;
                low = mid + 1 ; 
            }
            else
             high = mid - 1 ;
        }
    return ans ;    
    }
}
