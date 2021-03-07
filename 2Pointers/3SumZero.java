public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer> >() ;
        int n = A.size();
        Collections.sort(A) ;
        for(int i = 0 ; i < n-2 ; i++){
            int l = i+1 ;
            int r = n-1 ;
            while(l < r){
                if(A.get(l) + A.get(r) == -1*A.get(i) ){
                    ArrayList<Integer> inside = new ArrayList<>();
                    inside.add(A.get(i) );
                    inside.add(A.get(l) ) ;
                    inside.add(A.get(r) );

                    if(!ans.contains(inside) )
                        ans.add(inside) ;
                    r -- ;
                }
                else if(A.get(l) + A.get(r) > -1 * A.get(i))
                    r-- ;
                else
                    l++ ;
            }
        }
        return ans;
    }
}
