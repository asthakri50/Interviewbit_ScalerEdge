public class Solution {
    public int[] solve(int[] A) {

        int aXorb = 0;  // the result of a xor b;
        for (int item : A) aXorb ^= item;
        
        int lastBit = (aXorb & (aXorb - 1)) ^ aXorb;  // the last bit that a diffs b
        
        int intA = 0, intB = 0;
        for (int item : A) {
        
            // based on the last bit, group the items into groupA(include a) and groupB
            if ( (item & lastBit) != 0) intA = intA ^ item;
            else intB = intB ^ item;
        }
       
        int x = Math.min(intA, intB), y =  Math.max(intA, intB);
        int[] ans = new int[2];
        ans[0] = x;
        ans[1] = y;
        return ans; 
        
    }
}
