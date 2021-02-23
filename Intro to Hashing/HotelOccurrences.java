public class Solution {
    public int[] solve(int[] A) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for(int i = 0 ; i < A.length ; i++){
            if(set.contains(A[i]) ){
                set.remove(A[i]);
                set.add(A[i]);
            }
            else
                set.add(A[i]);
        }
       
        int[] ans = new int[set.size() ];
        int j = 0 ;
        for(int i : set){
           ans[j] = i;
           j++;
       }
       
        
    return ans;    
    }
    
}
