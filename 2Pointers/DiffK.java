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
                //When B == 0 , we need to find A[r] -A[r] such that i !=j i.e check for duplicates in array
                // But, in first iteration only, A[r] - A[l] >0 (in general) then l++ , now l == r => A[l] - A[r] == 0 , we need to do r++
                // Check for [1, 2, 3]
                if( l== r)
                    r++;
                else    
                    return 1;
            }
        }
    return 0;    
    }
}
