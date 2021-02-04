public class Solution {
    public int cntBits(int[] A) {
        int n = A.length ;
        int M = 1000000007 ;
        int sum = 0;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                int xor = A[i]^A[j] ;
                int count = 0;
                while(xor > 0 ){
                    xor = xor&(xor-1);
                    count++ ;
                }
                sum = (sum%M + count%M) % M ;
            }
        }
        return sum ;
    }
}
