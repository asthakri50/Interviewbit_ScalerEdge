public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] intersect(final int[] A, final int[] B) {
        List<Integer> list = new ArrayList<>();
        int n = A.length ;
        int m = B.length ;
        int p1 = 0 ;
        int p2 = 0;
        while(p1 < n && p2 < m){
            if(A[p1] < B[p2])
                p1++ ;
            else if(A[p1] > B[p2] )
                p2++ ;
            else{
                list.add( A[p1] );
                p1++;
                p2++;
            }    
        }
        int[] ans = new int[list.size() ];
        for(int i = 0; i < list.size() ; i++)
            ans[i] = list.get(i) ;
        return ans;    
    }
}
