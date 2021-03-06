public class Solution {
    public int solve(int[] A) {
        int n = A.length ;
        for(int i = 0 ; i < n ; i++){
            if(A[i] == 0)
                A[i] = -1;
        }
        
        //now find the maximum length of a contiguous array whose sum is zero
        int[] prefix = new int[n];
        prefix[0] = A[0];
        for(int i = 1 ; i < n ; i++)
            prefix[i] = A[i] + prefix[i-1];
            
        HashMap<Integer , Integer> map  = new HashMap<>();
        int max_length = 0 ;
        //for removing zero case
        map.put(0 , -1);
        for(int i = 0 ; i  < n ; i++){
            if(!map.containsKey(prefix[i]) ){
                map.put(prefix[i] , i);
            }
            else{
                max_length = Math.max(max_length , i - map.get(prefix[i]) ) ;
            }
        }
    return max_length ;    
    }
}
