public class Solution {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length;
        int m = B.length;
        
        int i = 0 ;
        int j = 0 ;
        //p1 points to element in A
        int p1 = 0 ;
        //p2 points to element in B
        int p2 = m-1 ;
        
        int[] ans = new int[2];
        int min_Diff = Integer.MAX_VALUE ;
        
        while(p1 < n && p2 >= 0){
          
            if(Math.abs(A[p1] + B[p2] - C ) < min_Diff ){
                min_Diff = Math.abs(A[p1] + B[p2] - C);
                i = p1 ;
                j = p2 ;
            }
                
            //Case of multiple such pairs    
            if(Math.abs(A[p1] + B[p2] - C ) == min_Diff ){
                //Since p1 gets increasing only , the min i would be stored at first only. So , it won't be changed.
                //But , for j , since , p2 gets decreasing hence we need to update j when i is equal.
                if(p1 == i)
                    j = p2 ;
                
                
            }   
            
            if(A[p1] + B[p2] - C  < 0 )
                p1++;
                
             else if(A[p1] + B[p2] - C >= 0){
                p2-- ;
             }
            
               
        }  
        
        ans[0] = A[i] ;
        ans[1] = B[j] ;
        return ans;
    }
}

