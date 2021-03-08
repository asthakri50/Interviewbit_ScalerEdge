public class Solution {
    public int solve(String A) {
        int n = A.length() ;
        ArrayList<Character> evenlist= new ArrayList<>();
        ArrayList<Character> oddlist= new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            if(A.charAt(i) % 2 == 0)
                evenlist.add(A.charAt(i) );
            else
                oddlist.add(A.charAt(i) );
        }

        Collections.sort(evenlist);
        Collections.sort(oddlist);

        int l1 = evenlist.size();
        int l2 = oddlist.size();

        if(Math.abs(evenlist.get(l1-1) - oddlist.get(0) ) != 1){
            return 1;
        }

        if(Math.abs(oddlist.get(l2-1) - evenlist.get(0) )  != 1){

            return 1;
        }


        return 0 ;

    }
}
