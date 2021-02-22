public class Solution {
    public int solve(int[] A) {
        int n = A.length ;
        long[] presum = new long[n];
        presum[0] = A[0] ;
        for(int i = 1 ; i < n ; i++)
            presum[i] = presum[i-1] + A[i];
        
        HashSet<Long> hs = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(presum[i] == 0)
                return 1;
            if(hs.contains(presum[i]) )
                return 1;
            else
                hs.add(presum[i]);
        }
    return 0;    
    }
}
