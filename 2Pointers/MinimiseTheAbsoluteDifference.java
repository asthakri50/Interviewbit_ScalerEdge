public class Solution {
    public int solve(int[] A, int[] B, int[] C) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int ans = Integer.MAX_VALUE;

        while(p1 < A.length && p2 < B.length && p3 < C.length){
            int max = Math.max(A[p1] , Math.max(B[p2] , C[p3]) );
            int min = Math.min(A[p1] , Math.min(B[p2] , C[p3]) ) ;
            int curr_diff = Math.abs(max - min);
            if( ans > curr_diff)
                ans = curr_diff;
            if(min == A[p1])
                p1++;
            else if(min == B[p2])
                p2++;
            else
                p3++;
        }
        return ans;
    }
}
