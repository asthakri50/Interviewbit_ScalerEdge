public class Solution {
    public int[] solve(int[] A, int B) {
        int n = A.length ;
        List<Integer> list = new ArrayList<>();
        int[] ans;
        int p1 = 0 ;
        int p2 = 1;
        long sum = A[0] ;
        if(n == 2){
            for(int i = 0 ; i < 2 ; i++){
                if(A[i] == B){
                    ans = new int[1];
                    ans[0] = B;
                    return ans;
                }
            }
        }
        while(p2 < n){
            if(sum == B){
                while(p1 < p2){
                    list.add( A[p1] );
                    p1++;
                }
               break; 
            }
               
             while(sum < B && p2 < n){
                 sum += A[p2] ;
                 p2++;
             }   
             while(sum > B){
                 sum -= A[p1] ;
                 p1 ++ ;
             }
        }
        if(list.size() != 0){
            ans = new int[list.size() ];
            for(int i = 0 ; i < list.size() ; i++)
                ans[i] = list.get(i) ;
        }
        else{
            ans = new int[1];
            ans[0] = -1;
        }
    return ans;    
    }
}
