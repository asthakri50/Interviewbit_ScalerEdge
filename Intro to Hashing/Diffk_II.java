public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int diffPossible(final int[] A, int B) {
        int n = A.length ;
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 0 ; i < n ; i++){
            if(hs.contains(A[i] + B ) )
                return 1;
            else if(hs.contains (A[i] - B) )
                return 1;
            else
                hs.add(A[i]);
        }
    return 0;    
    }
}
