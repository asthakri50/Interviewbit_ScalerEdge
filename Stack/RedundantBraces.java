// Problem Description

// Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.

// Chech whether A has redundant braces or not.

// NOTE: A will be always a valid expression.



// Problem Constraints
// 1 <= |A| <= 105



// Input Format
// The only argument given is string A.



// Output Format
// Return 1 if A has redundant braces, else return 0.



// Example Input
// Input 1:

//  A = "((a+b))"
// Input 2:

//  A = "(a+(a+b))"


// Example Output
// Output 1:

//  1
// Output 2:

//  0
public class Solution {
    public int braces(String A) {
        Stack<Character> stk = new Stack();
        int n = A.length() ;
        
        for(int i = 0 ; i < n  ; i++){
            char ch = A.charAt(i) ;
            if(ch == ')' ){
                Stack<Character> temp = new Stack();
                 while(stk.peek() != '(' ){
                    temp.push(stk.peek() );
                    stk.pop();    
                 }
                stk.pop();
                if(temp.size() <= 1)
                    return 1;
            }
            stk.push(ch) ;
        }
        return  0 ;    
          
    }
}

