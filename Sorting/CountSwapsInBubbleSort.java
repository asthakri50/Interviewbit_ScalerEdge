public class Solution {
    public int solve(int[] A) {
        int n = A.length ; 
        int count = 0 ;
    
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n-i-1 ; j++){
                if(A[j] > A[j+1]){
                    count++ ;
                    int temp = A[j];
                    A[j] = A[j+1] ;
                    A[j+1] = temp ;
                }
            }
        }
        return count ;
    }
}

