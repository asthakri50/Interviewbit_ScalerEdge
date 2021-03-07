public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int maxSubArray(final int[] A) {
        int curr_sum = 0 ;
        int max_sum = Integer.MIN_VALUE ;
        for(int i = 0 ; i < A.length ; i++){
            curr_sum += A[i] ;
            if(curr_sum > max_sum)
                max_sum = curr_sum ;
            if(curr_sum < 0)
                curr_sum = 0;
        }
        return max_sum ;
    }
}
