public class Solution {
    public int[] solve(int[] A) {
        int n = A.length ; 
       for(int i = 0 ; i < n-1 ; i++){
           int j = i ;
           while(j>=0 && A[j] > A[j+1]){
               int temp = A[j] ; 
               A[j] = A[j+1] ; 
               A[j+1] = temp ;
               j-- ;
           }
       }
       return A;
}
}
