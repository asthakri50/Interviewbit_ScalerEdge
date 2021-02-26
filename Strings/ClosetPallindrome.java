public class Solution {
    public String solve(String A) {
        int n = A.length() ;
        int count = 0;
        for(int i = 0 ; i < n/2 ; i++){
            if(A.charAt(i) != A.charAt(n-1-i) )
                count++;
        }
    if(count == 1)
        return "YES";
    //When Ais already a pallindrom
    //Case a. length is even  when 1 character is changed , element becomes not pallindrome. aa-> ab
    //Case b. length is odd when 1 character is changed , element remains pallindrome. aaa-> aba
    if(count == 0 && n%2 !=0)
        return "YES" ;
        
    return "NO" ;    
    }
}

