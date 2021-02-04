public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int i = 0 ; i < 32 ; i++){
            int count = 0 ; 
            for(int j = 0 ; j < A.length ; j++){
                if(  ((1<<i)&A[j]) > 0)
                count++ ; 
            }
            if(count % 3 != 0)
            ans |= (1<<i) ;
        }
        return ans ;
    }
}
