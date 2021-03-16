public class Solution {
    public int evalRPN(ArrayList<String> A) {
        if(A.size() == 1)
            return Integer.parseInt(A.get(0) );
            
         int ans = 0 ;
        Stack<Integer> stk = new Stack();
        for(int i = 0 ; i < A.size() ; i++){
            String str = A.get(i) ;
            if(str.equals("*") || str.equals("/") || str.equals("+") || str.equals("-") ) {
                int b = stk.peek() ;
                stk.pop();
                int a = stk.peek() ;
                stk.pop();
                ans = solve(a , b , A.get(i) );
                stk.push(ans) ;
            }
            else{
                int num = Integer.parseInt(A.get(i) );
                stk.push(num);
            }
        }
    return ans ;    
    }
    
    public int solve(int a , int b , String op){
        if(op.equals("*") )
            return a*b ;
        else if(op.equals("/" ) )
            return a /b ;
        else if( op.equals("-") )
            return a-b ;
        else
            return a+b ;
            
    }
}
