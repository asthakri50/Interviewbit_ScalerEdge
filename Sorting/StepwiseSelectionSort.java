public class Solution {
    public int[] solve(int[] A) {
        int n = A.length ;
        int[] ans = new int[n-1] ;
    
      for(int i = 0 ; i < n-1 ; i++){
          int minVal = Integer.MAX_VALUE ;
          int minIdx = -1 ;
          for(int j = i ; j < n ; j++){
              if(A[j] < minVal){
                  minVal = A[j] ; 
                  minIdx = j ;
              }
          }
          ans[i] = minIdx ; 
          int temp = A[i] ;
          A[i] = A[minIdx] ;
          A[minIdx] = temp ;
          
      }
      return ans ;
  }
}
