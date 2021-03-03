public class Solution {
    public int solve(int[] A, int B) {
        Arrays.sort(A) ;
        int n = A.length ;
        //Edge case when all the elements are same
         if(A[0] == A[n-1] && B == 0)
            return 1;
            
        int p1 = 0 ;
        int p2 = 1;
        int count = 0;
        
        while(p2 < n){
            if(A[p2] - A[p1] > B)
              p1++ ;
            else if(A[p2] - A[p1] < B)
                p2++;
            else{
                    if(p1 == p2)
                        break;
                        
                    count++ ;
                    int left = p1;
                    while(A[left] == A[p1] && p1 < n-1 )
                        p1++;
                    int right = p2;
                    while(A[right] == A[p2]  && p2 < n-1)
                        p2++;
               
            }
            
        }
        return count;
    }
}
