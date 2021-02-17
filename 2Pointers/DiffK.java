public class Solution {
    public int diffPossible(int[] A, int B) {
        int n = A.length ;
        int l = 0 ; 
        int  r = 1;
        while(r < n){
                
            if(A[r] - A[l] < B)
                r++;
            else if(A[r] - A[l] > B)
                l++;
            else{
                if( l== r)
                    r++;
                else    
                    return 1;
            }
        }
    return 0;    
    }
}
