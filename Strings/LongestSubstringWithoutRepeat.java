public class Solution {
    public int lengthOfLongestSubstring(String A) {
        int n = A.length() ;
        HashSet<Character> set = new HashSet<>();
        int p1 = 0;
        int p2 = 1;
        set.add(A.charAt(0) );
        int ans = 1;
        while(p2 < n ){
            if(set.contains(A.charAt(p2)) ){
                set.remove(A.charAt(p1) );
                p1++;
            }
            else{
                set.add(A.charAt(p2) ) ;
                ans = Math.max(ans , p2-p1+1);
                p2++;
            }
        }
    return ans;    
    }
}

