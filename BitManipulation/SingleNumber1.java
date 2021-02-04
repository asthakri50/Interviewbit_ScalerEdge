public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int ans = 0;
        for(int a : A)
        ans = ans ^ a ;
        
         return ans ;
    }
}

