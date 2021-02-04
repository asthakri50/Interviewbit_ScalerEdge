public class Solution {
    public int solve(int A, int B) {
        int X = A;
        if(B == 0){
            return 0;
        }
        //Count the number of set bits in A
        int setbits = countBits(A) ;
        
        if(setbits < B){
            //Set extra bit 
            int extra = B - setbits ;
            int i = 0 ;
            while(extra > 0){
                if((X & (1<<i)) == 0){
                    X |= (1<<i) ;
                    extra -- ;
                }
                i++ ;
            }
        }
        
        else if( setbits > B){
            int extra = setbits - B ;
            //Unset extra bits
            int j = 0;
            while(extra > 0){
                if( (X &(1<<j) ) > 0 ) {
                    X&= ~(1<<j);
                    extra -- ;
                }
                j++ ;
            }
            
        }
        return X;
    }
    
    public int countBits(int A){
        int count = 0 ;
        while(A > 0){
            count++ ;
            A = A & (A-1) ;
        }
        return count ;
    }
}
