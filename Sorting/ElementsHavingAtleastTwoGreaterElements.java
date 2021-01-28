public class Solution {
    public int[] solve(int[] A) {
        int n = A.length ; 
        int[] temp = new int[n] ; 
        for(int i = 0 ; i < n ; i++)
        temp[i] = A[i] ;
        
        Arrays.sort(temp) ;
        
        int[] sol = new int[n-2] ; 
        int j = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(A[i] != temp[n-1] && A[i] != temp[n-2]){
            sol[j] = A[i] ; 
            j++ ;
            }
        }
        
        return sol ;
    }
}

