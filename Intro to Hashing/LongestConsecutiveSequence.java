public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        int n = A.length ;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0  ; i < n ; i++)
            hs.add(A[i]);
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            int count = 0 ;
            if(! hs.contains(A[i] - 1)){
                int j = 0 ;
                 while(hs.contains(A[i] + j) ){
                 count++;
                 j++;
                 }
                 ans = Math.max(ans , count) ;
            }
        }
        return ans ;
    }
}
