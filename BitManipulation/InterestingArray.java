public class Solution {
    public String solve(int[] A) {
        int count = 0 ;
        for(int a : A){
            if( (a&1) == 1)
                count++;
        }
        if( (count&1) == 1 )
            return "No";
        return "Yes";    
    }
}
