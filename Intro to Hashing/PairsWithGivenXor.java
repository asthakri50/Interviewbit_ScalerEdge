public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length ;
        HashSet<Integer> hs = new HashSet<>();
        int count = 0 ;
        for( int i = 0 ; i < n ; i++){
            if(hs.contains(B ^ A[i]) ){
                count++ ;
            }
            else
            hs.add(A[i]) ;
        }
        return count;
    }
}
 