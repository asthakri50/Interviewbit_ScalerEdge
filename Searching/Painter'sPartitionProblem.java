public class Solution {
     int mod = 10000003 ;
     
    public int paint(int A, int B, int[] C) {
        int N = C.length ;
        long low = 0 ;
        long high = 0;
        //low is the maximum time required to paint any of the board
        //high is the time required to paint all the boards
        for(int i = 0 ; i < N ; i++){
            if(C[i] > low )
                low = C[i] ;
            high += C[i] ;    
        }
    
        long ans = 0;
        while(low <= high ){
            long mid = low + (high - low)/2 ;
            if(check(A , B , C , mid % mod) ){
                ans = mid ;
                high = mid - 1;
            }
            else
                low = mid + 1 ;
        }
        ans = ( (ans % mod) * (B % mod) ) % mod ;
        if( ans < 0)
        return (int)(ans + mod)  ;
        
    return (int)ans ;    
    }
    
    public boolean check(int A , int B , int[] C  , long maximum_time ){
        int N = C.length ;
        long painters = 1 ;
        long time = 0;
        for(int i = 0 ; i < N ; i++){
            time = (time % mod + C[i] % mod ) % mod ;
            //When next painter to be appoached for painting
            if(time > maximum_time ){
            painters ++ ;
            time = C[i]  ;
            }
        }
     if(painters <= A)
        return true ;
    else
        return false ;
    }
    
}
