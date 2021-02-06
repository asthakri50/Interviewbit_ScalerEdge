public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int search(final int[] A, int B) {
        int n = A.length ;
        int low = 0 , high = n - 1 ;
    
        while(low <= high){
            int mid = low + (high - low)/2 ;
            if(A[mid] == B)
                return mid ;
            if(B >= A[0]){ //B belongs to left array
                if( A[mid] < A[0])
                    high = mid - 1;
                else{
                    if(A[mid] > B)
                        high = mid -1 ;
                    else
                     low = mid + 1;
                }
            }
            if(B < A[0]){ //B  is in right array
                if(A[mid] >= A[0])
                    low = mid + 1;
                else{
                    if(A[mid] > B)
                        high = mid - 1;
                    else
                        low = mid + 1;
                }    
            }
        }
    return -1 ;    
    }
}
