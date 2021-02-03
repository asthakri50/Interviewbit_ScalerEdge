public class Solution {
	public int numSetBits(long A) {
	int count = 0 ;
	
    while(A > 0){
        count += A&1 ;
        A>>=1;
    }
    
    return count;
	}
}
