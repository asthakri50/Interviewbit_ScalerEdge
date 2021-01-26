public class Solution {
    public int solve(int[] A) {
        int N= A.length;
        int time=0 , maximum=0;
        for(int i=0;i<N;i++){
            maximum=Math.max(maximum , A[i]);
        }
        for(int i =0 ; i< N; i++){
            time = time + maximum-A[i];
        }
        return time;
    }
}
