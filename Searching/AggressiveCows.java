public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A) ;
        int N = A.length ; 
        int low  = 1 ;
        int high = A[N-1] - A[0] ;
        int ans = 0 ;
        while(low <= high){
            int mid = low + (high - low)/ 2 ;
            if(check(A , B , mid) ) {
                   ans = mid ;  
                low = mid + 1 ;
            }
            else
                high = mid - 1 ; 
        }
    return ans ;    
    }
    
    boolean check(int[] stalls , int B ,int minDist){
        int N = stalls.length ;
        int recently_placed = stalls[0] ;
        int cows_placed = 1 ;
        
        for(int i = 1 ; i < N  ; i++){
            //When can I place a cow at stalls wrt recently placed
            if(stalls[i] - recently_placed >= minDist){
                cows_placed ++ ;
                recently_placed = stalls[i] ;
            }
        }
        //When can I say we were successful in placing all cows
        if(cows_placed >= B)
            return true ;
        else
            return false ;
    }
}
