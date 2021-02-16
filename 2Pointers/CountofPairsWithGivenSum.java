public class Solution {
    public int solve(int[] A, int B) {
        int N = A.length ;
        int count = 0;
        int low = 0 ;
        int high = N-1 ;
        while(low < high){
            if(A[low] + A[high] > B)
                high--;
            else if(A[low] + A[high] < B)
                low++;
            else{
                count ++ ;
                low ++;
                high --;
            }    
        }
    return count;    
    }
}
