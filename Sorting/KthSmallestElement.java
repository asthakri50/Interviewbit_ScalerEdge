public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int kthsmallest(final int[] A, int B) {
        int n = A.length ;
        int[] arr = new int[n] ; 
        
        for(int i = 0 ; i < n ; i++)
        arr[i] = A[i] ;
        
        for(int i = 0 ; i < n-1 ; i++ ){
            int minVal =Integer.MAX_VALUE ; 
            int minIdx = -1 ;
            
            for(int j = i ; j < n ; j++){
                if(arr[j] < minVal){
                    minVal = arr[j] ;
                    minIdx = j ;
                }
            }
            //swap(arr[i]  , arr[minIdx]);
            int temp = arr[i] ; 
            arr[i] = arr[minIdx] ;
            arr[minIdx] = temp ;
            
        }
       return arr[B-1]; 
    }
}

