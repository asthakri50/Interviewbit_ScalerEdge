public class Solution {
    public int solve(int[] A, int B) {
        int n = A.length ;
        int p1 = 0 ; 
        int p2 =  n-1;
        long count = 0;
        while(p1 <= p2){
            if( ( (long)A[p1] * A[p2]) < B){
                count += 2*(p2-p1+1) -1 ;
                p1++;
            }
            else
                p2--;
        }
        count = count % 1000000007;
        return (int)count ;
    }
}
