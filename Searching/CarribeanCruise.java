public class Solution {
    public int solve(int A, int[] B) {
        int max = 0 ;
        for(int i= 0 ; i < B.length ; i++)
            max = Math.max(max, B[i] );
        int[] counts = new int[max+1] ;
        
         for(int i = 0; i < B.length ; i++)
            counts[ B[i] ]++ ;
        
        int low = 1 ;
        int high = B.length ;
        int ans = 0;
        while(low <= high ){
            int mid = low + (high - low)/2 ;
            
            if(check(A, counts, mid) ){
                 ans = mid ;
                low = mid +1 ;
            }
            else
                high = mid - 1;
        }
    return ans ;    
    }
    
    public boolean check(int A , int[] counts , int lunchboxes){
        int cnt = 0;
        for(int i = 0 ; i < counts.length ; i++){
            //When that food can be chosen
            if(counts[i] >= lunchboxes)
                cnt = cnt + counts[i]/lunchboxes ;
        }
        //when we can say that mid no of lunchboxes can be made
    if(cnt >= A)
        return true ;
    else
        return false ;        
    }
    
}
