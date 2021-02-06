public class Solution {
    public int[] subUnsort(int[] A) {
        int[] sorted = new int[A.length] ;
        int n = A.length ;
        for(int i =0 ; i < A.length ; i++)
            sorted[i] = A[i] ;
        Arrays.sort(sorted) ;
        int[] ans;
        int i = 0;
        for(i = 0 ; i < n ; i++){
            if(A[i] != sorted[i]){
                break ;
            }
        }
        
        if(i == n){
            ans = new int[1] ;
            ans[0] = -1 ;
            return ans ;
        }
        ans = new int[2];
        ans[0] = i ;
        for( i = 0 ; i < n ; i++){
            if(A[n-1-i] != sorted[n-1-i] ){
                ans[1] = n-1-i;
                break ;
            }
        }
    return ans ;    
    }
}
