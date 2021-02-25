public class Solution {
    public String longestCommonPrefix(String[] A) {
        int n = A.length ;
        int length = Integer.MAX_VALUE ;
        for(int i = 0 ; i < A.length ; i++)
            length = Math.min(A[i].length() , length );
            
        String str = A[0];
        int i = 0;
        String res="";
        while( i < length){
            char c = str.charAt(i) ;
           for(int j = 1 ; j < n ; j++){
               if(c != A[j].charAt(i) ){
                   return res;
               }
           }
           res = res + c;
           i++;
        }
    return res;
    }
}

